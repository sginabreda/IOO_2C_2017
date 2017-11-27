package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uade.ioo.modelo.observer.Observado;
import uade.ioo.util.Util;

public class AdministradorPagos extends Observado {

	private Chequera chequera;
	private List<ChequeTerceros> chequesTerceros;
	private Banco banco;
	private Double importePagos = 0D;
	private Double importeEmitidos = 0D;

	public AdministradorPagos() {
		chequera = new Chequera();
		chequesTerceros = new ArrayList<ChequeTerceros>();
		banco = new Banco();
	}

	public List<Cheque> obtenerChequesDisponibles(double monto) {

		List<Cheque> chequesDisponibles = new ArrayList<Cheque>();

		for (Cheque cheque : chequesTerceros) {

			if (!esChequeVencido(cheque) && !esChequeEntregado(cheque)) {

				System.out.println(cheque.getMonto());
				// Valido si el monto acumulado cubre el monto a pagar
				if (cheque.getMonto() <= monto) {

					// Agrego el cheque
					chequesDisponibles.add(cheque);

					return chequesDisponibles;
				}

			}

		}

		return chequesDisponibles;
	}

	public static boolean esChequeEntregado(Cheque cheque) {

		ChequeTerceros chequeTerceros = (ChequeTerceros) cheque;

		return chequeTerceros.getEstadoCheque() instanceof Entregado;
	}

	public Cheque generarChequeNuevo(double monto) {
		int n = chequera.getUltimoNumero();
		Cheque nuevo = new ChequePropio(n, new Date(), monto);
		chequera.setUltimoNumero(n++);

		importeEmitidos += monto;
		return nuevo;
	}

	public String getMontoEmitidosTotal() {
		return importeEmitidos.toString();
	}

	public void registrarChequeTerceros(int numero, Date fechaEmision,
			double monto) {

		this.chequesTerceros.add(new ChequeTerceros(numero, fechaEmision, Util
				.addDays(fechaEmision, 30), monto));
		
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

	public void registrarPago(List<Cheque> chequesDisponibles, double monto) {
		for (Cheque cheque : chequesDisponibles) {
			double montoParcial=0D;
			
			if (cheque instanceof ChequePropio) {
				chequera.agregarChequePropio((ChequePropio) cheque);
				montoParcial=(monto - cheque.getMonto());
			} else {
				ChequeTerceros chequeTercero = (ChequeTerceros) cheque;
				chequeTercero.setEstadoCheque(new Entregado());
				chequeTercero.setMonto(montoParcial);
			}
		}
		importePagos += monto;
		this.notificarObservadores();
	}

	public String getMontoPagoTotal() {
		return importePagos.toString();
	}

	public void depositar(List<ChequeTerceros> chequesADepositar) {
		for (ChequeTerceros cheque : chequesADepositar) {
			banco.depositarCheque(cheque);
			cheque.setMonto(0);
			}
		this.notificarObservadores();
	}

	public List<ChequeTerceros> obtenerChequesAVencer() {

		List<ChequeTerceros> chequesAVencer = new ArrayList<ChequeTerceros>();

		for (ChequeTerceros cheque : chequesTerceros) {
			if (cheque.getEstadoCheque() instanceof Recibido) {
				chequesAVencer.add(cheque);
			}
		}

		return chequesAVencer;
	}

}
