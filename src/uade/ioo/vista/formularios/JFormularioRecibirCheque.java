package uade.ioo.vista.formularios;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uade.ioo.controlador.RecibirChequeController;
import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.util.Util;
import uade.ioo.vista.comportamiento.IVistaAgregarChequeTercero;

public class JFormularioRecibirCheque extends JFormularioBase implements IVistaAgregarChequeTercero {

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

	public JFormularioRecibirCheque(AdministradorPagos modelo) {
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
		// Validacion formato fecha
		txtNumero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
						|| (c == KeyEvent.VK_SLASH))) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
					e.consume();
				}
			}
		});
		this.add(txtNumero);

		this.lblFechaEmision = new JLabel();
		this.lblFechaEmision.setText("Fecha emisi�n");
		this.add(lblFechaEmision);

		this.txtFechaEmision = new JTextField();
		this.txtFechaEmision.setColumns(12);
		this.add(txtFechaEmision);

		this.lblMonto = new JLabel();
		this.lblMonto.setText("Monto");
		this.add(lblMonto);

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

		this.btnRegistrar = new JButton();
		this.btnRegistrar.setText("Registrar");
		this.btnRegistrar.addActionListener((new RecibirChequeController(this, getModelo())));
		this.add(btnRegistrar);

	}

	public int getNumero() {
		if (!txtNumero.getText().equals("")) {
			if (Util.isInteger(this.txtNumero.getText())) {
				return Integer.parseInt(this.txtNumero.getText());
			}
		} else {
			JOptionPane.showMessageDialog(null, "N�mero de cheque es un campo obligatorio");
		}
		return 0;
	}

	public Date getFechaEmision() {

		Date date = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		if (!txtFechaEmision.getText().equals("")) {
			try {
				date = formato.parse(txtFechaEmision.getText());
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar una fecha v�lida (dd/mm/aaaa)");
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Fecha emisi�n es un campo obligatorio");
		}

		return date;
	}

	public double getMonto() {
		if (!txtMonto.getText().equals("")) {
			if (Util.isDouble(this.txtMonto.getText())) {
				return Double.parseDouble(this.txtMonto.getText());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Monto es un campo obligatorio");
		}
		return 0;
	}

	public void operacionExitosa() {
		JOptionPane.showMessageDialog(null, "El cheque Nro.: " + txtNumero.getText() + " se registro con exito.");

		limpiarCampos();
	}

	private void limpiarCampos() {
		txtNumero.setText("");
		txtFechaEmision.setText("");
		txtMonto.setText("");
	}

	public void actualizar() {

	}

}
