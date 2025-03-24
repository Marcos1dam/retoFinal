package controlador;

import javax.security.auth.login.LoginException;

import modelo.Bailarin;

public interface Dao {
	
	public Bailarin leerBailarin(String dni) throws LoginException;
}
