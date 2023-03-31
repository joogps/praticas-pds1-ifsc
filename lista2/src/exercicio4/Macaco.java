package exercicio4;

public class Macaco extends Animal {
	private String cor;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
	    return super.toString() + ", Cor: " + cor;
	}
}
