package uade.ioo.vista.formularios;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioChequesAVencer extends JFormularioBase {

	/**
	 * Test
	 */
	private static final long serialVersionUID = -3095074904976216955L;
	
	public JFormularioChequesAVencer(AdministradorPagos modelo){
		super(modelo);
		this.setSize(540,380);
		this.setTitle("Cheques de Terceros pr�ximos a vencer");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

}
