package operacao;

import java.util.ArrayList;
import java.util.Scanner;

import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.Filmes;
import insumos.GeraInsumos;
import relatorio.Relatorios;

public class Manutencao {

	
public static void mod_Manutencao(GeraInsumos  insumos, Caixa caixa, String senha) {
		
	if(senha.equalsIgnoreCase("admin")) {
		System.out.println("\n");
		Scanner input = new Scanner(System.in);
		int opcao  = 1;
		while(opcao>0) {
			System.out.println("\n#-------------Sistema de Bilheteria Digital #Modulo Manutencao -----------");
			System.out.println("# Escolha a opcao desejada:");
			System.out.println("# 1|-> Adicionar Produtos");
			System.out.println("# 2|-> Relatorios");
			System.out.println("# 0|-> Voltar ao menu principal");
			
			opcao = input.nextInt();
			
			switch(opcao) {
			  case 1:
				  Adiciona.mod_AdicionaProd(insumos);
			    break;
			  case 2:
				 Relatorios.mod_Relatorios(insumos,caixa);
			    break;
			  case 0:
				  break;
			  default:
			    // code block
			}
		}
	}else {
		System.out.println("### Senha invalida ### ");
	}
}
	
}
