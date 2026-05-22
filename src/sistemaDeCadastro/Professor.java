package sistemaDeCadastro;

public class Professor extends Usuario {

	private long SIAPE;

	private int cargaHoraria;

	public long getSIAPE() {
		return SIAPE;
	}

	public void setSIAPE(long sIAPE) {
		SIAPE = sIAPE;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSIAPE: " + getSIAPE() + "\nCarga Horária: " + getCargaHoraria();

	}
}