package operacao;

import java.util.Scanner;

import conexao.Conexao;
import fluxocaixa.Caixa;
import insumos.GeraInsumos;
import relatorio.Relatorios;

public class Manutencao {

	
public static void mod_Manutencao(GeraInsumos  insumos, String senha,Conexao con) {
		
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
				  Adiciona.mod_AdicionaProd(insumos,con);
			    break;
			  case 2:
				 Relatorios.mod_Relatorios(insumos);
			    break;
			  case 0:
				  break;
			  default:
			    // code block
				  System.out.println("Valor informado inválido, por favor escolha um dos valores disponíveis\n");
			}
		}
	}else {
		System.out.println("### Senha invalida ### ");
	}
}
	
}
