package operacao;

import java.util.ArrayList;

import insumos.Cedulas;
import insumos.Filmes;

public class Manutencao {

	

	public static float calcDinheiroTotal(ArrayList<Cedulas> listaCedulas,boolean lista_dinheiro) {
		float resultado = 0;
		for(int i = 0; i<listaCedulas.size();i++) {
			resultado+=(listaCedulas.get(i).getQuantidade()*listaCedulas.get(i).getValor());
		}
		if(lista_dinheiro) {
			System.out.println("\nDinheiro Total da maquina: "+resultado);
		}
		
		return resultado;
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
