package sistemaDeCadastro;

public class Aluno extends Usuario {

	private long matricula;

	private double CRE;

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public double getCRE() {
		return CRE;
	}

	public void setCRE(double cRE) {
		CRE = cRE;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMatrícula: " + getMatricula() + "\nCRE: " + getCRE();

	}
}