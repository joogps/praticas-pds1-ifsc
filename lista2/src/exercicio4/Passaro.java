package exercicio4;

public class Passaro extends Animal {
	private String alimento;
	
	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	
	@Override
	public String toString() {
	    return super.toString() + ", Alimento: " + alimento;
	}
}
