package uade.ioo.modelo;

import java.util.Date;

public class ChequeTerceros extends Cheque {
	
	private Estado estadoCheque;
	
	public ChequeTerceros(int numero, Date fechaEmision, Date fechaVencimiento, double monto) {
		super(numero, fechaEmision, fechaVencimiento, monto);
		
		//Valido si el cheque esta vencido y actualizo el estado
		determinarEstado(fechaVencimiento);
	}

	private void determinarEstado(Date fechaVencimiento) {
		if(new Date().after(fechaVencimiento)){
			this.estadoCheque = new Vencido();
		}else{
			this.estadoCheque = new Recibido();
		}
	}

	public Estado getEstadoCheque() {
		return estadoCheque;
	}

	public void setEstadoCheque(Estado estadoCheque) {
		this.estadoCheque = estadoCheque;
	}
	
	@Override
	public String toString() {
		return "Terceros";
	}



}
