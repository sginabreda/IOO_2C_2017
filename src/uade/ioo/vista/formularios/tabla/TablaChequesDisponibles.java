package uade.ioo.vista.formularios.tabla;

import javax.swing.table.AbstractTableModel;

public class TablaChequesDisponibles extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4009340209207451574L;
	
	private String[] columnNames = {"Nro",
            "Fecha Emisión",
            "Fecha Vencimento",
            "Monto"};

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if (arg0 == 0) {

			if (arg1 == 0) {

				return "Numero";

			}

		}

		return Integer.toString(arg0) + "-" + Integer.toString(arg1);
	}
	
	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}
}
