package fluxocaixa;


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


public void fechaVenda(float preco) {
	this.numVendas++;
	valorTotal+=preco;
	
}
	
	
}
