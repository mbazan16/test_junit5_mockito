package com.test.ejemplos;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
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
		log.info("Ejecutamos test Dividir");
	}
	
	@Test
	@DisplayName("Dividir dos operandos")
	public void dividirDosOperandos(){
		
		when(calcular.operar(1,1)).thenReturn(1);
		//lenient().when(calcular.operar(3,2)).thenReturn(2);
		assertEquals(1, this.dividir.dividir(1,1), "1 / 1 should equal 1");
	}
	
	// Test realizado por Maria
	@Test
	@DisplayName("Dividir dos operandos, un de ellos por 0")
	public void dividirPorCero(){
		
		when(calcular.operar(1,0)).thenThrow(new DivisorCeroExcepcion("Division por cero"));	
		Exception  exception = assertThrows(DivisorCeroExcepcion.class, () -> this.dividir.dividir(1,0));
	}
	
	

}
