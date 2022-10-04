import com.test.ejemplos.Calculadora;

public class App {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		float resultado=calculadora.dividir(1, 0);
		System.out.println("Resultado:"+resultado);

	}

}
