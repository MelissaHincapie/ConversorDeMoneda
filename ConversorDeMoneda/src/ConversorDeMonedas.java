import java.io.IOException;

public class ConversorDeMonedas {
    private final ConsultaTasaDeCambio consulta;
    private final CalculadoraDeConversion calculadora;

    public ConversorDeMonedas(ConsultaTasaDeCambio consulta, CalculadoraDeConversion calculadora) {
        this.consulta = consulta;
        this.calculadora = calculadora;
    }

    public void realizarConversion(double cantidad, String fromCurrency, String toCurrency) {
        try {
            Moneda monedaBase = consulta.buscarTasaDeCambio(fromCurrency);
            Double tasaDeCambio = calculadora.obtenerTasaDeCambio(monedaBase, toCurrency);

            if (tasaDeCambio != null) {
                double resultado = calculadora.convertir(cantidad, tasaDeCambio);
                System.out.printf("%.2f %s equivalen a %.2f %s%n \n" +
                        "******************************************\n", cantidad, fromCurrency, resultado, toCurrency);
            } else {
                System.out.println("No se encontró la tasa de conversión para " + toCurrency);
            }
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
