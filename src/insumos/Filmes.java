package insumos;

public class Filmes {
private String nome;
private int duracao;
private int lugares;
private float preco;


public Filmes(String nome, int duracao, int lugares, float preco) {
	super();
	this.nome = nome;
	this.duracao = duracao;
	this.lugares = lugares;
	this.preco = preco;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getDuracao() {
	return duracao;
}
public void setDuracao(int duracao) {
	this.duracao = duracao;
}
public int getLugares() {
	return lugares;
}
public void setLugares(int lugares) {
	this.lugares = lugares;
}
public float getPreco() {
	return preco;
}
public void setPreco(float preco) {
	this.preco = preco;
}


}