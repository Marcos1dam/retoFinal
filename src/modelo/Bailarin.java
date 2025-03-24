package modelo;

public class Bailarin {
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private int telefono;
	private String correo;
	
	public Bailarin() {
	
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Bailarin [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
	
}
