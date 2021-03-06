package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Chequera {

	private int ultimoNumero;
	private List<ChequePropio> chequesEmitidos;
	
	public Chequera() {
		super();
		this.ultimoNumero = 0;
		this.chequesEmitidos = new ArrayList<ChequePropio>();
	}

	public int getUltimoNumero() {
		return ultimoNumero;
	}

	public void setUltimoNumero(int ultimoNumero) {
		this.ultimoNumero = ultimoNumero;
	}

	public List<ChequePropio> getChequesEmitidos() {
		return chequesEmitidos;
	}

	public void agregarChequePropio(ChequePropio cheque) {
		chequesEmitidos.add(cheque);
		
	}
	
}
