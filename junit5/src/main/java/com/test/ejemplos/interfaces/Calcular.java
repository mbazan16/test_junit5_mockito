package com.test.ejemplos.interfaces;

import com.test.ejemplos.excepciones.DivisorCeroExcepcion;

public interface Calcular {
	public int sumar(int operando1,int operando2);
	public int restar(int operando1,int operando2);
	public double multiplicar(int operando1,int operando2);
	public float dividir(int operando1,int operando2)throws DivisorCeroExcepcion;

}
