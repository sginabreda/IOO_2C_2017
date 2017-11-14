package uade.ioo.vista.formularios;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sun.javafx.scene.control.skin.TableColumnHeader;

import uade.ioo.controlador.DepositarChequesAVencerController;
import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.vista.comportamiento.IVistaChequesAVencer;
import uade.ioo.vista.formularios.tabla.TablaChequesAVencer;

public class JFormularioChequesAVencer extends JFormularioBase implements IVistaChequesAVencer {

	/**
	 * Test
	 */
	private static final long serialVersionUID = -3095074904976216955L;
	private JPanel mainPanel;
	private JScrollPane mibarra1;
	private JTable tablaCheques;
	private JButton btnDepositar;
	private JLabel chequesAVencer;
	private TablaChequesAVencer tablaChequesAVencer;
	
	public JFormularioChequesAVencer(AdministradorPagos modelo){
		super(modelo);
		this.setSize(540,380);
		this.setTitle("Cheques de Terceros proximos a vencer");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.btnDepositar = new JButton();
		this.btnDepositar.setText("Confirmar Deposito");
		this.btnDepositar.addActionListener((new DepositarChequesAVencerController(this, getModelo())));
		this.add(btnDepositar);
		
		this.chequesAVencer = new JLabel();
		this.chequesAVencer.setText("Cheques a Vencer");
		this.add(chequesAVencer);
		
		mainPanel = new JPanel();
		
		JPanel tituloContainer = new JPanel();
		tituloContainer.add(chequesAVencer);
		
		JPanel tablaChequesContainer = new JPanel();
		
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(40, 300, 400, 130);
		
		
		tablaCheques = new JTable();
		tablaCheques.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		tablaChequesAVencer = new TablaChequesAVencer();
		tablaChequesAVencer.setCheques(getModelo().obtenerChequesAVencer());
		
		tablaCheques.setModel(tablaChequesAVencer);
		mibarra1.setViewportView(tablaCheques);

		tablaChequesContainer.add(mibarra1);
		
		JPanel confirmarContainer = new JPanel();
		confirmarContainer.add(btnDepositar);
		
		mainPanel.add(tituloContainer);
		mainPanel.add(tablaChequesContainer);
		mainPanel.add(confirmarContainer);
		
		validarTablaVacia();
		
		
		getContentPane().add(mainPanel);
	}

	private void validarTablaVacia() {
		if(tablaChequesAVencer.getRowCount() == 0){
			btnDepositar.setEnabled(false);
		}
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChequeTerceros> getChequesADepositar() {
		
		return tablaChequesAVencer.getCheques();
	}

	@Override
	public void operacionExitosa() {
		JOptionPane.showMessageDialog(null, "El deposito se realizo con exito.");
		validarTablaVacia();
		tablaCheques.setModel(new TablaChequesAVencer());
	}

}
