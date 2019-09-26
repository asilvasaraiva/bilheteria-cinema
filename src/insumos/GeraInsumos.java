package insumos;


import java.util.ArrayList;

import fluxocaixa.Caixa;

public class GeraInsumos {
private ArrayList<Filmes> listaFilmes = new ArrayList<Filmes>();
private ArrayList<Cedulas> listaCedulas = new ArrayList<Cedulas>();
private Impressora impressora;
private Caixa caixa = new Caixa();

public ArrayList<Filmes> geraListaFilmes(int qtd){
		for(int i = 0; i<qtd;i++) {
			Filmes filme = new Filmes("ABC "+i*13, i, i*30, i*2.5f);
			this.listaFilmes.add(filme);
		}
		return this.listaFilmes;
}
	
public ArrayList<Cedulas> geraListaCedulas(int qtd){
		Cedulas cedulaV = new Cedulas("25cents", 0.25f, qtd) ;
		Cedulas cedulaIV = new Cedulas("50cents", 0.50f, qtd) ;
		Cedulas cedulaIII = new Cedulas("1real", 1.0f, qtd) ;
		Cedulas cedulaII = new Cedulas("2reais", 2.0f, qtd) ;
		Cedulas cedulaI = new Cedulas("5reais", 5.0f, qtd) ;
		
		this.listaCedulas.add(cedulaI);
		this.listaCedulas.add(cedulaII);
		this.listaCedulas.add(cedulaIII);
		this.listaCedulas.add(cedulaIV);
		this.listaCedulas.add(cedulaV);
		return this.listaCedulas;
	}

public Impressora geraImpressora(int qtd) {
	 this.impressora = new Impressora("Impressora", qtd);
	return impressora;
}

public ArrayList<Filmes> getListaFilmes() {
	return listaFilmes;
}

public void setListaFilmes(ArrayList<Filmes> listaFilmes) {
	this.listaFilmes = listaFilmes;
}

public ArrayList<Cedulas> getListaCedulas() {
	return listaCedulas;
}

public void setListaCedulas(ArrayList<Cedulas> listaCedulas) {
	this.listaCedulas = listaCedulas;
}

public Impressora getImpressora() {
	return impressora;
}

public void setImpressora(Impressora impressora) {
	this.impressora = impressora;
}

public Caixa getCaixa() {
	return caixa;
}

public void setCaixa(Caixa caixa) {
	this.caixa = caixa;
}



}
