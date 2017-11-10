package uade.ioo.vista.formularios;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFormularioChequesTerceros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 536513415125473448L;
	
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblFechaEmision;
	private JTextField txtFechaEmision;
	private JLabel lblMonto;
	private JTextField txtMonto;
	private JButton btnRegistrar;
	
	public JFormularioChequesTerceros(){
		this.setSize(180, 220);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new FlowLayout());
		this.setTitle("Registrar cheques de Terceros recibidos");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.lblNumero = new JLabel();
		this.lblNumero.setText("Número cheque");
		this.add(lblNumero);
		
		this.txtNumero = new JTextField();
		this.txtNumero.setColumns(12);
		this.add(txtNumero);
		
		this.lblFechaEmision = new JLabel();
		this.lblFechaEmision.setText("Fecha emisión");
		this.add(lblFechaEmision);
		
		this.txtFechaEmision = new JTextField();
		this.txtFechaEmision.setColumns(12);
		this.add(txtFechaEmision);
		
		this.lblMonto = new JLabel();
		this.lblMonto.setText("Monto");
		this.add(lblMonto);
		
		this.txtMonto = new JTextField();
		this.txtMonto.setColumns(12);
		this.add(txtMonto);
		
		this.btnRegistrar = new JButton();
		this.btnRegistrar.setText("Registrar");
		this.add(btnRegistrar);

	}

}
