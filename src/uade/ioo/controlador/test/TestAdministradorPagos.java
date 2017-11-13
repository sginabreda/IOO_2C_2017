package uade.ioo.controlador.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;

public class TestAdministradorPagos {
	
	@Test
	public void testRegistrarCheque(){
		
		AdministradorPagos administradorPagos = new AdministradorPagos();
		administradorPagos.registrarChequeTerceros(2, new Date(), 2300.60);
		administradorPagos.registrarChequeTerceros(3, new Date(), 2300.50);
		
		assertTrue(administradorPagos.getMontoDisponiblePagos() != 0);
		assertEquals(4601.10, administradorPagos.getMontoDisponiblePagos(), 0.1);
	}
	
	@Test
	public void testObtenerChequesDisponibles(){
		
		AdministradorPagos administradorPagos = new AdministradorPagos();
		administradorPagos.registrarChequeTerceros(2, new Date(), 1500);
		administradorPagos.registrarChequeTerceros(3, new Date(), 1000);
		administradorPagos.registrarChequeTerceros(4, new Date(), 500);
		administradorPagos.registrarChequeTerceros(5, new Date(), 200);
		
		//Cheque vencido
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add( Calendar.DATE, -60);
		
		administradorPagos.registrarChequeTerceros(5, cal.getTime(), 200);
		
		List<Cheque> chequesDisponibles = administradorPagos.obtenerChequesDisponibles(3000);
		
		double montoChequesDisponibles = obtenerMontoTotal(chequesDisponibles);
		assertEquals(3000, montoChequesDisponibles, 0.1);
	}

	private double obtenerMontoTotal(List<Cheque> chequesDisponibles) {
		double montoChequesDisponibles = 0;
		for (Cheque cheque : chequesDisponibles) {
			montoChequesDisponibles += cheque.getMonto();
		}
		return montoChequesDisponibles;
	}
	
	@Test
	public void testObtenerChequesDisponiblesExistiendoChequesVencidos(){
		
		AdministradorPagos administradorPagos = new AdministradorPagos();
		
		//Cheque vencido
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add( Calendar.DATE, -60);
		
		administradorPagos.registrarChequeTerceros(5, cal.getTime(), 200);
		
		List<Cheque> chequesDisponibles = administradorPagos.obtenerChequesDisponibles(3000);
		
		double montoChequesDisponibles = obtenerMontoTotal(chequesDisponibles);
		
		assertEquals(0,montoChequesDisponibles,0.1);
	}
}
