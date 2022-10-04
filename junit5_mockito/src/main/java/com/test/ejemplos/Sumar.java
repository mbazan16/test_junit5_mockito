package com.test.ejemplos;

import com.test.ejemplos.interfaces.Calcular;

public class Sumar {
	
	Calcular calcular;
	/*Cuando usamos stub o "mockito" manual
	public Sumar(Calcular calcular) {
		this.calcular=calcular;
	}*/
	 	
	public int sumar(int... operandos) {
	
		return calcular.operar(operandos);
	}

}
