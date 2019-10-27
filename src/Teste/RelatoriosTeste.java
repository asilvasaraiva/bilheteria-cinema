package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import insumos.GeraInsumos;
import relatorio.Relatorios;

public class RelatoriosTeste {

	Relatorios r;
	@Before
	public void setUp() throws Exception {
		r = new Relatorios ();
	}

	GeraInsumos insumo = new GeraInsumos();
	
	@Test
	public void testCalcDinheiroTotal() {
		assertEquals(100, r.calcDinheiroTotal(insumo.getListaCedulas(), false));
	}

}
