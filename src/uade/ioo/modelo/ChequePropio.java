package uade.ioo.modelo;

import java.util.Date;

import uade.ioo.util.Util;

public class ChequePropio extends Cheque {

	public ChequePropio(int numero, Date fechaEmision, double monto) {
		//TODO Validar si el cheque propio lleva fecha de vencimiento
		super(numero, fechaEmision, Util.addDays(fechaEmision, 30), monto);
	}
	
	@Override
	public String toString() {
		return "Propio";
	}

}
