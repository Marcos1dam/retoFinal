package modelo;

import exceptions.EmailExecption;

public class Profesor {
	private int id;
	private String nombre;
	private String apellido;
	private float salario;
	private String correo;
	private boolean admin= true;
	private String imagen;
	
	
	public Profesor() {
	
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario
				+ ", admin=" + admin + "]";
	}
	
	
}
