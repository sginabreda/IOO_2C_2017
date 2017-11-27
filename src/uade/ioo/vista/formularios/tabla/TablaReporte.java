package uade.ioo.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.util.Util;

public class TablaReporte extends AbstractTableModel {

	private static final long serialVersionUID = -4009340209207451574L;
	private List<Cheque> cheques;
	AdministradorPagos modelo;
	
	private String[] columnNames = {"Monto Total",
            "Total monto disponible para Pagos",
            "Total monto Pagado",
            "Total monto Depositado",
            "Total monto de Cheques por Vencer"};
	
	public TablaReporte() {
		cheques = new ArrayList<Cheque>();
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
		Cheque cheque = cheques.get(row);
	    switch(col) {
	      case 0: return Double.toString(this.modelo.calcularMontoTotal(cheques));
	      case 1: return Double.toString(this.modelo.getMontoDisponiblePagos());
	      case 2: return Double.toString(this.modelo.calcularMontoTotal(cheques));
	      case 3: return Double.toString(this.modelo.calcularMontoTotal(cheques));
	      case 4: return Double.toString(montoChequesAVencer());	    
	      default: return "";
	    }
	}
	
	private double montoChequesAVencer() {
		double numero;
		double suma=0;
		List<ChequeTerceros> totalChequesAVencer= this.modelo.obtenerChequesAVencer();
		String montoTotal="";
		double t= totalChequesAVencer.get(getRowCount()).getMonto();
		for (int i=0; i < t; i++){
			montoTotal= totalChequesAVencer.toString();
			numero = Double.parseDouble(montoTotal);
			suma= suma + numero;
		}

		
		return 0;
	}

	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

}
