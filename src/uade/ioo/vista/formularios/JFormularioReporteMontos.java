package uade.ioo.vista.formularios;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.formularios.tabla.TablaReporte;

public class JFormularioReporteMontos extends JFormularioBase {

	private static final long serialVersionUID = 1L;

	private TablaReporte tablaReporte;
	private JPanel mainPanel;
	private JScrollPane mibarra1;
	private JTable tablaCheques;
	private JLabel reporteTotales;

	public JFormularioReporteMontos(AdministradorPagos modelo){
		super(modelo);
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		this.reporteTotales = new JLabel();
		this.reporteTotales.setText("Repote Totales");
		this.add(reporteTotales);
		
		mainPanel = new JPanel();
		
		JPanel tituloContainer = new JPanel();
		tituloContainer.add(reporteTotales);
		
		JPanel tablaChequesContainer = new JPanel();
		
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(40, 300, 400, 130);
		
		
		tablaCheques = new JTable();
		tablaCheques.setPreferredScrollableViewportSize(new Dimension(500, 100));
		
		tablaReporte = new TablaReporte();
		
		tablaCheques.setModel(tablaReporte);
		mibarra1.setViewportView(tablaCheques);

		tablaChequesContainer.add(mibarra1);
		
		JPanel confirmarContainer = new JPanel();
		
		
		mainPanel.add(tituloContainer);
		mainPanel.add(tablaChequesContainer);
		mainPanel.add(confirmarContainer);
		
		
		getContentPane().add(mainPanel);
		
		this.actualizar();
	}


	@Override
	public void actualizar() {

	}

}
