package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Cheque> cheques;
	
	public Banco() {
		cheques = new ArrayList<>();
	}
	
	private static Double importeDeposito= 0D;
	
	public void depositarCheque(ChequeTerceros cheque) {
		cheque.setEstadoCheque(new Depositado());
		cheques.add(cheque);
		importeDeposito += cheque.getMonto();
	}
	
	public static String getMontoDepositoTotal(){
		return importeDeposito.toString();
	}
}
