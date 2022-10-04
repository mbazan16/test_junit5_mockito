package com.test.ejemplos;

import com.test.ejemplos.interfaces.Calcular;

public class Dividir {
	Calcular calcular; 
	
	public int dividir(int...operandos) {
		return calcular.operar(operandos);
	}
/*
	public float dividirf(float...operandos) {
		return calcular.operarf(operandos);
	}*/
}
