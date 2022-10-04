package com.test.ejemplos;

import com.test.ejemplos.excepciones.DivisorCeroExcepcion;
import com.test.ejemplos.interfaces.Calcular;

public class Calculadora implements Calcular{

	public int sumar(int operando1, int operando2) {
	
		return operando1+operando2;
	}

	public int restar(int operando1, int operando2) {
	
		return operando1-operando2;
	}

	public double multiplicar(int operando1, int operando2) {
	
		return operando1*operando2;
	}

	public float dividir(int operando1, int operando2) {
		if(operando2==0) throw new DivisorCeroExcepcion("El divisor es cero");
	
		return (float)operando1/operando2;
	}

}
