package geral;

import java.util.ArrayList;

import conexao.Conexao;
import insumos.Cedulas;
import insumos.GeraInsumos;
import vendas.Venda;

public class main {

	public static void main(String[] args) {
		//Conexao con = new Conexao();
		GeraInsumos  insumos = new GeraInsumos();
		ArrayList<Cedulas> cedulas = insumos.geraListaCedulas(9);
		
		Venda teste = new Venda();
		
		int[] troco =  teste.geraTroco(0, 23.25f, cedulas);
		if(troco!=null) {
		System.out.println("\ncedulas de 5,00 R$: "+troco[0]);
		System.out.println("cedulas de 2,00 R$: "+troco[1]);
		System.out.println("cedulas de 1,00 R$: "+troco[2]);
		System.out.println("cedulas de 0,50 R$: "+troco[3]);
		System.out.println("cedulas de 0,25 R$: "+troco[4]);
		}
	}

}
