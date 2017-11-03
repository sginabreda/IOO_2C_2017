package uade.ioo.vista.formularios;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JFormularioMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu formularios;
	private JMenuItem form1;

	public JFormularioMenu() {
		this.getContentPane().setLayout(new FlowLayout());
		
		this.menuBar = new JMenuBar();
		
		this.formularios = new JMenu("A menu");
		this.menuBar.add(formularios);
		
		this.form1 = new JMenuItem("Prueba de texto de formulario");
		this.formularios.add(form1);
	}

}
