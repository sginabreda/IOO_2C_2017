package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministradorPagos {
	Chequera c = new Chequera();
	List<Cheque> listaChequesTerc = new ArrayList<Cheque>();
	
	public void obtenerChequesParaPagar(double monto){
		
	}
	
	public Cheque generarChequeNuevo(double monto){
		int n = c.getUltimoNumero();
		Cheque nuevo = new ChequePropio(n, new Date(), monto);
		c.setUltimoNumero(n++);
		return nuevo;
	}
	
	public void registrarChequeTerceros(int numero, Date fechaEmision, double monto){
		listaChequesTerc.add(new ChequeTerceros(numero, fechaEmision, monto));
	}
	
	public double getMontoDisponiblePagos(){
		return 0;
	}
}
