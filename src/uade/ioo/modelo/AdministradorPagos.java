package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import uade.ioo.modelo.observer.Observado;

public class AdministradorPagos extends Observado {
	Chequera c = new Chequera();
	List<Cheque> cheques = new ArrayList<Cheque>();

	public List<Cheque> obtenerChequesDisponibles(double monto) {

		List<Cheque> chequesDisponibles = new ArrayList<Cheque>();

		double montoAcumulado = 0;

		for (Cheque cheque : cheques) {

			if (!esChequeVencido(cheque)) {

				// Agrego el cheque
				chequesDisponibles.add(cheque);

				// Calculo monto acumulado
				montoAcumulado += cheque.getMonto();

				// Valido si el monto acumulado cubre el monto a pagar
				if (montoAcumulado >= monto) {
					return chequesDisponibles;
				}

			}

		}

		return chequesDisponibles;
	}

	public Cheque generarChequeNuevo(double monto) {
		int n = c.getUltimoNumero();
		Cheque nuevo = new ChequePropio(n, new Date(), monto);
		c.setUltimoNumero(n++);
		return nuevo;
	}

	public void registrarChequeTerceros(int numero, Date fechaEmision, double monto) {

		// Calculo la fecha de vencimiento
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaEmision);
		cal.add(Calendar.DATE, 30);

		this.cheques.add(new ChequeTerceros(numero, fechaEmision, cal.getTime(), monto));
		this.notificarObservadores();
	}

	public double getMontoDisponiblePagos() {
		return calcularMontoTotal(cheques);
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
}
