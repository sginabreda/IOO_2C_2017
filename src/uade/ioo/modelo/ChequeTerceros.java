package uade.ioo.modelo;

import java.util.Date;

public class ChequeTerceros extends Cheque {

	private Estado estadoCheque;
	
	public ChequeTerceros(int numero, Date fechaEmision, Date fechaVencimiento, double monto) {
		super(numero, fechaEmision, fechaVencimiento, monto);
	}

	public Estado getEstadoCheque() {
		return estadoCheque;
	}

	public void setEstadoCheque(Estado estadoCheque) {
		this.estadoCheque = estadoCheque;
	}

}
