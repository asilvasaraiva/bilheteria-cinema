package fluxocaixa;

import insumos.Filmes;
import insumos.Impressora;

public class Caixa {
private int numVendas = 0;
private float valorTotal= 0;


public int getNumVendas() {
	return numVendas;
}
public void setNumVendas(int numVendas) {
	this.numVendas = numVendas;
}
public float getValorTotal() {
	return valorTotal;
}
public void setValorTotal(float valorTotal) {
	this.valorTotal = valorTotal;
}


public void fechaVenda(float preco, Filmes filmeEscolhido, Impressora impressora) {
	this.numVendas++;
	valorTotal+=preco;
	filmeEscolhido.subLugares(1);
	
	impressora.subQtd();
	
	
}
	
	
}
