package exercicio3;

import java.util.Date;

public abstract class Pessoa {
	private String nome;
	private Date dataNasc;
	private Long cpf;

	public String getName() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	@Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Data: " + dataNasc;
    }
}
