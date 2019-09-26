package geral;

import java.sql.SQLException;
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
		Conexao con = new Conexao();
		
		
		
		GeraInsumos  insumos = new GeraInsumos();
		
		Scanner input = new Scanner(System.in);
		int opcao = 1;
		String senha = "";
		
		//insumos.geraListaFilmes(4);
		//insumos.geraImpressora(30);
		//insumos.geraListaCedulas(9);
		
		try {
			insumos.setListaCedulas(con.getListaCedulas());
			insumos.setListaFilmes(con.getListaFilmes());
			insumos.setImpressora(con.getImpressora());
			insumos.setCaixa(con.getCaixa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
				  Venda.mod_Venda(insumos,con);
			    break;
			  case 2:
				  System.out.println("#Digite a senha: ");
				  senha = input.next();
				 Manutencao.mod_Manutencao(insumos,senha,con);
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
