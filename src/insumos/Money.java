package insumos;

public class Money {
private String descricao;
private float valor;
private int quantidade;

public Money(String descricao, float valor, int quantidade) {
	super();
	this.descricao = descricao;
	this.valor = valor;
	this.quantidade = quantidade;
}

public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}



}
