package exceptions;

import javax.swing.JOptionPane;

public class LoginExecption extends Exception{
private String mensaje;
	
	/**
	 * @author Marcos
	 * 
	 * @param mensaje
	 */

	public LoginExecption (String mensaje) {
		this.mensaje=mensaje;
	}
	
	public void visualizarMensaje() {
		JOptionPane.showMessageDialog(null, this.mensaje, "Error", 0);
	}
}
