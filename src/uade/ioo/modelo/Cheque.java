package uade.ioo.modelo;

import java.util.Date;

public class Cheque {

	private int numero;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private double monto;

	public Cheque(int numero, Date fechaEmision, Date fechaVencimento, double monto) {
		super();
		this.numero = numero;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimento;
		this.monto = monto;
	}

	public int getNumero() {
		return numero;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public double getMonto() {
		return monto;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	
}
