package operacao;

import java.util.ArrayList;
import java.util.Scanner;

import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.Filmes;
import insumos.GeraInsumos;
import insumos.Impressora;

public class Adiciona {

	public static void mod_AdicionaProd(GeraInsumos  insumos) {
		
	
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
				  adicionaFilme(insumos.getListaFilmes());
			    break;
			  case 2:
				  System.out.println("Lista de Filmes e lugares disponíveis");
				  Filmes.exibeFilmes(insumos.getListaFilmes());
				  System.out.println("Escolha o numero da sala para adicionar mais lugares");
				  opcao = input.nextInt(); 
				  adicionaLugares(opcao,insumos.getListaFilmes());
			    break;
			  case 3:
				  adicionaPapel(insumos.getImpressora());
				  break;
			  case 4:
				  adicionaDinheiro(insumos.getListaCedulas());
				  break;
			  case 0:
				  break;
			  default:
			    // code block
				  System.out.println("Valor informado inválido, por favor escolha um dos valores disponíveis\n");
			}
		}
	
	}
	
	public static void adicionaFilme(ArrayList<Filmes> listaFilmes ) {
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
		listaFilmes.add(novo);	
		System.out.println("##Filme "+novo.getNome()+ " cadastrado com sucesso##");
	}
	
	public static void adicionaLugares(int nomeFilme,ArrayList<Filmes> listaFilmes) {
		int qtd=0;
		Scanner input = new Scanner(System.in);
		System.out.println("#Digite quantos lugares deseja adicionar: ");
		qtd= input.nextInt();
		listaFilmes.get(nomeFilme).addLugares(qtd);
		System.out.println("#Lugares Adicionados com sucesso");
	}
	
	public static void adicionaPapel(Impressora impressora){
		Scanner input = new Scanner(System.in); 
		
		System.out.println("A impressora "+ impressora.getNome()+ " ainda possui "+ 
		impressora.getQuantidade()+ " impressores restantes");
		System.out.println("#Digite quantos lugares deseja adicionar: ");
		int qtd= input.nextInt();
		impressora.addPapel(qtd);
		System.out.println("##Papel adicionado com sucesso##");
	}
	public static void subtraiFilme(String nome,ArrayList<Filmes> listaFilmes ) {
		for(int i = 0; i<listaFilmes.size();i++) {
			if(listaFilmes.get(i).getNome()==nome) {
				listaFilmes.remove(i);
			}
		}
	}	
	
	public static void adicionaDinheiro( ArrayList<Cedulas> listaCedulas) {
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
		
		System.out.println("##Adicao de moeda/cedula realizada com sucesso##");
	}
	
	public static void subtraiDinheiro(float valor, ArrayList<Cedulas> listaCedulas, int qtd) {
		for(int i = 0; i<listaCedulas.size();i++) {
			if(listaCedulas.get(i).getValor()==qtd) {
				listaCedulas.get(i).subQuantidade(qtd);
			}
		}
	}
	
}
