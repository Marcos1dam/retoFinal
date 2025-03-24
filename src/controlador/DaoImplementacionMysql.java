package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;

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
    final String SIGNIN = "SELECT * FROM bailarin WHERE dni_B = ?";

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
                ba.setDni(rs.getString("dni_B"));
                ba.setNombre(rs.getString("nombre_B"));
                ba.setApellido(rs.getString("apellido_B"));
                ba.setEdad(rs.getInt("edad_B"));
                ba.setCorreo(rs.getString("correco_B"));
                ba.setTelefono(rs.getInt("telefono_B"));
                
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
}
