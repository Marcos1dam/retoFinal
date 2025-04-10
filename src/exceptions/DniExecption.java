package exceptions;

import javax.swing.JOptionPane;

public class DniExecption extends Exception{
private String mensaje;
	
	public DniExecption (String mensaje) {
		this.mensaje=mensaje;
	}
	
	public void visualizarMensaje() {
		JOptionPane.showMessageDialog(null, this.mensaje, "Error", 0);
	}
}
