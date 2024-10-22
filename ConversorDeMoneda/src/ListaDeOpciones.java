import java.util.HashMap;
import java.util.Map;

public class ListaDeOpciones {
    private final Map<Integer, String[]> opciones;

    public ListaDeOpciones() {
        this.opciones = new HashMap<>();

        // Mapeo de opciones a códigos de moneda
        opciones.put(1, new String[]{"USD", "COP"});
        opciones.put(2, new String[]{"COP", "USD"});
        opciones.put(3, new String[]{"USD", "BRL"});
        opciones.put(4, new String[]{"BRL", "USD"});
        opciones.put(5, new String[]{"USD", "ARS"});
        opciones.put(6, new String[]{"ARS", "USD"});
    }

    public static Map<Integer, String[]> getOpciones() {
        return opciones;
    }


}