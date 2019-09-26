package operacao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import conexao.Conexao;
import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.Filmes;
import insumos.GeraInsumos;
import insumos.Impressora;

public class Adiciona {

	public static void mod_AdicionaProd(GeraInsumos  insumos, Conexao con) {
		
	
		System.out.println("\n");
		Scanner input = new Scanner(System.in);
		int opcao  = 1;
		while(opcao>0) {
			System.out.println("\n#------------- #Modulo Manutencao {Adiciona Produtos} -----------");
			System.out.println("# Escolha a opcao desejada:");
			System.out.println("# 1|-> Adicionar Novo Filme");
			System.out.println("# 2|-> Adicionar Lugar para um filme");
			System.out.println("# 3|-> Adicionar Papel a impressora");
			System.out.println("# 4|-> Adicionar Dinheiro");
			System.out.println("# 0|-> voltar");
			opcao = input.nextInt();
			
			switch(opcao) {
			  case 1:
				  adicionaFilme(insumos.getListaFilmes(),con);
			    break;
			  case 2:
				  System.out.println("Lista de Filmes e lugares disponíveis");
				  Filmes.exibeFilmes(insumos.getListaFilmes());
				  System.out.println("Escolha o numero da sala para adicionar mais lugares");
				  opcao = input.nextInt(); 
				  adicionaLugares(opcao,insumos.getListaFilmes(),con);
			    break;
			  case 3:
				  adicionaPapel(insumos.getImpressora(),con);
				  break;
			  case 4:
				  adicionaDinheiro(insumos.getListaCedulas(),con);
				  break;
			  case 0:
				  break;
			  default:
			    // code block
				  System.out.println("Valor informado inválido, por favor escolha um dos valores disponíveis\n");
			}
		}
	
	}
	
	public static void adicionaFilme(ArrayList<Filmes> listaFilmes,Conexao con ) {
		String nome;
		int duracao,lugares;
		float preco;
		Scanner input = new Scanner(System.in);
		System.out.println("#Digite o Nome do filme: ");
		nome = input.nextLine();
		System.out.println("#Digite a duracao do filme: ");
		duracao = input.nextInt(); 
		System.out.println("#Digite o numero de assentos para este filme: ");
		lugares = input.nextInt();
		System.out.println("#Digite o preço filme: ");
		preco = input.nextFloat(); 
		
		Filmes novo = new Filmes(nome, duracao, lugares, preco);
		try {
			listaFilmes.add(novo);	
			con.insertFilme(novo);
			System.out.println("##Filme "+novo.getNome()+ " cadastrado com sucesso##");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##Filme "+novo.getNome()+ " não realizada, por favor tente novamente##");
		}
		
		
	}
	
	public static void adicionaLugares(int nomeFilme,ArrayList<Filmes> listaFilmes,Conexao con) {
		int qtd=0;
		Scanner input = new Scanner(System.in);
		System.out.println("#Digite quantos lugares deseja adicionar: ");
		qtd= input.nextInt();
		
		try {
			listaFilmes.get(nomeFilme).addLugares(qtd);
			con.updateLugaresFilme(listaFilmes.get(nomeFilme));
			System.out.println("##Lugares Adicionados com sucesso##");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##Erro ao adicionar Lugar, favor tentar novamente##");
		}
		
		
	}
	
	public static void adicionaPapel(Impressora impressora,Conexao con){
		Scanner input = new Scanner(System.in); 
		
		System.out.println("A impressora "+ impressora.getNome()+ " ainda possui "+ 
		impressora.getQuantidade()+ " impressores restantes");
		System.out.println("#Digite quantos bilhetes deseja adicionar: ");
		int qtd= input.nextInt();
		try {
			impressora.addPapel(qtd);
			con.updatePapelImpressora(impressora);
			System.out.println("##Papel adicionado com sucesso##");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##Papel não adicionado com sucesso, favor tente novamente##");
		}
		
		
	}
	public static void subtraiFilme(String nome,ArrayList<Filmes> listaFilmes ) {
		for(int i = 0; i<listaFilmes.size();i++) {
			if(listaFilmes.get(i).getNome()==nome) {
				listaFilmes.remove(i);
			}
		}
	}	
	
	public static void adicionaDinheiro( ArrayList<Cedulas> listaCedulas,Conexao con) {
		Scanner input = new Scanner(System.in);
		
		int qtd, index;
		System.out.println("Selecione uma das bandeijas abaixo para repor as quantidades");
		
		//Exibir lista de "Dinheiro" e suas quantidades:
		for(int i = 0; i<listaCedulas.size();i++) {
			
		System.out.println("Bandeija "+i+"|-> Cedula/moeda de "+listaCedulas.get(i).getDescricao()+
				" possui "+listaCedulas.get(i).getQuantidade()+" unidades");	
		}
		
		System.out.println("Digite o numero da bandeija a inserir: ");
		index = input.nextInt();
		System.out.println("Digite a quantidade de moeda/cedula a ser inserida: ");
		qtd = input.nextInt();
		
		listaCedulas.get(index).addQuantidade(qtd);
		Cedulas cedula = listaCedulas.get(index);
		
		try {
			con.updateCedulas(cedula);
			System.out.println("##Adicao de moeda/cedula realizada com sucesso##");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##Adicao de moeda/cedula não realizada, por favor tente novamente##");
		}
		
		
	}
	
	public static void subtraiDinheiro(float valor, ArrayList<Cedulas> listaCedulas, int qtd) {
		for(int i = 0; i<listaCedulas.size();i++) {
			if(listaCedulas.get(i).getValor()==qtd) {
				listaCedulas.get(i).subQuantidade(qtd);
			}
		}
	}
	
}
