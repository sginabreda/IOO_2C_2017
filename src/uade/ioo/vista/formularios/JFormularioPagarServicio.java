package uade.ioo.vista.formularios;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.controlador.ChequesDisponiblesController;
import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.util.Util;
import uade.ioo.vista.comportamiento.IVistaPagarServicio;
import uade.ioo.vista.formularios.tabla.TablaChequesDisponibles;

public class JFormularioPagarServicio extends JFormularioBase implements IVistaPagarServicio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5792476665330409399L;
	
	private JTable listCheques;
    private JScrollPane mibarra1;
	private JLabel lblNumero;
	private JTextField txtMonto;
	private JButton btnConsultar;
	private TablaChequesDisponibles tablaChequesDisponibles;
	
	public JFormularioPagarServicio(AdministradorPagos modelo){
		super(modelo);
		
		this.setSize(540,380);
		this.setTitle("Pagar servicios con cheques disponibles");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		this.lblNumero = new JLabel();
		this.lblNumero.setText("Ingrese Monto a Pagar");
		this.add(lblNumero);
		
		this.txtMonto = new JTextField();
		this.txtMonto.setColumns(12);
		this.add(txtMonto);
		
		this.btnConsultar = new JButton();
		this.btnConsultar.setText("Consultar");
		this.btnConsultar.addActionListener((new ChequesDisponiblesController(this, getModelo())));
		this.add(btnConsultar);
		
		
		JPanel mainPanel = new JPanel();
		
		JPanel montoAPagarContainer = new JPanel();
		montoAPagarContainer.add(lblNumero);
		montoAPagarContainer.add(txtMonto);
		montoAPagarContainer.add(btnConsultar);
		
		JPanel tablaChequesContainer = new JPanel();
		
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(40, 300, 400, 130);
		
		tablaChequesDisponibles = new TablaChequesDisponibles();
		
		listCheques = new JTable(tablaChequesDisponibles);
		listCheques.setPreferredScrollableViewportSize(new Dimension(500, 70));
		mibarra1.setViewportView(listCheques);
		
		tablaChequesContainer.add(mibarra1);
		
		mainPanel.add(montoAPagarContainer);
		mainPanel.add(tablaChequesContainer);
		
		
		getContentPane().add(mainPanel);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getMontoAPagar() {
		
		if (Util.isDouble(this.txtMonto.getText())){
			return Double.parseDouble(this.txtMonto.getText());
		}
		//TODO : Validar Si falla
		return 0;
	}

	@Override
	public void mostrarChequesDisponibles(List<Cheque> cheques) {
		tablaChequesDisponibles.setCheques(cheques);
	}

}
