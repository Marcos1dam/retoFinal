package controlador;

import java.awt.EventQueue;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;
import modelo.Profesor;
import vista.PagInicio;

public class Principal {
    private static Dao dao = new DaoImplementacionMysql();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PagInicio frame = new PagInicio();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
}
