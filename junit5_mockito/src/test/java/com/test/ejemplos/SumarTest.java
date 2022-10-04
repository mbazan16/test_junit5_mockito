package com.test.ejemplos;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.test.ejemplos.interfaces.Calcular;



@ExtendWith(MockitoExtension.class)
class SumarTest {
	private final static Logger log= Logger.getLogger("com.test.ejemplos.CalculadoraTest");
	
	@InjectMocks
	Sumar sumar = new Sumar(); //IMPORTANTE: General la instancia cuando utilizamos inyección
	/*
	//Stub o mockito
	Calcular calcular = (int... operandos)->{return operandos[0]+operandos[1];};
	*/
	
	@Mock Calcular calcular;
	@BeforeEach
	void init() {	    
	   // this.sumar= new Sumar(calcular); //Cuando usamos stub o "mockito" manual
	    log.info("Ejecutamos test");
	}
	
	@Test
	@DisplayName("Sumar dos operandos")
	public void sumarDosOperandos(){
		when(calcular.operar(1,1)).thenReturn(2);
		lenient().when(calcular.operar(1,2)).thenReturn(3);
		assertEquals(2, this.sumar.sumar(1,1), "1 + 1 should equal 2");
	}
	
	
}

