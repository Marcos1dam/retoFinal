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

	public static Bailarin leerDni(String dni) {
		try {
			return dao.leerBailarin(dni);
		} catch (LoginException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Profesor leerId(String id) {
		try {
			return dao.leerProfesor(id);
		} catch (LoginException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Curso obtenerCursoPorId(int idCurso) {
		try {
			return dao.obtenerCurso(idCurso);
		} catch (LoginException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<Curso> obtenerCursosPorProfesor(int idProfesor) {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {
			dao.obtenerCursosPorProfesor(idProfesor, cursos);
			for (Curso c : cursos) {
				System.out.println(c);
			}
			return cursos;
		} catch (LoginException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void crearCurso(Curso curso) {
		try {
			dao.crearCurso(curso);
		} catch (LoginException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Curso> obtenerCursosPorBailarin(String idBailarin) {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		dao.obtnerCursosPorBailarin(idBailarin, cursos);
		for (Curso c : cursos) {
			System.out.println(c);
		}
		return cursos;

	}

	public static ArrayList<Curso> obtenerTodosLosCursos() {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		dao.obtenerTodosLosCursos(cursos);
		return cursos;
	}

	public static void modificarCurso(Curso curso) {
		try {
			dao.modificarCurso(curso);
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
    
    public static Participa leerParticipa(int idCurso) {
    	try {
			return dao.leerPaarticipa(idCurso);
		} catch (LoginException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static void inscripcion(int idCurso, String dniBailarin) {
    	
    	dao.inscripcionCurso(idCurso, dniBailarin);
    }
    public static boolean darDeBajaCurso(int idCurso, String dniBailarin){
    	
    	try {
			dao.darDeBajaCurso(idCurso, dniBailarin);
			return true;
		} catch (LoginException e) {
			
			e.printStackTrace();
			return false;
		}
    }
    
    public static boolean elimiinarCurso(int idCurso) {
    	
    	try {
			dao.eliminarCurso(idCurso);
			return true;
		} catch (LoginException e) {
			
			e.printStackTrace();
			return false;
		}
    }
}
