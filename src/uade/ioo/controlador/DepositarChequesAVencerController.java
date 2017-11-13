package uade.ioo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaChequesAVencer;

public class DepositarChequesAVencerController implements ActionListener {
	
	
	private IVistaChequesAVencer vistaChequesAVencer;
	private AdministradorPagos modelo;

	public DepositarChequesAVencerController(IVistaChequesAVencer vistaChequesAVencer, AdministradorPagos modelo) {
		this.vistaChequesAVencer = vistaChequesAVencer;
		this.modelo = modelo;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		

	}

}
