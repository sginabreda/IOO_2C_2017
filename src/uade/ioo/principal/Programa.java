package uade.ioo.principal;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.formularios.JFormularioPrincipal;

public class Programa {

	public static void main(String[] args) {
		
		JFrame form = new JFormularioPrincipal(new AdministradorPagos());
		form.setVisible(true);
	}
}
