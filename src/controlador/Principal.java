package controlador;

import java.awt.EventQueue;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import modelo.Bailarin;
import modelo.Curso;
import modelo.Participa;
import modelo.Profesor;
import vista.PagInicio;

public class Principal {
	private static Dao dao = new DaoImplementacionMysql();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			new PagInicio().setVisible(true);
		});
	}

	public static Bailarin leerDni(String dni) throws LoginException {
		return dao.leerBailarin(dni);
	}

	
	public static Curso obtenerCursoPorId(int idCurso) throws LoginException {
		return dao.obtenerCurso(idCurso);
	}


	public static ArrayList<Curso> obtenerCursosPorProfesor(int idProfesor, ArrayList<Curso> cursosProfesor) throws LoginException {
		
		return dao.obtenerCursosPorProfesor(idProfesor, cursosProfesor);
		
	}


	public static Profesor leerId(String id) throws LoginException {

		return dao.leerProfesor(id);

	}

	public static void crearCurso(Curso curso) throws LoginException {

		dao.crearCurso(curso);
	}

	public static ArrayList<Curso> obtenerTodosLosCursos(ArrayList<Curso> todosLosCursos) throws LoginException {
		 return dao.obtenerTodosLosCursos(todosLosCursos);

	}


	public static void elimiinarCurso(int idCurso) throws LoginException {
		dao.eliminarCurso(idCurso);
	}
	public static ArrayList<Curso> obtenerCursosPorBailarin(String idBailarin, ArrayList<Curso> cursosBailarin) throws LoginException{
		
		return dao.obtnerCursosPorBailarin(idBailarin, cursosBailarin);
	}



	public static void modificarCurso(Curso curso) throws LoginException {

		dao.modificarCurso(curso);

	}

	public static Participa leerParticipa(int idCurso) throws LoginException {

		return dao.leerPaarticipa(idCurso);

	}

	public static void inscripcion(int idCurso, String dniBailarin) throws LoginException {

		dao.inscripcionCurso(idCurso, dniBailarin);
	}

	public static void darDeBajaCurso(int idCurso, String dniBailarin) throws LoginException {

	}
	public static void inscribirse(Bailarin b) throws LoginException {
		dao.inscribirse(b);
	}

	public static ArrayList<Bailarin> obtenerBailarinsDelCurso(int idCurso) {

		return dao.obtenerTodosBailarines(idCurso);
	}

	public static void eliminarBailarin(Bailarin bailarin, int i) {

		dao.eliminarBailarin(bailarin, i);
	}

	public static float ocupacionDelProfesor(Profesor p) {
		
		return dao.ocupacionDelProfesor(p);
	}
}
