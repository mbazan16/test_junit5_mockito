package com.test.ejemplos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.ejemplos.interfaces.Calcular;

@ExtendWith(MockitoExtension.class)
class DividirTest {
	private final static Logger log= Logger.getLogger("com.test.ejemplos.CalculadoraTest");

	@InjectMocks
	Dividir dividir = new Dividir();

	@Mock Calcular calcular;
	@BeforeEach
	void init() {	    
	    log.info("Ejecutamos test");
	}
	
	@Test
	@DisplayName("Division")
	public void dividirTest(){
		when(calcular.operar(4,2)).thenReturn(2); //el .thenReturn no deja que devuelva floats
		assertEquals(2, this.dividir.dividir(4,2), "4 / 2 should equal 2.0");
	}

}
