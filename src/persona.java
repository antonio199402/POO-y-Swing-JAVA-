
public abstract class persona {
	private String DNI;
	private String nombre;
	
	public persona(){
		
	}
	
	public persona(String DNI,String nombre){
		this.DNI=DNI;
		this.nombre=nombre;
		
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String toString() {
		return "persona [DNI=" + DNI + ", nombre=" + nombre + "]";
	}
	
	
	

}
