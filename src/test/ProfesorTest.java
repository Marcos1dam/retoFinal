package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import exceptions.EmailExecption;
import modelo.Profesor;

class ProfesorTest {
    
    private Profesor profesor;
    private final int TEST_ID = 1;
    private final String TEST_NOMBRE = "Carlos";
    private final String TEST_APELLIDO = "Martínez";
    private final float TEST_SALARIO = 2500.50f;
    private final String TEST_CORREO_VALIDO = "carlos.martinez@instituto.com";
    private final String TEST_CORREO_INVALIDO = "carlos.martinez@instituto";
    private final String TEST_IMAGEN = "foto_profesor.jpg";

    @BeforeEach
    void setUp() throws EmailExecption {
        profesor = new Profesor();
        profesor.setId(TEST_ID);
        profesor.setNombre(TEST_NOMBRE);
        profesor.setApellido(TEST_APELLIDO);
        profesor.setSalario(TEST_SALARIO);
        profesor.setCorreo(TEST_CORREO_VALIDO);
        profesor.setImagen(TEST_IMAGEN);
        profesor.setAdmin(true);
    }

    @Test
    void testConstructorVacio() {
        Profesor p = new Profesor();
        assertNotNull(p);
        assertEquals(0, p.getId());
        assertNull(p.getNombre());
        assertNull(p.getApellido());
        assertEquals(0.0f, p.getSalario(), 0.001);
        assertNull(p.getCorreo());
        assertTrue(p.isAdmin()); // Por defecto es true según la clase
        assertNull(p.getImagen());
    }

    @Test
    void testGetSetId() {
        assertEquals(TEST_ID, profesor.getId());
        
        int nuevoId = 2;
        profesor.setId(nuevoId);
        assertEquals(nuevoId, profesor.getId());
        
        profesor.setId(0);
        assertEquals(0, profesor.getId());
        
        profesor.setId(-1);
        assertEquals(-1, profesor.getId());
    }

    @Test
    void testGetSetNombre() {
        assertEquals(TEST_NOMBRE, profesor.getNombre());
        
        String nuevoNombre = "Ana";
        profesor.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, profesor.getNombre());
        
        profesor.setNombre(null);
        assertNull(profesor.getNombre());
        
        profesor.setNombre("");
        assertEquals("", profesor.getNombre());
    }

    @Test
    void testGetSetApellido() {
        assertEquals(TEST_APELLIDO, profesor.getApellido());
        
        String nuevoApellido = "Gómez";
        profesor.setApellido(nuevoApellido);
        assertEquals(nuevoApellido, profesor.getApellido());
        
        profesor.setApellido(null);
        assertNull(profesor.getApellido());
        
        profesor.setApellido("");
        assertEquals("", profesor.getApellido());
    }

    @Test
    void testGetSetSalario() {
        assertEquals(TEST_SALARIO, profesor.getSalario(), 0.001);
        
        float nuevoSalario = 3000.75f;
        profesor.setSalario(nuevoSalario);
        assertEquals(nuevoSalario, profesor.getSalario(), 0.001);
        
        profesor.setSalario(0.0f);
        assertEquals(0.0f, profesor.getSalario(), 0.001);
        
        profesor.setSalario(-1000.0f);
        assertEquals(-1000.0f, profesor.getSalario(), 0.001);
    }

    @Test
    void testGetSetCorreoValido() throws EmailExecption {
        assertEquals(TEST_CORREO_VALIDO, profesor.getCorreo());
        
        String nuevoCorreo = "nuevo.correo@instituto.com";
        profesor.setCorreo(nuevoCorreo);
        assertEquals(nuevoCorreo, profesor.getCorreo());
    }

 

    @Test
    void testGetSetAdmin() {
        assertTrue(profesor.isAdmin());
        
        profesor.setAdmin(false);
        assertFalse(profesor.isAdmin());
        
        profesor.setAdmin(true);
        assertTrue(profesor.isAdmin());
    }

    @Test
    void testGetSetImagen() {
        assertEquals(TEST_IMAGEN, profesor.getImagen());
        
        String nuevaImagen = "nueva_foto.jpg";
        profesor.setImagen(nuevaImagen);
        assertEquals(nuevaImagen, profesor.getImagen());
        
        profesor.setImagen(null);
        assertNull(profesor.getImagen());
        
        profesor.setImagen("");
        assertEquals("", profesor.getImagen());
    }

    @Test
    void testToString() {
        String resultado = profesor.toString();
        
        assertTrue(resultado.contains("id=" + TEST_ID));
        assertTrue(resultado.contains("nombre=" + TEST_NOMBRE));
        assertTrue(resultado.contains("apellido=" + TEST_APELLIDO));
        assertTrue(resultado.contains("salario=" + TEST_SALARIO));
        assertTrue(resultado.contains("admin=" + true));
        
        // Verificar que no incluye correo ni imagen (según el toString() de la clase)
        assertFalse(resultado.contains("correo="));
        assertFalse(resultado.contains("imagen="));
        
        // Test con valores por defecto
        Profesor p = new Profesor();
        String toStringDefault = p.toString();
        assertTrue(toStringDefault.contains("id=0"));
        assertTrue(toStringDefault.contains("nombre=null"));
        assertTrue(toStringDefault.contains("apellido=null"));
        assertTrue(toStringDefault.contains("salario=0.0"));
        assertTrue(toStringDefault.contains("admin=true"));
    }

    @Test
    void testEqualsYHashCode() throws EmailExecption {
        Profesor mismoProfesor = new Profesor();
        mismoProfesor.setId(TEST_ID);
        mismoProfesor.setNombre(TEST_NOMBRE);
        mismoProfesor.setApellido(TEST_APELLIDO);
        mismoProfesor.setSalario(TEST_SALARIO);
        mismoProfesor.setCorreo(TEST_CORREO_VALIDO);
        mismoProfesor.setImagen(TEST_IMAGEN);
        mismoProfesor.setAdmin(true);
        
        Profesor otroProfesor = new Profesor();
        otroProfesor.setId(2);
        otroProfesor.setNombre("Laura");
        otroProfesor.setApellido("García");
        otroProfesor.setSalario(3000.0f);
        otroProfesor.setCorreo("laura.garcia@instituto.com");
        otroProfesor.setImagen("foto_laura.jpg");
        otroProfesor.setAdmin(false);
        
        // Igualdad consigo mismo
        assertEquals(profesor, profesor);
        
        // Igualdad con otro objeto con mismos valores
        assertEquals(profesor, mismoProfesor);
        assertEquals(profesor.hashCode(), mismoProfesor.hashCode());
        
        // Desigualdad con otro objeto
        assertNotEquals(profesor, otroProfesor);
        
        // Desigualdad con null
        assertNotEquals(profesor, null);
        
        // Desigualdad con otro tipo de objeto
        assertNotEquals(profesor, new Object());
        
        // Test con ID diferente
        Profesor profesorIdDiferente = new Profesor();
        profesorIdDiferente.setId(99);
        assertNotEquals(profesor, profesorIdDiferente);
    }
}

