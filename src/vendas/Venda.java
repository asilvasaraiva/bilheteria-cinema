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
		float resto,troco = (dinheiroRecebido - valorFilme);
		int valorReal5, valorReal2,valorReal1,valorReal50c,valorReal25c, resultado;
		int[] cedulas = new int[5];
		for(int i = 0; i<listaCedulas.size();i++) {	
			if(troco==0) {
				break;
			}else if((troco / listaCedulas.get(i).getValor())>0){
				cedulas[i] =  (int) (troco / listaCedulas.get(i).getValor());
				System.out.println("Cedula "+i+" :"+cedulas[i]);
				resto = troco % listaCedulas.get(i).getValor();
				System.out.println("resto:"+resto);
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
			valorReal2 += resultado* 2; // multiplica o que sobra pelo valor do menor seguinte.
			valorReal1++;
			cedulas[0] = listaCedulas.get(0).getQuantidade();// valor total que tinha 
			cedulas[1] = valorReal2; //prox valor (2reai no caso) tem seu numero aumentado pela quantidade total pra formar 5 (2x2) + 1 de um real
			cedulas[2]++; //incrementando a quantidade de 1 real necessario para completar o 5 reais
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
	
}
