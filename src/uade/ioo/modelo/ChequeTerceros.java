package uade.ioo.modelo;

import java.util.Date;

public class ChequeTerceros extends Cheque {

	private Estado estadoCheque;
	
	public ChequeTerceros(int numero, Date fechaEmision) {
		super(numero, fechaEmision);
	}

	public Estado getEstadoCheque() {
		return estadoCheque;
	}

	public void setEstadoCheque(Estado estadoCheque) {
		this.estadoCheque = estadoCheque;
	}

}
