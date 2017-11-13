package uade.ioo.vista.comportamiento;

import java.util.List;

import uade.ioo.modelo.Cheque;

public interface IVistaPagarServicio {
	
	double getMontoAPagar();
	void mostrarChequesDisponibles(List<Cheque> cheques);
}
