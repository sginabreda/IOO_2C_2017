package uade.ioo.vista.formularios;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.controlador.ConfirmarPagoServicioController;
import uade.ioo.controlador.DeterminarChequesDisponiblesController;
import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.util.Util;
import uade.ioo.vista.comportamiento.IVistaPagarServicio;
import uade.ioo.vista.formularios.tabla.TablaChequesDisponibles;

public class JFormularioPagarServicio extends JFormularioBase implements IVistaPagarServicio{

	private static final long serialVersionUID = 5792476665330409399L;
	
	private JTable tablaCheques;
    private JScrollPane mibarra1;
	private JLabel lblNumero;
	private JTextField txtMonto;
	private JButton btnConsultar;
	private TablaChequesDisponibles tablaChequesDisponibles;
	private JPanel mainPanel;

	private JButton btnConfirmar;
	
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
		this.txtMonto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
						|| (c == KeyEvent.VK_SLASH || c == KeyEvent.VK_COMMA || c == KeyEvent.VK_PERIOD))) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
					e.consume();
				}
			}
		});
		
		this.add(txtMonto);
		
		this.btnConsultar = new JButton();
		this.btnConsultar.setText("Consultar");
		this.btnConsultar.addActionListener((new DeterminarChequesDisponiblesController(this, getModelo())));
		this.add(btnConsultar);
		
		this.btnConfirmar = new JButton();
		this.btnConfirmar.setText("Confirmar Pago");
		this.btnConfirmar.addActionListener((new ConfirmarPagoServicioController(this, getModelo())));
		this.add(btnConfirmar);
		
		
		mainPanel = new JPanel();
		
		JPanel montoAPagarContainer = new JPanel();
		montoAPagarContainer.add(lblNumero);
		montoAPagarContainer.add(txtMonto);
		montoAPagarContainer.add(btnConsultar);
		
		JPanel tablaChequesContainer = new JPanel();
		
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(40, 300, 400, 130);
		
		tablaCheques = new JTable();
		tablaCheques.setPreferredScrollableViewportSize(new Dimension(500, 70));
		mibarra1.setViewportView(tablaCheques);
		
		tablaChequesContainer.add(mibarra1);
		
		JPanel confirmarContainer = new JPanel();
		confirmarContainer.add(btnConfirmar);
		
		mainPanel.add(montoAPagarContainer);
		mainPanel.add(tablaChequesContainer);
		mainPanel.add(confirmarContainer);
		
		
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
		tablaChequesDisponibles = new TablaChequesDisponibles();
		tablaChequesDisponibles.setCheques(cheques);
		tablaCheques.setModel(tablaChequesDisponibles);
		btnConfirmar.setEnabled(true);
	}

	@Override
	public void operacionExitosa() {
		JOptionPane.showMessageDialog(null, "El pago se realizo con exito.");
		tablaCheques.setModel(new TablaChequesDisponibles());
		btnConfirmar.setEnabled(false);
		
	}

	@Override
	public List<Cheque> getChequesDisponibles() {
		return tablaChequesDisponibles.getCheques();
	}

}
