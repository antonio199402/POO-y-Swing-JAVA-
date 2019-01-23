
public class profesor extends persona {
	private double salario;
	private boolean fijo;
	
	public profesor(){
		
	}
	
	public profesor(double salario,boolean fijo,String DNI,String nombre){
		super(DNI,nombre);
		this.salario=salario;
		this.fijo=fijo;
		
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public boolean isFijo() {
		return fijo;
	}

	public void setFijo(boolean fijo) {
		this.fijo = fijo;
	}

	public double calcular_salario(double retencion, int antiguedad){
		return salario-(salario*retencion/100)+(antiguedad*50);
	}
	
	public String toString() {
		return "profesor [salario=" + salario + ", fijo=" + fijo + "]";
	}
	
	

}
