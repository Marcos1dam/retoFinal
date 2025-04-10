package controlador;

import java.sql.Date;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import exceptions.DniExecption;
import exceptions.EmailExecption;
import modelo.Bailarin;
import modelo.Curso;
import modelo.Participa;
import modelo.Profesor;

public interface Dao {

	public Bailarin leerBailarin(String dni) throws LoginException;

	public Profesor leerProfesor(String id) throws LoginException, EmailExecption;

	public Curso obtenerCurso(int idCurso) throws LoginException;

	public void crearCurso(Curso curso) throws LoginException;

	public ArrayList<Curso> obtenerCursosPorProfesor(int idProfesor, ArrayList<Curso>cursos) throws LoginException;

	public ArrayList<Curso> obtnerCursosPorBailarin(String idBailarin, ArrayList<Curso> cursos)throws LoginException;

	public ArrayList<Curso> obtenerTodosLosCursos(ArrayList<Curso> cursos);

	public void modificarCurso(Curso curso) throws LoginException;

	public Participa leerPaarticipa(int idCurso) throws LoginException;

	public void inscripcionCurso(int idCurso, String DniBailarin) throws LoginException;

	public void darDeBajaCurso(int idCurso, String DniBailarin) throws LoginException;
	
	public void eliminarCurso(int idCurso) throws LoginException;

	public ArrayList<Bailarin> obtenerTodosBailarines(int idCurso) throws DniExecption, EmailExecption;

	public void eliminarBailarin(Bailarin bailarin, int i);
	
	public void inscribirse(Bailarin b) throws LoginException;


	public float ocupacionDelProfesor(Profesor p);

	public ArrayList<Profesor> obtenerTodosLosProfesores(ArrayList<Profesor> profesores) throws LoginException, EmailExecption;

	
	public void altaProfesor(Profesor p) throws LoginException;

}
