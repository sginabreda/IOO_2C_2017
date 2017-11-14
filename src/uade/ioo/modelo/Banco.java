package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Cheque> cheques;
	
	public Banco() {
		cheques = new ArrayList<>();
	}

	public void depositarCheque(ChequeTerceros cheque) {
		cheque.setEstadoCheque(new Depositado());
		cheques.add(cheque);
	}
	
}
