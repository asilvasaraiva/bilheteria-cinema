package vendas;

import java.util.ArrayList;

import insumos.Cedulas;
import insumos.GeraInsumos;

public class Venda {

	//private GeraInsumos insumos = new GeraInsumos();
	
	public int geraTroco(float valorFilme, float dinheiroRecebido, ArrayList<Cedulas> listaCedulas) {
		
		if(valorFilme > dinheiroRecebido) {
			System.out.println("Dinheiro Insuficiente para o filme escolhido");
			return 0;
		}else if ((dinheiroRecebido - valorFilme) >calcDinheiroTotal(listaCedulas)) {
			System.out.println("Dinheiro Na maquina Insuficiente para gerar troco");
			return 0;
		}
		
		return 0;
	}
	
	
	public static float calcDinheiroTotal(ArrayList<Cedulas> listaCedulas) {
		float resultado = 0;
		for(int i = 0; i<listaCedulas.size();i++) {
					resultado=+(listaCedulas.get(i).getQuantidade()*listaCedulas.get(i).getValor());
		}		
		return resultado;
	}
	
	public int[] calculaTroco(float valorFilme, float dinheiroRecebido, ArrayList<Cedulas> listaCedulas) {
		float troco = (dinheiroRecebido - valorFilme);
		float resto,inteiro = 0;
		int[] unidades = new int[4];
		unidades[0] = 0;
		unidades[1] = 0;
		unidades[2] = 0;
		unidades[3] = 0;
		for(int i = 0; i<listaCedulas.size();i++) {
			
			if(troco==0) {
				break;
			}else if((troco / listaCedulas.get(i).getValor())>0){
				unidades[i] =  (int) (troco / listaCedulas.get(i).getValor());
				resto = troco % listaCedulas.get(i).getValor();
				troco = resto;
				}
			}
		
			
		return unidades;
	}
	
}
