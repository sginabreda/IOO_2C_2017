package uade.ioo.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.util.Util;

public class TablaChequesAVencer extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4009340209207451574L;
	private List<ChequeTerceros> cheques;
	
	private String[] columnNames = {"Nro",
            "Fecha Emisión",
            "Fecha Vencimiento",
            "Monto",
            "Estado"};
	
	public TablaChequesAVencer() {
		cheques = new ArrayList<ChequeTerceros>();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return cheques.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		ChequeTerceros cheque = cheques.get(row);
	    switch(col) {
	      case 0: return cheque.getNumero();
	      case 1: return Util.formatDate(cheque.getFechaEmision());
	      case 2: return Util.formatDate(cheque.getFechaVencimiento());
	      case 3: return cheque.getMonto();
	      case 4: return cheque.getEstadoCheque().toString();
	      // to complete here...
	      default: return "";
	    }
	}
	
	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}

	public void setCheques(List<ChequeTerceros> cheques) {
		this.cheques = cheques;
	}

	public List<ChequeTerceros> getCheques() {
		return cheques;
	}
}
