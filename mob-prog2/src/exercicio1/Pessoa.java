package exercicio1;

public class Pessoa {
	private String cpf;
	private String firstName;
	private String surname;
	private String birthdate;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public String description() {
		return this.firstName + " " + this.surname + ", " + this.cpf + " – " + this.birthdate;
	}
}
