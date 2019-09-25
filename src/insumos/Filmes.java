package insumos;

import java.util.ArrayList;

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

public void addLugares(int qtd) {
	this.lugares+=qtd;
}
public void subLugares(int qtd) {
	this.lugares-=qtd;
}

public static void exibeFilmes(ArrayList<Filmes> listaFilmes) {
	for(int i = 0; i<listaFilmes.size();i++) {
		System.out.println("Filme na sala "+i+"|-> "+listaFilmes.get(i).getNome()+ " com "+ listaFilmes.get(i).lugares +" lugares disponiveis, valor:"+ listaFilmes.get(i).getPreco());
	}
	}
}


