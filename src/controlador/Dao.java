package controlador;

import java.sql.Date;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;
import modelo.Curso;
import modelo.Participa;
import modelo.Profesor;

public interface Dao {
	
	public Bailarin leerBailarin(String dni) throws LoginException;
	public Profesor leerProfesor(String id) throws LoginException;
	public Curso obtenerCurso(int idCurso) throws LoginException;
	public void obtnerCursosPorBailarin(String idBailarin, ArrayList<Curso> cursos);
	public void obtenerCursosPorProfesor(int idProfesor, ArrayList<Curso> cursos) throws LoginException;
	public void obtenerTodosLosCursos(ArrayList<Curso> cursos);
	public Participa leerPaarticipa(int idCurso) throws LoginException;
	public void inscripcionCurso(int idCurso, String DniBailarin,Date FInicio, Date FFin);
	public void darDeBajaCurso(int idCurso, String DniBailarin) throws LoginException;
}
