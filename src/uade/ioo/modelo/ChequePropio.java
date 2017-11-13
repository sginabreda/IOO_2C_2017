package uade.ioo.modelo;

import java.util.Date;

public class ChequePropio extends Cheque {

	public ChequePropio(int numero, Date fechaEmision, double monto) {
		super(numero, fechaEmision, null, monto);
	}
	
	@Override
	public String toString() {
		return super.toString() + "Propio";
	}

}
