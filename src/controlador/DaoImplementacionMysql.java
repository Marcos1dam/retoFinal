package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;
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
            LoginException ex= new LoginException(message);
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
		ResultSet rs= null;
		Profesor p= null;
		
		try {
			openConnection();
			stmt = con.prepareStatement(SIGNINADMIN);
			stmt.setInt(1, Integer.parseInt(id));
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				p= new Profesor();
				p.setId(rs.getInt("IdProfesor"));
				p.setNombre(rs.getString("NombreP"));
				p.setApellido(rs.getString("ApellidoP"));
				p.setSalario(rs.getFloat("Salario"));
				p.setCorreo(rs.getString("EmailP"));
				p.setAdmin(rs.getBoolean("EsAdmin"));
				p.setImagen(rs.getString("Imagen"));
				
				return p;
			}else {
                throw new LoginException("No se encontró ningún profesor con el ID proporcionado.");
            }
		} catch (SQLException e) {
			String message = "Error al leer datos: ";
            LoginException ex= new LoginException(message);
		}finally {
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
}
