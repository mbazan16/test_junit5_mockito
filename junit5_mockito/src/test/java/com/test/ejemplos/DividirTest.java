package com.test.ejemplos;

import static org.junit.jupiter.api.Assertions.*;
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

	private final static Logger log= Logger.getLogger("com.test.ejemplos.CalculadoraTest");
	
	Exception exception = new Exception();
	
	@InjectMocks
	Dividir dividir = new Dividir();
	
	
	@Mock Calcular calcular;
	@BeforeEach
	void init() {	    
	   // this.sumar= new Sumar(calcular); //Cuando usamos stub o "mockito" manual
	    log.info("Ejecutamos test");
	}
	
	@Test
	@DisplayName("Dividir dos operandos")
	public void dividirDosOperandos(){
		when(calcular.operar(1,1)).thenReturn(1);
		assertEquals(1, this.dividir.dividir(1,1), "1 / 1 should equal 1");
	}
	
	@Test
	@DisplayName("Dividir dos operandos")
	public void dividirDosOperandosDiferentes(){
		when(calcular.operar(5,8)).thenReturn(0);
		assertEquals(0, this.dividir.dividir(5,8), "5 / 8 should equal 0");
	}
	
	@Test
	@DisplayName("Dividir dos operandos")
	public void dividirDosOperandosDiferentes2(){
		when(calcular.operar(5,8)).thenReturn(0);
		assertEquals(5, this.dividir.dividir(10,2), "10 / 2 should equal 5");
	}
/*
	@Test
	@DisplayName("Dividir dos operandos float")
	public void dividirDosOperandosF(){
		when(calcular.operarf(3.0f,2.0f)).thenReturn(1.5f);
		assertEquals(1.5f, this.dividir.dividirf(3.0f,2.0f), "3 / 2 should equal 1.5");
	}
	
	@Test
	@DisplayName("Dividir dos operandos float")
	public void dividirDosOperandosFloat(){
		when(calcular.operarf(8.0f,3.0f)).thenReturn(2.6f);
		assertEquals(2.6f, this.dividir.dividirf(3.0f,2.0f), "8 / 3 should equal 2.6666");
	}
*/
	
	
	/*
	@Test(expected=exception)
	public void tiraExcepcio() {
		
	}*/
}

	


