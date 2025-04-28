package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import modelo.Participa;

class ParticipaTest {
	private Participa participa;

	private final int TEST_ID_CURSO = 1;
	private final String TEST_DNI_BAILARIN = "12345678A";
	private final Date TEST_FECHA_INICIO = Date.valueOf("2025-04-01");
	private final Date TEST_FECHA_FIN = Date.valueOf("2025-06-01");

	@BeforeEach
	void setUp() {
		// Inicializar una nueva instancia de Participa antes de cada test
		participa = new Participa();
		participa.setIdCurso(TEST_ID_CURSO);
		participa.setDniBailarin(TEST_DNI_BAILARIN);
		participa.setFechaInicio(TEST_FECHA_INICIO);
		participa.setFechaFin(TEST_FECHA_FIN);
	}

	@Test
	void testConstructorVacio() {
		Participa p = new Participa();
		assertNotNull(p);
		assertEquals(0, p.getIdCurso());
		assertNull(p.getDniBailarin());
		assertNull(p.getFechaInicio());
		assertNull(p.getFechaFin());
	}

	@Test
	void testGetSetIdCurso() {
		assertEquals(TEST_ID_CURSO, participa.getIdCurso());

		int nuevoIdCurso = 2;
		participa.setIdCurso(nuevoIdCurso);
		assertEquals(nuevoIdCurso, participa.getIdCurso());
	}

	@Test
	void testGetSetDniBailarin() {
		assertEquals(TEST_DNI_BAILARIN, participa.getDniBailarin());

		String nuevoDni = "87654321B";
		participa.setDniBailarin(nuevoDni);
		assertEquals(nuevoDni, participa.getDniBailarin());
	}

	@Test
	void testGetSetFechaInicio() {
		assertEquals(TEST_FECHA_INICIO, participa.getFechaInicio());

		Date nuevaFechaInicio = Date.valueOf("2025-05-01");
		participa.setFechaInicio(nuevaFechaInicio);
		assertEquals(nuevaFechaInicio, participa.getFechaInicio());
	}

	@Test
	void testGetSetFechaFin() {
		assertEquals(TEST_FECHA_FIN, participa.getFechaFin());

		Date nuevaFechaFin = Date.valueOf("2025-07-01");
		participa.setFechaFin(nuevaFechaFin);
		assertEquals(nuevaFechaFin, participa.getFechaFin());
	}

	@Test
	void testToString() {
		String resultado = participa.toString();

		assertTrue(resultado.contains("idCurso=" + TEST_ID_CURSO));
		assertTrue(resultado.contains("dniBailarin=" + TEST_DNI_BAILARIN));
		assertTrue(resultado.contains("fechaInicio=" + TEST_FECHA_INICIO.toString()));
		assertTrue(resultado.contains("fechaFin=" + TEST_FECHA_FIN.toString()));
	}
}