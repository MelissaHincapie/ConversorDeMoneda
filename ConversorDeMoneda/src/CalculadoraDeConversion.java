import java.util.Map;

public class CalculadoraDeConversion {

    public double convertir(double cantidad, double tasaDeCambio) {
        return cantidad * tasaDeCambio;
    }

    public Double obtenerTasaDeCambio(Moneda moneda, String toCurrency) {
        Map<String, Double> rates = moneda.conversion_rates();
        return rates.get(toCurrency);
    }
}