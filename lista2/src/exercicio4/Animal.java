package exercicio4;

public abstract class Animal {
	private String classeAnimal;
	private String ordem;
	private String bioma;
	
	public String getClasseAnimal() {
		return classeAnimal;
	}
	public void setClasseAnimal(String classeAnimal) {
		this.classeAnimal = classeAnimal;
	}
	public String getOrdem() {
		return ordem;
	}
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	public String getBioma() {
		return bioma;
	}
	public void setBioma(String bioma) {
		this.bioma = bioma;
	}
	
	@Override
	public String toString() {
	    return "Classe: " + classeAnimal + ", Ordem: " + ordem + ", Bioma: " + bioma;
	}
}
