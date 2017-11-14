package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uade.ioo.modelo.observer.Observado;
import uade.ioo.util.Util;

public class AdministradorPagos extends Observado {
	
	Chequera chequera;
	List<ChequeTerceros> chequesTerceros;
	Banco banco;
	
	public AdministradorPagos() {
		chequera = new Chequera();
		chequesTerceros = new ArrayList<ChequeTerceros>();
		banco = new Banco();
	}

	public List<Cheque> obtenerChequesDisponibles(double monto) {

		List<Cheque> chequesDisponibles = new ArrayList<Cheque>();

		for (Cheque cheque : chequesTerceros) {

			if (!esChequeVencido(cheque)) {
				
				// Valido si el monto acumulado cubre el monto a pagar
				if ( cheque.getMonto() <= monto) {
					
					// Agrego el cheque
					chequesDisponibles.add(cheque);
					
					return chequesDisponibles;
				}

			}

		}

		return chequesDisponibles;
	}

	public Cheque generarChequeNuevo(double monto) {
		int n = chequera.getUltimoNumero();
		Cheque nuevo = new ChequePropio(n, new Date(), monto);
		chequera.setUltimoNumero(n++);
		return nuevo;
	}

	public void registrarChequeTerceros(int numero, Date fechaEmision, double monto) {

		this.chequesTerceros.add(new ChequeTerceros(numero, fechaEmision, Util.addDays(fechaEmision, 30), monto));
		this.notificarObservadores();
		
	}

	public double getMontoDisponiblePagos() {
		double total = 0;

		for (Cheque cheque : chequesTerceros) {

			if (!esChequeVencido(cheque)) {
				total += cheque.getMonto();
			}
		}

		return total;
	}

	public boolean esChequeVencido(Cheque cheque) {
		return new Date().after(cheque.getFechaVencimiento());
	}

	public double calcularMontoTotal(List<Cheque> listaCheques) {

		double total = 0;

		for (Cheque cheque : listaCheques) {

			if (!esChequeVencido(cheque)) {
				total += cheque.getMonto();
			}
		}

		return total;
	}

	public void registrarPago(List<Cheque> chequesDisponibles) {
		for (Cheque cheque : chequesDisponibles) {
			
			if(cheque instanceof ChequePropio){
				chequera.agregarChequePropio((ChequePropio) cheque);
			}else{
				ChequeTerceros chequeTercero = (ChequeTerceros) cheque;
				chequeTercero.setEstadoCheque(new Entregado());
			}
		}
		
		this.notificarObservadores();
	}

	public void depositar(List<ChequeTerceros> chequesADepositar) {
		for (ChequeTerceros cheque : chequesADepositar) {
			banco.depositarCheque(cheque);
		}
		this.notificarObservadores();
	}

	public List<ChequeTerceros> obtenerChequesAVencer() {
		
		List<ChequeTerceros> chequesAVencer = new ArrayList<ChequeTerceros>();
		
		for (ChequeTerceros cheque : chequesTerceros) {
			if(cheque.getEstadoCheque() instanceof Recibido){
				chequesAVencer.add(cheque);
			}
		}
		
		return chequesAVencer;
	}
}
