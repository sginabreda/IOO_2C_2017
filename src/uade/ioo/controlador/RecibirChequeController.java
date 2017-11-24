package uade.ioo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaAgregarChequeTercero;

public class RecibirChequeController implements ActionListener {
	
	private IVistaAgregarChequeTercero vistaAgregarChequeTerceros;
	private AdministradorPagos modelo;
	
	public RecibirChequeController(IVistaAgregarChequeTercero vistaAgregarChequeTerceros, AdministradorPagos modelo) {
		this.vistaAgregarChequeTerceros = vistaAgregarChequeTerceros;
		this.modelo = modelo;
	}
	//comentario de prueba Belen
	 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Registro Cheque Terceros Nro: "+ vistaAgregarChequeTerceros.getNumero());
		modelo.registrarChequeTerceros(vistaAgregarChequeTerceros.getNumero(),
				   vistaAgregarChequeTerceros.getFechaEmision(), 
				   vistaAgregarChequeTerceros.getMonto());
		//Operacion existosa
		vistaAgregarChequeTerceros.operacionExitosa();
	}

}
