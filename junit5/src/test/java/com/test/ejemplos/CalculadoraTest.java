package com.test.ejemplos;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.test.ejemplos.excepciones.DivisorCeroExcepcion;



class CalculadoraTest {
	private final static Logger log= Logger.getLogger("com.test.ejemplos.CalculadoraTest");
	
	Calculadora calculadora;
	
	@BeforeAll
	static void setup() {
		log.info("Ejecuci�n del m�todo setup() antes de ejecutarse los test");
	}
	
	@BeforeEach
	void init() {	    
	    this.calculadora= new Calculadora();
	    log.info("Ejecutamos test");
	}
	

	@Test
	@DisplayName("MI TEST")
	void add() {
		//Calculadora calculadora = new Calculadora();
		
		
		assertEquals(2, this.calculadora.sumar(1,1), "1 + 1 should equal 2");
			
		
	}

	@ParameterizedTest(name = "add({0},{1},{2})")
	@CsvSource({
		  "-2,   -3,   -5",
		   "1,    -1,   -3",
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculadora calculadora = new Calculadora();
		assertEquals(expectedResult, calculadora.sumar(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}
	
	
	@ParameterizedTest(name = "{0} / {1} = {2}")
	@CsvSource({
		  "4,   2,   2",
		   "1,    2,   0.5",
			"0,    1,   0"//,
		//	"1,   0,   0"
	})
	void divide(int numerador, int denominador, double resultado) { 
		
		Calculadora calculadora = new Calculadora();
		assertEquals(resultado, calculadora.dividir(numerador,denominador), () -> numerador + " + " + denominador + " should equal " + resultado);
	}
	
	@Test
	void divideException() { 
		
		Calculadora calculadora = new Calculadora();
		Exception exception = assertThrows( DivisorCeroExcepcion.class, () -> calculadora.dividir(1, 0));
		assertEquals("El divisor es cero", exception.getMessage());
		assertTrue(exception.getMessage().contains("cero"));
	}
	
	@Test
	 void grupo() {
	     int[] numbers = {0, 1, 2, 3, 4};
	     assertAll("numeros",
	         () -> assertEquals(numbers[0], 1),
	         () -> assertEquals(numbers[3], 3),
	         () -> assertEquals(numbers[4], 4)
	     );
	 }
	
	@AfterEach
	void fin() {
	    log.info("El test se ha ejecutado.");
	}

	@AfterAll
	static void finTests() {
	    log.info("Los tests se han ejecutado.");
	}

}
