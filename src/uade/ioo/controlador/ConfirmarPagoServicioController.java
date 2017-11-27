package uade.ioo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPagarServicio;

public class ConfirmarPagoServicioController implements ActionListener {

	private IVistaPagarServicio iPagarServicio;
	private AdministradorPagos modelo;
	
	
	public ConfirmarPagoServicioController(IVistaPagarServicio iPagarServicio, AdministradorPagos modelo) {
		this.iPagarServicio = iPagarServicio;
		this.modelo = modelo;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		modelo.registrarPago(iPagarServicio.getChequesDisponibles(),iPagarServicio.getMontoAPagar());
		
		iPagarServicio.operacionExitosa();
	}

}
