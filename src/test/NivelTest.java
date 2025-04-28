package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Nivel;

class NivelTest {

	@Test
	void testGetNombre() {
		// Comprobamos que los nombres se recuperan correctamente
		assertEquals("principiante", Nivel.PRINCIPIANTE.getNombre());
		assertEquals("medio", Nivel.MEDIO.getNombre());
		assertEquals("avanzado", Nivel.AVANZADO.getNombre());
	}

	@Test
	void testObtenerPorNombreValido() {
		// Probar que obtenerPorNombre devuelve el nivel correcto para un nombre válido
		assertEquals(Nivel.PRINCIPIANTE, Nivel.obtenerPorNombre("principiante"));
		assertEquals(Nivel.MEDIO, Nivel.obtenerPorNombre("medio"));
		assertEquals(Nivel.AVANZADO, Nivel.obtenerPorNombre("avanzado"));
	}

	@Test
	void testObtenerPorNombreInvalido() {
		// Comprobamos que se lanza la excepción para un nombre no válido
		assertThrows(IllegalArgumentException.class, () -> {
			Nivel.obtenerPorNombre("intermedio");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			Nivel.obtenerPorNombre("avance");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			Nivel.obtenerPorNombre("beginner");
		});
	}

	@Test
	void testSetNombre() {
		// Comprobamos que se puede modificar el nombre del nivel (aunque generalmente
		// no se debería)
		Nivel nivel = Nivel.PRINCIPIANTE;
		nivel.setNombre("nuevoNombre");
		assertEquals("nuevoNombre", nivel.getNombre());
	}

	@Test
	void testObtenerPorNombreConMayusculas() {
		// Probar que el método obtenerPorNombre es insensible a mayúsculas y minúsculas
		assertEquals(Nivel.PRINCIPIANTE, Nivel.obtenerPorNombre("PRINCIPIANTE"));
		assertEquals(Nivel.MEDIO, Nivel.obtenerPorNombre("MEDIO"));
		assertEquals(Nivel.AVANZADO, Nivel.obtenerPorNombre("AVANZADO"));
	}
}
