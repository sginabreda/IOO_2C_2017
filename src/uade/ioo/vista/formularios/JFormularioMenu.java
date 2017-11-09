package uade.ioo.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JFormularioMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JFormularioMenu() {
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO IOO 2C2017");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar;
		JMenu formularios;
		
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		formularios = new JMenu("Formularios");
		menuBar.add(formularios);

		JMenuItem form_cheques_terceros;
		form_cheques_terceros = new JMenuItem("Registrar Cheques Terceros");
		form_cheques_terceros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioChequesTerceros();
				form1.setVisible(true);
				
			}
		});
		formularios.add(form_cheques_terceros);
		
		JMenuItem form_pagar_servicio;
		form_pagar_servicio = new JMenuItem("Pagar servicios con Cheques Disponibles");
		form_pagar_servicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form2 = new JFormularioPagarServicio();
				form2.setVisible(true);
			}
		});
		formularios.add(form_pagar_servicio);
		
		JMenuItem form_cheques_terc_vence;
		form_cheques_terc_vence = new JMenuItem("Cheques de Terceros próximos a vencer");
		form_cheques_terc_vence.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form3 = new JFormularioChequesAVencer();
				form3.setVisible(true);
			}
		});
		formularios.add(form_cheques_terc_vence);
		
		JMenuItem form_reporte;
		form_reporte = new JMenuItem("Reporte Montos");
		form_reporte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form4 = new JFormularioReporteMontos();
				form4.setVisible(true);
			}
		});
		formularios.add(form_reporte);
	}

}
