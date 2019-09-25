package geral;

import java.util.ArrayList;
import java.util.Scanner;

import conexao.Conexao;
import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.Filmes;
import insumos.GeraInsumos;
import operacao.Manutencao;
import vendas.Venda;

public class main {

	public static void main(String[] args) {
		//Conexao con = new Conexao();
		GeraInsumos  insumos = new GeraInsumos();
		Caixa caixa = new Caixa();
		Scanner input = new Scanner(System.in);
		int opcao = 1;
		String senha = "";
		
		insumos.geraListaFilmes(4);
		insumos.geraImpressora(30);
		insumos.geraListaCedulas(9);
		
		/*
		Venda teste = new Venda();
		
		int[] troco =  teste.geraTroco(0, 23.25f, cedulas);
		if(troco!=null) {
		System.out.println("\ncedulas de 5,00 R$: "+troco[0]);
		System.out.println("cedulas de 2,00 R$: "+troco[1]);
		System.out.println("cedulas de 1,00 R$: "+troco[2]);
		System.out.println("cedulas de 0,50 R$: "+troco[3]);
		System.out.println("cedulas de 0,25 R$: "+troco[4]);
		}*/
		
		while(opcao>0) {
			System.out.println("\n#-------------Sistema de Bilheteria Digital-----------#");
			System.out.println("# Escolha o modulo desejado:");
			System.out.println("# 1|-> Venda de Ingresso");
			System.out.println("# 2|-> Operações da maquina");
			System.out.println("# 0|-> Encerrar sistema");
			opcao = input.nextInt();
			
			switch(opcao) {
			  case 1:
			    // code block
				  Venda.mod_Venda(insumos,caixa);
			    break;
			  case 2:
				  System.out.println("#Digite a senha: ");
				  senha = input.next();
				 Manutencao.mod_Manutencao(insumos,caixa,senha);
			    break;
			  case 0:
				  break;
			  default:
				  System.out.println("Valor informado inválido, por favor escolha um dos valores disponíveis\n");
			}
		}
		  System.out.println("#####Obrigado por utilizar nosso sistema.######");
	}

}
