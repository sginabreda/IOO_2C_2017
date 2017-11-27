package uade.ioo.vista.formularios;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Banco;

public class JFormularioReporteMontos extends JFormularioBase {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JScrollPane mibarra1;
	private JTable tablaCheques;
	private JLabel reporteTotales;
	private String[] titulos = new String[] {
			"Total monto disponible para Pagos", "Total monto Pagado",
			"Total monto Depositado","Total monto emitido en cheques", "Total monto de Cheques por Vencer"};


	public JFormularioReporteMontos(AdministradorPagos modelo) {
		super(modelo);
		this.setSize(1210, 400);
		setLocation(500, 150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.reporteTotales = new JLabel();
		this.reporteTotales.setText("Reporte Totales");
		this.add(reporteTotales);

		mainPanel = new JPanel();

		JPanel tituloContainer = new JPanel();
		tituloContainer.add(reporteTotales);

		JPanel tablaChequesContainer = new JPanel();

		mibarra1 = new JScrollPane();
		mibarra1.setBounds(40, 300, 400, 130);

		tablaCheques = new JTable();
		tablaCheques
				.setPreferredScrollableViewportSize(new Dimension(1000, 200));

		DefaultTableModel modeloDatos = new DefaultTableModel(
				new Object[][] {}, this.titulos);
		tablaCheques.setModel(modeloDatos);
		// tablaReporte = new TablaReporte();

		// tablaCheques.setModel(tablaReporte);
		mibarra1.setViewportView(tablaCheques);

		tablaChequesContainer.add(mibarra1);

		JPanel confirmarContainer = new JPanel();

		mainPanel.add(tituloContainer);
		mainPanel.add(tablaChequesContainer);
		mainPanel.add(confirmarContainer);

		getContentPane().add(mainPanel);

		this.actualizar();
		if (((DefaultTableModel) tablaCheques.getModel()).getRowCount() == 0) {
			agregarFilaATabla();
		}
	}

	@Override
	public void actualizar() {
		eliminarFilaATabla();
		agregarFilaATabla();

	}

	public void agregarFilaATabla() {
		int numCols = tablaCheques.getModel().getColumnCount();

		Object[] fila = new Object[5];
		fila[0] = this.modelo.getMontoDisponiblePagos();
		fila[1] = this.modelo.getMontoPagoTotal();
		fila[2] = Banco.getMontoDepositoTotal();
		fila[3] = this.modelo.getMontoEmitidosTotal();
		fila[4] = this.modelo.getMontoPorVencerTotal();

		((DefaultTableModel) tablaCheques.getModel()).addRow(fila);

	}

	public void eliminarFilaATabla() {
		try {
			DefaultTableModel modeloDatos = new DefaultTableModel(
					new Object[][] {}, this.titulos);
			tablaCheques.setModel(modeloDatos);
		} catch (Exception e) {

		}
	}

}
