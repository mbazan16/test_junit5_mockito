package com.test.ejemplos;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class DividirTest {
private final static Logger log= Logger.getLogger("com.test.ejemplos.CalculadoraTest");
	
	@InjectMocks
	Dividir dividir = new Dividir(); 

	
	@Mock Calcular calcular;
	@BeforeEach
	void init() {	    
	    log.info("Ejecutamos test");
	}
	
	@Test
	@DisplayName("dividir dos operandos")
	public void dividirDosOperandos(){
		when(calcular.operar(1,1)).thenReturn(1);
		assertEquals(1, this.dividir.dividir(1,1), "1 / 1 should equal 1");
	}
	
	/*@Test
	@DisplayName("dividir dos operandos resultado Float")
	public void dividirDosOperandosResultadoFloat(){
		when(calcular.operar(3,2)).thenReturn(1.5);
		assertEquals(1.5, this.dividir.dividir(3,2), "3 / 2 should equal 1.5 ");
	}*/
	
	@Test
	@DisplayName("Division por cero")
	public void divisionPorCero() {
		when(calcular.operar(1,0)).thenThrow(new DivisorCeroExcepcion("Division por cero"));
		Exception exception = assertThrows(DivisorCeroExcepcion.class, ()-> this.dividir.dividir(1,0));
	}
}
