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
class DividirTest {
	private final static Logger log= Logger.getLogger("com.test.ejemplos.DividirTest");
	
	@InjectMocks
	Dividir dividir= new Dividir(); //IMPORTANTE: General la instancia cuando utilizamos inyecci�n
	/*
	//Stub o mockito
	Calcular calcular = (int... operandos)->{return operandos[0]+operandos[1];};
	*/
	
	@Mock Calcular calcular;
	@BeforeEach
	void init() {	    
	    //this.dividir= new Dividir(calcular); //Cuando usamos stub o "mockito" manual
	    log.info("Ejecutamos test");
	}
	
	@Test
	@DisplayName("Division dos operandos")
	public void dividirPorCero(){
		when(calcular.operar(1,1)).thenReturn(1);
		assertEquals(1, this.dividir.dividir(1,1), "1 / 1 should equal 1");
	}
	
	
	
	
}


