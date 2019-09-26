package insumos;

public class Impressora {
private String nome;
private int quantidade;

public Impressora() {
	
}
public Impressora(String nome, int quantidade) {
	super();
	this.nome = nome;
	this.quantidade = quantidade;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}

public void subQtd() {
	this.quantidade--;
}

public void addPapel(int qtd) {
	this.quantidade+=qtd;
}
}
