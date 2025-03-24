package modelo;

public class Profesor {
	private int id;
	private String nombre;
	private String apellido;
	private float salario;
	private boolean admin= true;
	
	
	public Profesor() {
	
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
