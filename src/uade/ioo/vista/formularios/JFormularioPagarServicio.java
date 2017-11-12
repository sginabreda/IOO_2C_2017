package uade.ioo.vista.formularios;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioPagarServicio extends JFormularioBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5792476665330409399L;
	
	public JFormularioPagarServicio(AdministradorPagos modelo){
		super(modelo);
		this.setSize(540,380);
		this.setTitle("Pagar servicios con cheques disponibles");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
