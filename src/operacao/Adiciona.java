package operacao;

import java.util.ArrayList;
import java.util.Scanner;

import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.Filmes;
import insumos.GeraInsumos;

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
			System.out.println("# 4|-> Adicionar Dinheiro na maquina");
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
			  case 0:
				  break;
			  default:
			    // code block
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
		System.out.println("Filme "+novo.getNome()+ " cadastrado com sucesso");
	}
	
	public static void adicionaLugares(int nomeFilme,ArrayList<Filmes> listaFilmes) {
		int qtd=0;
		Scanner input = new Scanner(System.in);
		System.out.println("#Digite quantos lugares deseja adicionar: ");
		qtd= input.nextInt();
		listaFilmes.get(nomeFilme).addLugares(qtd);
		System.out.println("#Lugares Adicionados com sucesso");
	}
	
	public static void subtraiFilme(String nome,ArrayList<Filmes> listaFilmes ) {
		for(int i = 0; i<listaFilmes.size();i++) {
			if(listaFilmes.get(i).getNome()==nome) {
				listaFilmes.remove(i);
			}
		}
	}	
	
	public static void adicionaDinheiro(float valor, ArrayList<Cedulas> listaCedulas, int qtd) {
		for(int i = 0; i<listaCedulas.size();i++) {
			if(listaCedulas.get(i).getValor()==qtd) {
				listaCedulas.get(i).addQuantidade(qtd);
			}
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
