package uade.ioo.vista.formularios;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uade.ioo.controlador.RecibirChequeController;
import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.util.Util;
import uade.ioo.vista.comportamiento.IVistaAgregarChequeTercero;

public class JFormularioRecibirCheque extends JFormularioBase implements IVistaAgregarChequeTercero{

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
	
	public JFormularioRecibirCheque(AdministradorPagos modelo){
		super(modelo);
		this.setSize(180, 220);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new FlowLayout());
		this.setTitle("Registrar cheques de Terceros recibidos");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.lblNumero = new JLabel();
		this.lblNumero.setText("Numero cheque");
		this.add(lblNumero);
		
		this.txtNumero = new JTextField();
		this.txtNumero.setColumns(12);
		//Validacion formato fecha
		txtNumero .addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
		      {
		        JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
		        e.consume();
		      }
		    }
		  });
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
		this.btnRegistrar.addActionListener((new RecibirChequeController(this, getModelo())));
		this.add(btnRegistrar);

	}

	@Override
	public int getNumero() {
		if (Util.isInteger(this.txtNumero.getText())){
			return Integer.parseInt(this.txtNumero.getText());
		}
		//TODO : Validar Si falla
		return 0;
	}

	@Override
	public Date getFechaEmision() {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return formatter.parse(txtFechaEmision.getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Formato de fecha Invalido - (dd-MM-yyyy)");
			e.printStackTrace();
		}
			return null;
		
	}

	@Override
	public double getMonto() {
		if (Util.isDouble(this.txtMonto.getText())){
			return Double.parseDouble(this.txtMonto.getText());
		}
		//TODO : Validar Si falla
		return 0;
	}

	@Override
	public void operacionExistosa() {
		JOptionPane.showMessageDialog(null, "El cheque Nro: "+txtNumero.getText()+" se registro con existo.");

		//Limpio el formulario
		txtNumero.setText("");
		txtFechaEmision.setText("");
		txtMonto.setText("");
	}

}