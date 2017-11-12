package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import uade.ioo.modelo.observer.Observado;

public class AdministradorPagos extends Observado{
	Chequera c = new Chequera();
	List<Cheque> cheques = new ArrayList<Cheque>();
	
	public void obtenerChequesParaPagar(double monto){
		
	}
	
	public Cheque generarChequeNuevo(double monto){
		int n = c.getUltimoNumero();
		Cheque nuevo = new ChequePropio(n, new Date(), monto);
		c.setUltimoNumero(n++);
		return nuevo;
	}
	
	public void registrarChequeTerceros(int numero, Date fechaEmision, double monto){
		
		//Calculo la fecha de vencimiento
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaEmision);
		cal.add( Calendar.DATE, 30);
		
		this.cheques.add(new ChequeTerceros(numero, fechaEmision, cal.getTime() , monto));
		this.notificarObservadores();
	}
	
	public double getMontoDisponiblePagos(){
		
		Date date = new Date();
		double total = 0;
		
		for (Cheque cheque : cheques) {
			
			if(!date.after(cheque.getFechaVencimiento())){
				total += cheque.getMonto();
			}
		}
	
		return total;
	}
}
