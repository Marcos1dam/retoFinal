package modelo;

public enum Nivel {

	PRINCIPIANTE("principiante"), MEDIO("medio"), AVANZADO("avanzado");

	private String nombre;

	Nivel(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static Nivel obtenerPorNombre(String nombre) {
		for (Nivel n : Nivel.values()) {
			if (n.getNombre().equalsIgnoreCase(nombre)) {
				return n;
			}
		}
		throw new IllegalArgumentException("Nivel no válido: " + nombre);

	}
}
