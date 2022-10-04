/**
 * 
 */
package com.test.ejemplos;

import com.test.ejemplos.interfaces.Calcular;

/**
 * @author agranero
 *
 */
public class Dividir {
	Calcular calcular;
	 	
	public int dividir(int... operandos) {
	
		return calcular.operar(operandos);
	}

}
