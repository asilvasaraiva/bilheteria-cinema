package insumos;


import java.util.ArrayList;

public class GeraInsumos {
private ArrayList<Filmes> listaFilmes;
private ArrayList<Cedulas> listaCedulas;


public ArrayList<Filmes> geraListaFilmes(int qtd){
		for(int i = 0; i<qtd;i++) {
			Filmes filme = new Filmes("ABC "+i, i, i*30, i*2.3f);
			this.listaFilmes.add(filme);
		}
		return this.listaFilmes;
}
	
public ArrayList<Cedulas> geraListaCedulas(int qtd){
		Cedulas cedulaI = new Cedulas("25cents", 0.25f, qtd) ;
		Cedulas cedulaII = new Cedulas("50cents", 0.50f, qtd) ;
		Cedulas cedulaIII = new Cedulas("1real", 1.0f, qtd) ;
		Cedulas cedulaIV = new Cedulas("2reais", 2.0f, qtd) ;
		Cedulas cedulaV = new Cedulas("5reais", 5.0f, qtd) ;
		
		this.listaCedulas.add(cedulaI);
		this.listaCedulas.add(cedulaII);
		this.listaCedulas.add(cedulaIII);
		this.listaCedulas.add(cedulaIV);
		this.listaCedulas.add(cedulaV);
		return this.listaCedulas;
	}

public Impressora geraImpressora(int qtd) {
	Impressora impressora = new Impressora("Impressora", qtd);
	return impressora;
}
}
