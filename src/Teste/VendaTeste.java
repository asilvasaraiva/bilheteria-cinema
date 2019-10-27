package Teste;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import conexao.Conexao;
import insumos.Filmes;
import insumos.GeraInsumos;
import vendas.Venda;
public class VendaTeste {

	@Test
	public void vendeFilme() {
		Conexao con = new Conexao();
		GeraInsumos  insumos = new GeraInsumos();
		
		try {
			insumos.setListaCedulas(con.getListaCedulas());
			insumos.setListaFilmes(con.getListaFilmes());
			insumos.setImpressora(con.getImpressora());
			insumos.setCaixa(con.getCaixa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultado = Venda.vendeFilme(insumos, 4, con);
		
		assertTrue(resultado);
	}
	
	@Test
	public void escolheFilme() {
		Conexao con = new Conexao();
		GeraInsumos  insumos = new GeraInsumos();
		try {
			insumos.setListaCedulas(con.getListaCedulas());
			insumos.setListaFilmes(con.getListaFilmes());
			insumos.setImpressora(con.getImpressora());
			insumos.setCaixa(con.getCaixa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultado = Filmes.exibeFilmes(insumos.getListaFilmes());
		assertTrue(resultado);
	}
	
	@Test
	public void geraTroco() {
		Conexao con = new Conexao();
		GeraInsumos  insumos = new GeraInsumos();
		try {
			insumos.setListaCedulas(con.getListaCedulas());
			insumos.setListaFilmes(con.getListaFilmes());
			insumos.setImpressora(con.getImpressora());
			insumos.setCaixa(con.getCaixa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultado = Venda.geraTroco(20.0f, 50.0f, 
							insumos.getListaCedulas(), con);
		assertTrue(resultado);
		}
	

}
