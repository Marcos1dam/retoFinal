package controlador;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;
import modelo.Profesor;

public interface Dao {
	
	public Bailarin leerBailarin(String dni) throws LoginException;
	public Profesor leerProfesor(String id) throws LoginException;
	
}
