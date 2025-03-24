package modelo;

import java.sql.Date;

public class Participa {
	
	private int idCurso;
	private String dniBailarin;
	private Date fechaInicio;
	private Date fechaFin;
	
	public Participa() {
		
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getDniBailarin() {
		return dniBailarin;
	}

	public void setDniBailarin(String dniBailarin) {
		this.dniBailarin = dniBailarin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Participa [idCurso=" + idCurso + ", dniBailarin=" + dniBailarin + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}
	
	
	

}
