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
class DividirTest {
	private final static Logger log= Logger.getLogger("com.test.ejemplos.Dividir");
	
	@InjectMocks
	Dividir div = new Dividir(); //IMPORTANTE: General la instancia cuando utilizamos inyecci�n
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
	@DisplayName("Dividir dos operandos")
	public void dividirDosOperandos(){
		when(calcular.operar(4,2)).thenReturn(2);
		lenient().when(calcular.operar(45,9)).thenReturn(5);
		assertEquals(2, this.div.dividir(4,2), "4/2 should equal 2");
	}
	
	@Test
	@DisplayName("Dividir entre cero")
	public void dividirEntreCero(){
		when(calcular.operar(1,0)).thenThrow(new DivisorCeroExcepcion("Division por cero"));
		Exception ex = assertThrows(DivisorCeroExcepcion.class, () -> this.div.dividir(1,0));
	}
	
	
}

