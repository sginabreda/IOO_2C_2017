package uade.ioo.vista.formularios;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioBase extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3416255884450715697L;
	
	private AdministradorPagos modelo;

	public JFormularioBase(AdministradorPagos modelo) throws HeadlessException {
		super();
		this.modelo = modelo;
	}

	public AdministradorPagos getModelo() {
		return modelo;
	}

}
