package operacao;

import java.util.ArrayList;

import insumos.Cedulas;
import insumos.Filmes;

public class Manutencao {

	

	public static float calcDinheiroTotal(ArrayList<Cedulas> listaCedulas) {
		float resultado = 0;
		for(int i = 0; i<listaCedulas.size();i++) {
			resultado+=(listaCedulas.get(i).getQuantidade()*listaCedulas.get(i).getValor());
		}
		System.out.println("\nDinheiro Total da maquina: "+resultado);
		return resultado;
	}
	
	public static void adicionaFilme(String nome, int duracao, int lugares, int preco,ArrayList<Filmes> listaFilmes ) {
		Filmes novo = new Filmes(nome, duracao, lugares, preco);
		listaFilmes.add(novo);		
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
