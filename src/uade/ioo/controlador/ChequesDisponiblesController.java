package uade.ioo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.vista.comportamiento.IVistaPagarServicio;

public class ChequesDisponiblesController implements ActionListener {
	
	
	private IVistaPagarServicio iPagarServicio;
	private AdministradorPagos modelo;
	
	public ChequesDisponiblesController(IVistaPagarServicio iPagarServicio, AdministradorPagos modelo) {
		this.iPagarServicio = iPagarServicio;
		this.modelo = modelo;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		double montoAPagar = iPagarServicio.getMontoAPagar();
		//Obtengo los cheques disponibles
		List<Cheque> chequesDisponibles = modelo.obtenerChequesDisponibles(montoAPagar);
		
		//Obtengo el monto
		double calcularMontoTotal = modelo.calcularMontoTotal(chequesDisponibles);
		
		//Valido si es necesario utilizar cheque propio
		if(calcularMontoTotal < montoAPagar){
			Cheque cheque = modelo.generarChequeNuevo(montoAPagar - calcularMontoTotal);
			chequesDisponibles.add(cheque);
		}
		
		//Muestro por pantalla los cheques disponibles para el pago.
		iPagarServicio.mostrarChequesDisponibles(chequesDisponibles);
		
	}

}
