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
		ArrayList<Cedulas> cedulas = insumos.geraListaCedulas(10);
		
		Venda teste = new Venda();
		
		int[] troco =  teste.calculaTroco(0, 70.25f, cedulas);
		
		System.out.println(troco[0]);
		System.out.println(troco[1]);
		System.out.println(troco[2]);
		System.out.println(troco[3]);
		System.out.println(troco[4]);
	}

}
