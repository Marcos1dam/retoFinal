package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Curso;
import modelo.Nivel;

class CursoTest {
	private Curso curso;
	private final int TEST_ID_CURSO = 1;
	private final String TEST_TIPO = "Básico";
	private final Time TEST_HORARIO = Time.valueOf("10:00:00");
	private final Nivel TEST_NIVEL = Nivel.PRINCIPIANTE; // Cambié a Nivel.PRINCIPIANTE
	private final float TEST_PRECIO = 150.0f;
	private final int TEST_PLAZAS = 20;
	private final Date TEST_FECHA_INICIO = Date.valueOf("2025-06-01");
	private final Date TEST_FECHA_FIN = Date.valueOf("2025-06-30");
	private final int TEST_ID_PROFESOR = 101;

	@BeforeEach
	void setUp() {
		curso = new Curso();
		curso.setIdCurso(TEST_ID_CURSO);
		curso.setTipo(TEST_TIPO);
		curso.setHorario(TEST_HORARIO);
		curso.setNivel(TEST_NIVEL); // Asignamos el nivel PRINCIPIANTE
		curso.setPrecio(TEST_PRECIO);
		curso.setPlazas(TEST_PLAZAS);
		curso.setFechaInicio(TEST_FECHA_INICIO);
		curso.setFechaFin(TEST_FECHA_FIN);
		curso.setIdProfesor(TEST_ID_PROFESOR);
	}

	@Test
	void testGetSetIdCurso() {
		assertEquals(TEST_ID_CURSO, curso.getIdCurso());

		curso.setIdCurso(2);
		assertEquals(2, curso.getIdCurso());
	}

	@Test
	void testGetSetTipo() {
		assertEquals(TEST_TIPO, curso.getTipo());

		String nuevoTipo = "Avanzado";
		curso.setTipo(nuevoTipo);
		assertEquals(nuevoTipo, curso.getTipo());
	}

	@Test
	void testGetSetHorario() {
		assertEquals(TEST_HORARIO, curso.getHorario());

		Time nuevoHorario = Time.valueOf("14:00:00");
		curso.setHorario(nuevoHorario);
		assertEquals(nuevoHorario, curso.getHorario());
	}

	@Test
	void testGetSetNivel() {
		assertEquals(TEST_NIVEL, curso.getNivel());

		// Cambiar el nivel a MEDIO
		Nivel nuevoNivel = Nivel.MEDIO;
		curso.setNivel(nuevoNivel);
		assertEquals(nuevoNivel, curso.getNivel());
	}

	@Test
	void testGetSetPrecio() {
		assertEquals(TEST_PRECIO, curso.getPrecio());

		float nuevoPrecio = 200.0f;
		curso.setPrecio(nuevoPrecio);
		assertEquals(nuevoPrecio, curso.getPrecio());
	}

	@Test
	void testGetSetPlazas() {
		assertEquals(TEST_PLAZAS, curso.getPlazas());

		int nuevasPlazas = 25;
		curso.setPlazas(nuevasPlazas);
		assertEquals(nuevasPlazas, curso.getPlazas());
	}

	@Test
	void testGetSetFechaInicio() {
		assertEquals(TEST_FECHA_INICIO, curso.getFechaInicio());

		Date nuevaFechaInicio = Date.valueOf("2025-07-01");
		curso.setFechaInicio(nuevaFechaInicio);
		assertEquals(nuevaFechaInicio, curso.getFechaInicio());
	}

	@Test
	void testGetSetFechaFin() {
		assertEquals(TEST_FECHA_FIN, curso.getFechaFin());

		Date nuevaFechaFin = Date.valueOf("2025-07-31");
		curso.setFechaFin(nuevaFechaFin);
		assertEquals(nuevaFechaFin, curso.getFechaFin());
	}

	@Test
	void testGetSetIdProfesor() {
		assertEquals(TEST_ID_PROFESOR, curso.getIdProfesor());

		curso.setIdProfesor(102);
		assertEquals(102, curso.getIdProfesor());
	}

	@Test
	void testToString() {
		String resultado = curso.toString();

		assertTrue(resultado.contains("idCurso=" + TEST_ID_CURSO));
		assertTrue(resultado.contains("tipo=" + TEST_TIPO));
		assertTrue(resultado.contains("horario=" + TEST_HORARIO.toString()));
		assertTrue(resultado.contains("nivel=" + TEST_NIVEL.getNombre())); // Asegúrate de usar el método getNombre()
		assertTrue(resultado.contains("precio=" + TEST_PRECIO));
		assertTrue(resultado.contains("plazas=" + TEST_PLAZAS));
		assertTrue(resultado.contains("fechaInicio=" + TEST_FECHA_INICIO));
		assertTrue(resultado.contains("fechaFin=" + TEST_FECHA_FIN));
		assertTrue(resultado.contains("idProfesor=" + TEST_ID_PROFESOR));
	}

	@Test
	void testNivelObtenerPorNombre() {
		// Probar la obtención del nivel por nombre
		assertEquals(Nivel.PRINCIPIANTE, Nivel.obtenerPorNombre("principiante"));
		assertEquals(Nivel.MEDIO, Nivel.obtenerPorNombre("medio"));
		assertEquals(Nivel.AVANZADO, Nivel.obtenerPorNombre("avanzado"));
	}

	@Test
	void testNivelObtenerPorNombreInvalido() {
		// Comprobamos que se lance la excepción para un nombre no válido
		assertThrows(IllegalArgumentException.class, () -> {
			Nivel.obtenerPorNombre("intermedio");
		});
	}
}