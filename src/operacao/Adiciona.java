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
			System.out.println("# 3|-> Adicionar papel a impressora");
			System.out.println("# 0|-> voltar");
			opcao = input.nextInt();
			
			switch(opcao) {
			  case 1:
				  
			    break;
			  case 2:
				 
			    break;
			  case 0:
				  break;
			  default:
			    // code block
			}
		}
	
	}
	
	public static void adicionaFilme(String nome, int duracao, int lugares, int preco,ArrayList<Filmes> listaFilmes ) {
		Filmes novo = new Filmes(nome, duracao, lugares, preco);
		listaFilmes.add(novo);		
	}
	
	public static void adicionaLugares(int nomeFilme,ArrayList<Filmes> listaFilmes, int qtd) {
		listaFilmes.get(nomeFilme).addLugares(qtd);
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
