package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import modelo.Participa;

class Prueba {

	@Test
	void testGetIdCurso() throws Exception{
		Participa par = new Participa();
		par.setIdCurso(1);
		assertEquals(1, par.getIdCurso());
		assertTrue(1==par.getIdCurso());
	}
	
	@Test
	void testGetTipo() throws Exception{
		Participa par = new Participa();
		par.setDniBailarin("1A");
		assertEquals("1A", par.getDniBailarin());
		assertTrue("1A"==par.getDniBailarin());
	}
	
}
