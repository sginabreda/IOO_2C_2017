package uade.ioo.controlador.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import uade.ioo.modelo.AdministradorPagos;

public class TestAdministradorPagos {
	
	@Test
	public void testRegistrarCheque(){
		
		AdministradorPagos administradorPagos = new AdministradorPagos();
		administradorPagos.registrarChequeTerceros(2, new Date(), 2300.60);
		administradorPagos.registrarChequeTerceros(2, new Date(), 2300.50);
		
		assertTrue(administradorPagos.getMontoDisponiblePagos() != 0);
		assertEquals(4601.10, administradorPagos.getMontoDisponiblePagos(), 0.1);
	}
}
