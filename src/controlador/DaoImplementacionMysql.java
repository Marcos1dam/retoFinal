package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoImplementacionMysql implements Dao{
	// Atributos
		private Connection con;
		private PreparedStatement stmt;
		
		//Fichero Config
		private ResourceBundle configFile;
		private String urlDB;
		private String userBD;
		private String passwordDB;
		
		public DaoImplementacionMysql() {
			this.configFile=ResourceBundle.getBundle("modelo.configClase");
			this.urlDB=this.configFile.getString("Conn");
			this.userBD=this.configFile.getString("DBUser");
			this.passwordDB=this.configFile.getString("DBPass");
			
		}
		private void openConnection() {
			try {
				con = DriverManager.getConnection(urlDB,this.userBD,passwordDB);
				//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller?serverTimezone=Europe/Madrid&useSSL=false","root","abcd*1234");
			} catch (SQLException e) {
				System.out.println("Error al intentar abrir la BD");
			}
		}

		private void closeConnection() throws SQLException {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null)
				con.close();
		}
}
