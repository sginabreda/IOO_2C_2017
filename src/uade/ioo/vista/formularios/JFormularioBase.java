package uade.ioo.vista.formularios;

import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.observer.IObservador;

public abstract class JFormularioBase extends JFrame implements IObservador{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3416255884450715697L;
	
	protected AdministradorPagos modelo;

	public JFormularioBase(AdministradorPagos modelo) throws HeadlessException {
		super();
		this.modelo = modelo;
		this.modelo.registrarObservador(this);
	}

	public AdministradorPagos getModelo() {
		return modelo;
	}

	public void actualizar(List<Cheque> listaCheques) {
		// TODO Auto-generated method stub
		
	}


}
