package uade.ioo.modelo;

import java.util.Date;

public abstract class Cheque {

	protected int numero;
	protected Date fechaEmision;
	
	public Cheque(int numero, Date fechaEmision) {
		super();
		this.numero = numero;
		this.fechaEmision = fechaEmision;
	}
	
}
