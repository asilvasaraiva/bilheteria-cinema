package relatorio;

import java.util.ArrayList;
import java.util.Scanner;

import fluxocaixa.Caixa;
import insumos.Cedulas;
import insumos.GeraInsumos;
import insumos.Impressora;

public class Relatorios {

	
	
	public static void mod_Relatorios(GeraInsumos  insumos, Caixa caixa) {
		
		
		System.out.println("\n");
		Scanner input = new Scanner(System.in);
		int opcao  = 1;
		while(opcao>0) {
			System.out.println("\n#------------- #Modulo Manutencao {Relatorio de Produtos} -----------");
			System.out.println("# Escolha a opcao desejada:");
			System.out.println("# 1|-> Vendas contabilizadas");
			System.out.println("# 2|-> Quantidade cedulas/moedas disponiveis");
			System.out.println("# 3|-> Impressões restantes na impressora");
			System.out.println("# 0|-> voltar");
			opcao = input.nextInt();
			
			switch(opcao) {
			  case 1: 
				  relatorioVendas(caixa);
			    break;
			  case 2:
				  relatorioCedulas(insumos.getListaCedulas());
			    break;
			  case 3:
				  relatorioImpressoes(insumos.getImpressora());  
			  case 0:
				  break;
			  default:
			    // code block
			}
		}
	
}
	
	public static void relatorioVendas(Caixa caixa) {
		System.out.println("Numero de vendas realizadas: "+caixa.getNumVendas());
		System.out.println("Valor total das vendas: "+caixa.getValorTotal());
	}
	
	public static void relatorioCedulas(ArrayList<Cedulas> listaCedulas) {
		System.out.println("Unidades disponiveis de cada valor: ");
		for(int i = 0; i<5;i++) {
				System.out.println("Notas/moedas de "+listaCedulas.get(i).getDescricao()+": "+listaCedulas.get(i).getQuantidade());		
		}
	}
	
	public static void relatorioImpressoes(Impressora impressora) {
		System.out.println("Numero de impressões restantes: "+ impressora.getQuantidade());	
	}
	
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
	

}
