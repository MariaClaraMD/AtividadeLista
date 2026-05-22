package sistemaDeCadastro;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {

	private String nome;

	private String CPF;

	private Date dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		String data = date.format(getDataNascimento());

		return "Nome: " + getNome() + "\nCPF: " + getCPF() + "\nData de Nascimento: " + data;
	}
}