import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        CalculadoraDeConversion calculadora = new CalculadoraDeConversion();
        ConversorDeMonedas conversor = new ConversorDeMonedas(consulta, calculadora);
        
        int opcion = 0;
        
        while (opcion !=7){
            System.out.println("""
            1) Dólar (USD) => Peso colombiano (COP)
            2) Peso colombiano (COP) => Dólar (USD)
            3) Dólar (USD) => Real brasileño (BRL)
            4) Real brasileño (BRL) => Dólar (USD)
            5) Dólar (USD) => Peso argentino (ARS)
            6) Peso argentino (ARS) => Dólar (USD)
            7) Salir
            Elija una opción válida:
            ******************************************""");
        }
        
        try{
            opcion = lectura.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Por favor, ingrese un número válido");
            opcion = lectura.nextInt();
            continue;
        }
        
        if (ListaDeOpciones.getOpciones().containsKey(opcion)){
            System.out.println("Ingrese la cantidad: ");
            double cantidad = lectura.nextDouble();
            String fromCurrency = ListaDeOpciones.getOpciones().get(opcion)[0];
            String toCurrency = ListaDeOpciones.getOpciones().get(opcion)[1];
            conversor.realizarConversion(cantidad,fromCurrency,toCurrency);
        } else if (opcion != 7) {
            System.out.println("Opción no válida, por favor intente de nuevo.");
        }


        lectura.close();
    }
}


