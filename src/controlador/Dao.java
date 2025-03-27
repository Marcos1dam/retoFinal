package controlador;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;
import modelo.Curso;
import modelo.Profesor;

public interface Dao {

	public Bailarin leerBailarin(String dni) throws LoginException;

	public Profesor leerProfesor(String id) throws LoginException;

	public Curso obtenerCurso(int idCurso) throws LoginException;
	
	public void crearCurso(Curso curso) throws LoginException;

	public void obtenerCursosPorProfesor(int idProfesor, ArrayList<Curso> cursos) throws LoginException;

}
