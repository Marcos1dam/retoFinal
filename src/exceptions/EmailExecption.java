package exceptions;

import javax.swing.JOptionPane;

public class EmailExecption extends Exception{
private String mensaje;
	
	/**
	 * @author Marcos
	 * 
	 * @param mensaje
	 */

	public EmailExecption (String mensaje) {
		this.mensaje=mensaje;
	}
	
	public void visualizarMensaje() {
		JOptionPane.showMessageDialog(null, this.mensaje, "Error", 0);
	}
}
