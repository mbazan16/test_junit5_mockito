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

import com.test.ejemplos.excepciones.DivisorCeroExcepcion;
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
	@DisplayName("Division test")
	public void dividirTest(){
		when(calcular.operar(4,2)).thenReturn(2);
		assertEquals(2, this.dividir.dividir(4,2), "4 / 2 should equal");
	}
	
//	@Test
//	@DisplayName("Division test con resultado decimal")
//	public void dividirTestConFloat(){
//		when(calcular.operar(3,2)).thenReturn(1.5);
//		assertEquals(2, this.dividir.dividir(4,2), "3 / 2 should equal 1.5");
//	}
	
	@Test
	@DisplayName("Division test con división entre 0")
	public void dividirTestConExcepcionEntreCero(){
		when(calcular.operar(1, 0)).thenThrow(new DivisorCeroExcepcion("Division entre 0."));
		Exception exception = assertThrows(DivisorCeroExcepcion.class, () -> this.dividir.dividir(1,0));
	}

}
