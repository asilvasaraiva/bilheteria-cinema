package vendas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import conexao.Conexao;
import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.Filmes;
import insumos.GeraInsumos;
import operacao.Manutencao;
import relatorio.Relatorios;

public class Venda {

	
	public static void mod_Venda(GeraInsumos  insumos,Conexao con) {
		
		System.out.println("\n");
		Scanner input = new Scanner(System.in);
		int opcao  = 1;
		while(opcao>0) {
			System.out.println("\n#-------------Sistema de Bilheteria Digital #Modulo Vendas -----------");
			System.out.println("# Escolha a opcao desejada: ");
			System.out.println("# 1|-> Visualizar lista de filmes");
			System.out.println("# 2|-> Escolher Filme");
			System.out.println("# 0|-> Voltar ao menu principal");
			
			opcao = input.nextInt();
			
			switch(opcao) {
			  case 1:
				  Filmes.exibeFilmes(insumos.getListaFilmes());
			    break;
			  case 2:
				  Filmes.exibeFilmes(insumos.getListaFilmes());
				  System.out.println("\n#Informe qual o numero da sala: ");
				  opcao = input.nextInt();
				  if(opcao>insumos.getListaFilmes().size()) {
					  System.out.println("###Sala Escolhida não existe###");
					  break;
				  }else {
				  vendeFilme(insumos, opcao,con);
				  }
			    break;
			  case 0:
				  break;
			  default:
			    // code block
			}
		}
	}
	
	
	public static boolean geraTroco(float valorFilme, float dinheiroRecebido, ArrayList<Cedulas> listaCedulas,Conexao con) {
		
		if(valorFilme > dinheiroRecebido) {
			System.out.println("Dinheiro Insuficiente para o filme escolhido");
			return false;
		}else if ((dinheiroRecebido - valorFilme) >Relatorios.calcDinheiroTotal(listaCedulas,false)) {
			System.out.println("Dinheiro Na maquina Insuficiente para gerar troco");
			return false;
		}
		
		int[] calculaTroco = calculaTroco(valorFilme, dinheiroRecebido, listaCedulas);
		if(calculaTroco!=null) {
			System.out.println("Troco disponibilizado em: ");
			for(int i = 0; i<5;i++) {
				listaCedulas.get(i).subQuantidade(calculaTroco[i]);//subtrai os valores do troco da base
				
				if(calculaTroco[i]>0) {
					System.out.println(calculaTroco[i]+" notas/moedas de: "+listaCedulas.get(i).getDescricao());
					try {
						con.updateCedulas(listaCedulas.get(i));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
			return true;
		}
		return false;
	}
	
	public static int[] calculaTroco(float valorFilme, float dinheiroRecebido, ArrayList<Cedulas> listaCedulas) {
		
		//Manutencao.calcDinheiroTotal(listaCedulas);
		System.out.println("Dinheiro Recebido:"+dinheiroRecebido);
		float resto,troco = (dinheiroRecebido - valorFilme);
		System.out.println("Troco: "+troco);
		int valorReal5, valorReal2,valorReal1,valorReal50c,valorReal25c, resultado;
		int[] cedulas = new int[5];
		for(int i = 0; i<listaCedulas.size();i++) {	
			if(troco==0) {
				break;
			}else if((troco / listaCedulas.get(i).getValor())>0){
				cedulas[i] =  (int) (troco / listaCedulas.get(i).getValor());
				//System.out.println("Cedula "+i+" :"+cedulas[i]);
				resto = troco % listaCedulas.get(i).getValor();
				//System.out.println("resto:"+resto);
				troco = resto;
				}
			}
		//calcular a proporção de unidades, caso nao tenha de 5, utilizar 2 de 2+ 2 de 0,50
		valorReal5 = cedulas[0];
		valorReal2 = cedulas[1];
		valorReal1 = cedulas[2];
		valorReal50c = cedulas[3];
		valorReal25c = cedulas[4];	
		//verificando se o que eu preciso é maior que o que tem, se sim, pega o que tem 
		//e o resto adiciona a qantidade do proximo valor que é menor.
		if((valorReal5 - listaCedulas.get(0).getQuantidade())>0) {
			resultado = valorReal5 - listaCedulas.get(0).getQuantidade();//pega quanto sobra
			valorReal2 += resultado*2; // multiplica por 2 pois 1 cedula de 5
			valorReal1 +=resultado;
			cedulas[0] = listaCedulas.get(0).getQuantidade();// valor total que tinha 
			cedulas[1] = valorReal2; //prox valor (2reai no caso) tem seu numero aumentado pela quantidade total pra formar 5 (2x2) + 1 de um real
			cedulas[2] =valorReal1; //incrementando a quantidade de 1 real necessario para completar o 5 reais
		}
		if((valorReal2 - listaCedulas.get(1).getQuantidade())>0) {
			resultado = valorReal2 - listaCedulas.get(0).getQuantidade();
			valorReal1 += resultado* 2;//recebe quanto falta pras notas de 2.
			cedulas[1] = listaCedulas.get(1).getQuantidade();// quantidade de 2 atualizada para o valor que tem no banco
			cedulas[2] =valorReal1;//qtd de 1 real é atualizada 
		}
		if((valorReal1 - listaCedulas.get(2).getQuantidade())>0) {
			resultado = valorReal1 - listaCedulas.get(2).getQuantidade();
			valorReal50c += resultado* 2;
			cedulas[2] = listaCedulas.get(2).getQuantidade();
			cedulas[3] =valorReal50c; 
		}
		if((valorReal50c - listaCedulas.get(3).getQuantidade())>0) {
			resultado = valorReal50c - listaCedulas.get(3).getQuantidade();
			valorReal25c += resultado* 2;
			cedulas[3] = listaCedulas.get(2).getQuantidade();
			cedulas[4] =valorReal25c; 
		}
		if((valorReal25c - listaCedulas.get(4).getQuantidade())>0) {
			System.out.println("Dinheiro na maquina insuficiente para gerar troco. Desculpe a inconveniencia");	
			return null;
		}else {
			cedulas[4] = valorReal25c;
		}
		
		return cedulas;
	}
	
	
	
	public static boolean vendeFilme(GeraInsumos  insumos, int filmeEscolhido,Conexao con) {
		Filmes filme = insumos.getListaFilmes().get(filmeEscolhido);
		System.out.println(filme.getNome());
		if(filme.getLugares()<=0) {
			System.out.println("Numero de lugares esgotados para esse filme, por favor escolha outro");
			return false;
		}else if(insumos.getImpressora().getQuantidade()<1) {		 
			System.out.println("Papel Insuficiente na impressora para imprimir o ticket");
			return false;
		}else{
			Scanner input = new Scanner(System.in);
			float dinheiro;
			System.out.println("#Insira o dinheiro: ");
			dinheiro = input.nextFloat();
			if(filme.getPreco()> dinheiro) {
				System.out.println("Dinheiro Insuficiente para reservar o filme");
				
			}else if(Venda.geraTroco(filme.getPreco(),dinheiro,insumos.getListaCedulas(),con)) {	
		
			try {
				insumos.getCaixa().fechaVenda(filme.getPreco(),filme,insumos.getImpressora());
				con.updateCaixa(insumos.getCaixa());
				con.updatePapelImpressora(insumos.getImpressora());
				con.updateLugaresFilme(filme);
				System.out.println("##Venda realizada com sucesso, obrigado e aproveite o filme.##\n");
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}

	}
		return false;
}

}