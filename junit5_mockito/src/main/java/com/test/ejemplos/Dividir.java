package com.test.ejemplos;

import com.test.ejemplos.interfaces.Calcular;

public class Dividir {
	
	Calcular calcular;
	
	public float dividir(int... operandos) {
		
		return calcular.operar(operandos);
	}

}
