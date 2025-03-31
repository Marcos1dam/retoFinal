package test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Bailarin;

class BailarinTest {
    
    private Bailarin bailarin;
    private final String TEST_DNI = "12345678A";
    private final String TEST_NOMBRE = "Ana";
    private final String TEST_APELLIDO = "García";
    private final Date TEST_FECHA_NAC = Date.valueOf("1990-05-15");
    private final int TEST_TELEFONO = 600123456;
    private final String TEST_CORREO = "ana.garcia@email.com";

    @BeforeEach
    void setUp() {
        bailarin = new Bailarin();
        bailarin.setDni(TEST_DNI);
        bailarin.setNombre(TEST_NOMBRE);
        bailarin.setApellido(TEST_APELLIDO);
        bailarin.setFechaNacimiento(TEST_FECHA_NAC);
        bailarin.setTelefono(TEST_TELEFONO);
        bailarin.setCorreo(TEST_CORREO);
    }

    @Test
    void testConstructorVacio() {
        Bailarin b = new Bailarin();
        assertNotNull(b);
        assertNull(b.getDni());
        assertNull(b.getNombre());
        assertNull(b.getApellido());
        assertNull(b.getFechaNacimiento());
        assertEquals(0, b.getTelefono());
        assertNull(b.getCorreo());
    }

    @Test
    void testGetSetDni() {
        assertEquals(TEST_DNI, bailarin.getDni());
        
        String nuevoDni = "87654321B";
        bailarin.setDni(nuevoDni);
        assertEquals(nuevoDni, bailarin.getDni());
        
        bailarin.setDni(null);
        assertNull(bailarin.getDni());
    }

    @Test
    void testGetSetNombre() {
        assertEquals(TEST_NOMBRE, bailarin.getNombre());
        
        String nuevoNombre = "María";
        bailarin.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, bailarin.getNombre());
        
        bailarin.setNombre(null);
        assertNull(bailarin.getNombre());
    }

    @Test
    void testGetSetApellido() {
        assertEquals(TEST_APELLIDO, bailarin.getApellido());
        
        String nuevoApellido = "López";
        bailarin.setApellido(nuevoApellido);
        assertEquals(nuevoApellido, bailarin.getApellido());
        
        bailarin.setApellido(null);
        assertNull(bailarin.getApellido());
    }

    @Test
    void testGetSetFechaNacimiento() {
        assertEquals(TEST_FECHA_NAC, bailarin.getFechaNacimiento());
        
        Date nuevaFecha = Date.valueOf("1985-10-20");
        bailarin.setFechaNacimiento(nuevaFecha);
        assertEquals(nuevaFecha, bailarin.getFechaNacimiento());
        assertTrue(bailarin.getFechaNacimiento() instanceof java.sql.Date);
        
        bailarin.setFechaNacimiento(null);
        assertNull(bailarin.getFechaNacimiento());
    }

    @Test
    void testGetSetTelefono() {
        assertEquals(TEST_TELEFONO, bailarin.getTelefono());
        
        int nuevoTelefono = 699876543;
        bailarin.setTelefono(nuevoTelefono);
        assertEquals(nuevoTelefono, bailarin.getTelefono());
        
        // Test para valor 0
        bailarin.setTelefono(0);
        assertEquals(0, bailarin.getTelefono());
        
        // Test para valor negativo
        bailarin.setTelefono(-123456);
        assertEquals(-123456, bailarin.getTelefono());
    }

    @Test
    void testGetSetCorreo() {
        assertEquals(TEST_CORREO, bailarin.getCorreo());
        
        String nuevoCorreo = "nuevo.correo@email.com";
        bailarin.setCorreo(nuevoCorreo);
        assertEquals(nuevoCorreo, bailarin.getCorreo());
        
        bailarin.setCorreo(null);
        assertNull(bailarin.getCorreo());
        
        // Test para correo vacío
        bailarin.setCorreo("");
        assertEquals("", bailarin.getCorreo());
    }

    @Test
    void testToString() {
        String resultado = bailarin.toString();
        
        assertAll(
            () -> assertTrue(resultado.contains("dni=" + TEST_DNI)),
            () -> assertTrue(resultado.contains("nombre=" + TEST_NOMBRE)),
            () -> assertTrue(resultado.contains("apellido=" + TEST_APELLIDO)),
            () -> assertTrue(resultado.contains("fecha de nacimiento=" + TEST_FECHA_NAC)),
            () -> assertTrue(resultado.contains("telefono=" + TEST_TELEFONO)),
            () -> assertTrue(resultado.contains("correo=" + TEST_CORREO))
        );
        
        // Test con valores nulos
        Bailarin b = new Bailarin();
        String toStringNulo = b.toString();
        assertAll(
            () -> assertTrue(toStringNulo.contains("dni=null")),
            () -> assertTrue(toStringNulo.contains("nombre=null")),
            () -> assertTrue(toStringNulo.contains("fecha de nacimiento=null"))
        );
    }

    @Test
    void testEqualsYHashCode() {
        Bailarin mismoBailarin = new Bailarin();
        mismoBailarin.setDni(TEST_DNI);
        mismoBailarin.setNombre(TEST_NOMBRE);
        mismoBailarin.setApellido(TEST_APELLIDO);
        mismoBailarin.setFechaNacimiento(TEST_FECHA_NAC);
        mismoBailarin.setTelefono(TEST_TELEFONO);
        mismoBailarin.setCorreo(TEST_CORREO);
        
        Bailarin otroBailarin = new Bailarin();
        otroBailarin.setDni("99999999X");
        otroBailarin.setNombre("Pedro");
        otroBailarin.setApellido("Martínez");
        otroBailarin.setFechaNacimiento(Date.valueOf("1980-01-01"));
        otroBailarin.setTelefono(611222333);
        otroBailarin.setCorreo("pedro@email.com");
        
        // Igualdad consigo mismo
        assertEquals(bailarin, bailarin);
        
        // Igualdad con otro objeto con mismos valores
        assertEquals(bailarin, mismoBailarin);
        assertEquals(bailarin.hashCode(), mismoBailarin.hashCode());
        
        // Desigualdad con otro objeto
        assertNotEquals(bailarin, otroBailarin);
        
        // Desigualdad con null
        assertNotEquals(bailarin, null);
        
        // Desigualdad con otro tipo de objeto
        assertNotEquals(bailarin, new Object());
        
        // Test con DNI diferente
        Bailarin bailarinDniDiferente = new Bailarin();
        bailarinDniDiferente.setDni("00000000A");
        assertNotEquals(bailarin, bailarinDniDiferente);
    }

    @Test
    void testFechasLimite() {
        // Fecha mínima (1 de enero de 1970)
        Date fechaMinima = new Date(0);
        bailarin.setFechaNacimiento(fechaMinima);
        assertEquals(fechaMinima, bailarin.getFechaNacimiento());
        
        // Fecha actual
        Date fechaActual = new Date(System.currentTimeMillis());
        bailarin.setFechaNacimiento(fechaActual);
        assertEquals(fechaActual, bailarin.getFechaNacimiento());
        
        // Fecha futura (aunque no tenga sentido lógico, el tipo Date lo permite)
        Date fechaFutura = Date.valueOf("2100-01-01");
        bailarin.setFechaNacimiento(fechaFutura);
        assertEquals(fechaFutura, bailarin.getFechaNacimiento());
    }
}