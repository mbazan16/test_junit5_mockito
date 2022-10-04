package com.test.ejemplos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.test.ejemplos.interfaces.Calcular;



class SumarTest {
	private final static Logger log= Logger.getLogger("com.test.ejemplos.CalculadoraTest");
	
	
	Sumar sumar ; 
	
	//Stub o mockito
	Calcular calcular = (int... operandos)->{return operandos[0]+operandos[1];};
	
	
	
	@BeforeEach
	void init() {	    
	   this.sumar= new Sumar(calcular);	    
		log.info("Ejecutamos test");
	}
	
	@Test
	@DisplayName("Sumar dos operandos")
	public void sumarDosOperandos(){
		
		assertEquals(2, this.sumar.sumar(1,1), "1 + 1 should equal 2");
	}
	
	
}
