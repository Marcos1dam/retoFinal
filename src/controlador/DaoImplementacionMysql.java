package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;
import modelo.Curso;
import modelo.Nivel;
import modelo.Participa;
import modelo.Profesor;

public class DaoImplementacionMysql implements Dao {
	// Atributos
	private Connection con;
	private PreparedStatement stmt;

	// Fichero Config
	private ResourceBundle configFile;
	private String urlDB;
	private String userBD;
	private String passwordDB;


    // Sentencias
    final String SIGNIN = "SELECT * FROM Bailarin WHERE DniBailarin = ?";
    final String SIGNINADMIN = "SELECT * FROM Profesor WHERE IdProfesor = ? ";
    final String OBTENERCURSO = "SELECT * FROM Curso WHERE IdCurso = ?";
    final String CURSOPORPROFESOR = "SELECT * FROM Curso WHERE IdProfesor = ?";
    final String CREARCURSO = "INSERT INTO CURSO (IdCurso, Tipo, Horario, Nivel, Precio, Plaza, IdProfesor) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String CURSOPORBAILARIN = "SELECT * FROM Curso WHERE IdCurso IN(SELECT IdCurso FROM Participa WHERE DniBailarin = ?)";
    final String TODOSLOSCURSOS = "SELECT * FROM Curso";
    final String MODIFICARCURSO = "UPDATE CURSO SET Tipo = ?, Horario = ?, Nivel = ?, Precio = ?, Plaza = ?  WHERE IdCurso = ?";
	final String ELIMINARCURSO = "DELETE FROM Curso WHERE IdCurso = ?";
	final String PARTICIPA = "SELECT * FROM Participa WHERE IdCurso= ?";
	final String INSCRIPCIONCURSO = "INSERT INTO Participa VALUES(?, ?) ";
	final String DARDEBAJACURSO = "DELETE FROM Participa WHERE IdCurso = ? AND DniBailarin = ?";
	final String INSCRIPCION = "INSERT INTO Bailarin (DniBailarin, NombreB, ApellidoB, FechaNacimiento, Telefono, EmailB) VALUES (?, ?, ?, ?, ?, ?)";
	
	public DaoImplementacionMysql() {
		this.configFile = ResourceBundle.getBundle("modelo.configClase");
		this.urlDB = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordDB = this.configFile.getString("DBPass");
	}

	private void openConnection() throws SQLException {
		con = DriverManager.getConnection(urlDB, this.userBD, passwordDB);
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

	@Override
	public Bailarin leerBailarin(String dni) throws LoginException {
		ResultSet rs = null;
		Bailarin ba = null;

		try {
			openConnection();
			stmt = con.prepareStatement(SIGNIN);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();

			if (rs.next()) {
				ba = new Bailarin();
				ba.setDni(rs.getNString("DniBailarin"));
				ba.setNombre(rs.getString("NombreB"));
				ba.setApellido(rs.getString("ApellidoB"));
				ba.setFechaNacimiento(rs.getDate("FechaNacimiento"));
				ba.setTelefono(rs.getInt("Telefono"));
				ba.setCorreo(rs.getString("EmailB"));

				return ba;
			} else {
				throw new LoginException("No se encontró ningún bailarín con el DNI proporcionado.");
			}
		} catch (SQLException e) {
			String message = "Error al leer datos: ";
			LoginException ex = new LoginException(message);
			throw ex;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Profesor leerProfesor(String id) throws LoginException {
		ResultSet rs = null;
		Profesor p = null;

		try {
			openConnection();
			stmt = con.prepareStatement(SIGNINADMIN);
			stmt.setInt(1, Integer.parseInt(id));
			rs = stmt.executeQuery();

			if (rs.next()) {
				p = new Profesor();
				p.setId(rs.getInt("IdProfesor"));
				p.setNombre(rs.getString("NombreP"));
				p.setApellido(rs.getString("ApellidoP"));
				p.setSalario(rs.getFloat("Salario"));
				p.setCorreo(rs.getString("EmailP"));
				p.setAdmin(rs.getBoolean("EsAdmin"));
				p.setImagen(rs.getString("Imagen"));

				return p;
			} else {
				throw new LoginException("No se encontró ningún profesor con el ID proporcionado.");
			}
		} catch (SQLException e) {
			String message = "Error al leer datos: ";
			LoginException ex = new LoginException(message);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Curso obtenerCurso(int idCurso) throws LoginException {
		ResultSet rs = null;
		Curso c = null;

		try {
			openConnection();
			stmt = con.prepareStatement(OBTENERCURSO);
			stmt.setInt(1, idCurso);
			rs = stmt.executeQuery();
			if (rs.next()) {
				c = new Curso();
				c.setIdCurso(rs.getInt("IdCurso"));
				c.setTipo(rs.getString("Tipo"));
				c.setHorario(rs.getTime("Horario"));
				c.setNivel(Nivel.obtenerPorNombre(rs.getNString("Nivel")));
				c.setPrecio(rs.getFloat("Precio"));
				c.setPlazas(rs.getInt("Plaza"));
				c.setFechaInicio(rs.getDate("FInicio"));
				c.setFechaFin(rs.getDate("FFin"));
				c.setIdProfesor(rs.getInt("IdProfesor"));

				return c;
			} else {
				throw new LoginException("No se encontró ningún curso con el ID proporcionado.");
			}
		} catch (SQLException e) {
			String message = "Error al leer datos: ";
			LoginException ex = new LoginException(message);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList obtenerCursosPorProfesor(int idProfesor, ArrayList<Curso> cursos) throws LoginException {
		ResultSet rs = null;
		Curso cu = null;

		try {
			openConnection();
			stmt = con.prepareStatement(CURSOPORPROFESOR);
			stmt.setInt(1, idProfesor);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cu = new Curso();
				cu.setIdCurso(rs.getInt("IdCurso"));
				cu.setTipo(rs.getString("Tipo"));
				cu.setHorario(rs.getTime("Horario"));
				cu.setNivel(Nivel.obtenerPorNombre(rs.getNString("Nivel")));
				cu.setPrecio(rs.getFloat("Precio"));
				cu.setPlazas(rs.getInt("Plaza"));
				cu.setFechaInicio(rs.getDate("FInicio"));
				cu.setFechaFin(rs.getDate("FFin"));
				cu.setIdProfesor(rs.getInt("IdProfesor"));
				cursos.add(cu);
			}
			return cursos;
		} catch (SQLException e) {
			throw new LoginException("error en la base de datos");
			
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void crearCurso(Curso curso) throws LoginException {
		try {
			openConnection();
			stmt = con.prepareStatement(CREARCURSO);
			
			stmt.setInt(1, curso.getIdCurso());
			stmt.setString(2, curso.getTipo());
			stmt.setTime(3, curso.getHorario());
			stmt.setString(4, String.valueOf(curso.getNivel()));
			stmt.setFloat(5, curso.getPrecio());
			stmt.setInt(6, curso.getPlazas());
			stmt.setDate(7, curso.getFechaInicio());
			stmt.setDate(8, curso.getFechaFin());
			stmt.setInt(9, curso.getIdProfesor());

			stmt.executeUpdate();
		} catch (SQLException e) {
			String message = "Error al leer datos: ";
			LoginException ex = new LoginException(message);
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList obtnerCursosPorBailarin(String idBailarin, ArrayList<Curso> cursos) {
		ResultSet rs = null;
		Curso cu = null;

		try {
			openConnection();
			stmt = con.prepareStatement(CURSOPORBAILARIN);
			stmt.setString(1, idBailarin);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cu = new Curso();
				cu.setIdCurso(rs.getInt("IdCurso"));
				cu.setTipo(rs.getString("Tipo"));
				cu.setHorario(rs.getTime("Horario"));
				cu.setNivel(Nivel.obtenerPorNombre(rs.getNString("Nivel")));
				cu.setPrecio(rs.getFloat("Precio"));
				cu.setPlazas(rs.getInt("Plaza"));
				cu.setFechaInicio(rs.getDate("FInicio"));
				cu.setFechaFin(rs.getDate("FFin"));
				cu.setIdProfesor(rs.getInt("IdProfesor"));
				cursos.add(cu);
				for(Curso c: cursos) {
					System.out.println(c);
				}
			}
			return cursos;
		} catch (SQLException e) {
			String message = "Error al leer datos: ";
			LoginException ex = new LoginException(message);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public ArrayList obtenerTodosLosCursos(ArrayList<Curso> cursos) {
		ResultSet rs = null;
		Curso cu = null;

		try {
			openConnection();
			stmt = con.prepareStatement(TODOSLOSCURSOS);

			rs = stmt.executeQuery();
			while (rs.next()) {
				cu = new Curso();
				cu.setIdCurso(rs.getInt("IdCurso"));
				cu.setTipo(rs.getString("Tipo"));
				cu.setHorario(rs.getTime("Horario"));
				cu.setNivel(Nivel.obtenerPorNombre(rs.getNString("Nivel")));
				cu.setPrecio(rs.getFloat("Precio"));
				cu.setPlazas(rs.getInt("Plaza"));
				cu.setFechaInicio(rs.getDate("FInicio"));
				cu.setFechaFin(rs.getDate("FFin"));
				cu.setIdProfesor(rs.getInt("IdProfesor"));
				cursos.add(cu);
			}
			return cursos;
		} catch (SQLException e) {
			String message = "Error al leer datos: ";
			LoginException ex = new LoginException(message);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Participa leerPaarticipa(int idCurso) throws LoginException {
		ResultSet rs = null;
		Participa p = null;

		try {
			openConnection();
			stmt = con.prepareStatement(PARTICIPA);
			stmt.setInt(1, idCurso);
			rs = stmt.executeQuery();
			if (rs.next()) {
				p = new Participa();
				p.setIdCurso(rs.getInt("IdCurso"));
				p.setDniBailarin(rs.getNString("DniBailarin"));
				
				return p;
			} else {
				throw new LoginException("No se encontró ningún curso con el ID proporcionado.");
			}
		} catch (SQLException e) {
			throw new LoginException("error en la base de datos");

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void inscripcionCurso(int idCurso, String DniBailarin) throws LoginException{
		ResultSet rs = null;

		try {
			openConnection();
			stmt = con.prepareStatement(INSCRIPCIONCURSO);
			stmt.setInt(1, idCurso);
			stmt.setString(2, DniBailarin);

			int affectedRows = stmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("La inserción falló, no se afectaron filas.");
			}
		} catch (SQLException e) {
			throw new LoginException("error en la base de datos");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void darDeBajaCurso(int idCurso, String DniBailarin) throws LoginException {

		try {
			openConnection();
			stmt = con.prepareStatement(DARDEBAJACURSO);
			stmt.setInt(1, idCurso);
			stmt.setString(2, DniBailarin);
			int filasAfectadas = stmt.executeUpdate();

			if (filasAfectadas == 0) {
				throw new SQLException("No se encontró la inscripción para eliminar.");
			}
		} catch (SQLException e) {
			throw new LoginException("error en la base de datos");
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void eliminarCurso(int idCurso) throws LoginException{

		try {
			openConnection();
			stmt = con.prepareStatement(ELIMINARCURSO);
			stmt.setInt(1, idCurso);
			int filasAfectadas = stmt.executeUpdate();

			if (filasAfectadas == 0) {
				throw new SQLException("No se encontró la inscripción para eliminar.");
			}
		} catch (SQLException e) {
			throw new LoginException("error en la base de datos");
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public void modificarCurso(Curso curso) throws LoginException {
		int filasModificadas;
		
		try {
			openConnection();
			stmt = con.prepareStatement(MODIFICARCURSO);
			
			stmt.setString(1, curso.getTipo());
			stmt.setTime(2, curso.getHorario());
			stmt.setString(3, String.valueOf(curso.getNivel()));
			stmt.setFloat(4, curso.getPrecio());
			stmt.setInt(5, curso.getPlazas());
			stmt.setInt(6, curso.getIdCurso());
			
			filasModificadas = stmt.executeUpdate();
			if (filasModificadas > 0) {
				System.out.println("Curso actualizado. ");
			} else {
				System.out.println("No se encontró el curso.");
			}
			
		} catch (SQLException e) {
			throw new LoginException("error en la base de datos");
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void inscribirse(Bailarin b) throws LoginException{
		
		try {
			openConnection();
			stmt = con.prepareStatement(INSCRIPCION);
			
			stmt.setString(1, b.getDni());
			stmt.setString(2, b.getNombre());
			stmt.setString(3, b.getApellido());
			stmt.setDate(4, b.getFechaNacimiento());
			stmt.setInt(5, b.getTelefono());
			stmt.setString(6, b.getCorreo());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new LoginException("error en la base de datos");
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}


}
