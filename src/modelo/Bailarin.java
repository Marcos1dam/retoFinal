package modelo;

import java.sql.Date;

import javax.swing.JOptionPane;

import exceptions.DniExecption;
import exceptions.EmailExecption;

public class Bailarin {
	private String dni;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private int telefono;
	private String correo;
	
	public Bailarin() {
	
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws DniExecption {
		if (!dni.matches("^\\d{8}[A-Za-z]$")) {
		    throw new DniExecption("DNI no válido. El formato correcto es: 8 dígitos seguidos de una letra (ejemplo: 12345678A)");
		}
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) throws EmailExecption {
		  if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
		        throw new EmailExecption("Email no válido. Ejemplo válido: usuario@dominio.com");
		    }
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Bailarin [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha de nacimiento=" +fechaNacimiento
				+ ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
	
}
