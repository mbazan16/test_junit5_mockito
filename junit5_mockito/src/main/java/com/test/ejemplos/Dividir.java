package com.test.ejemplos;

import com.test.ejemplos.excepciones.DivisorCeroExcepcion;
import com.test.ejemplos.interfaces.Calcular;

public class Dividir {
	Calcular calcular;
	
	/*Cuando usamos stub o "mockito" manual
	public Sumar(Calcular calcular) {
		this.calcular=calcular;
	}*/
	 	
	public int dividir(int... operandos) {
		if(operandos[1] == 0)
			throw new DivisorCeroExcepcion("El segundo operando es un 0");
	
		return calcular.operar(operandos);
	}
}


