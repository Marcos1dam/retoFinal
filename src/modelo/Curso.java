package modelo;

import java.sql.Time;

public class Curso {
	
	private int idCurso;
	private String tipo;
	private Time horario;
	private Nivel nivel;
	private float precio;
	private int plazas;
	private int idProfesor;
	
	public int getIdCurso() {
		return idCurso;
	}
	
	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", tipo=" + tipo + ", horario=" + horario + ", nivel=" + nivel
				+ ", precio=" + precio + ", plazas=" + plazas +", Id Profesor="+idProfesor+ "]";
	}
	
	
}
