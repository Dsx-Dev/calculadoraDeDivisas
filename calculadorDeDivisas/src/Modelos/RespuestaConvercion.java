package Modelos;

/**
 * Clase que representa la respuesta de la API de conversión de monedas.
 * Esta clase se usa para convertir el JSON que devuelve la API
 * en un objeto Java que podemos usar fácilmente.
 *
 * Ejemplo de JSON que recibimos de la API:
 * {
 *   "result": "success",
 *   "base_code": "USD",
 *   "target_code": "COP",
 *   "conversion_rate": 4300.50,
 *   "conversion_result": 430050.00
 * }
 */
public class RespuestaConvercion {

    // Atributos privados que coinciden exactamente con los nombres del JSON
    // IMPORTANTE: Los nombres deben ser EXACTOS a los del JSON para que Gson funcione

    /**
     * Indica si la conversión fue exitosa o falló
     * Valores posibles: "success" o "error"
     */
    private String result;

    /**
     * Código de la moneda de origen
     * Ejemplo: "USD", "COP", "EUR", "MXN"
     */
    private String base_code;

    /**
     * Código de la moneda de destino
     * Ejemplo: "USD", "COP", "EUR", "MXN"
     */
    private String target_code;

    /**
     * Tasa de conversión entre las dos monedas
     * Ejemplo: si 1 USD = 4300.50 COP, este valor sería 4300.50
     */
    private double conversion_rate;

    /**
     * Resultado final de la conversión
     * Ejemplo: si convertimos 100 USD a COP con tasa 4300.50,
     * este valor sería 430050.00
     */
    private double conversion_result;

    // === MÉTODOS GETTERS ===
    // Estos métodos permiten acceder a los atributos privados desde otras clases

    /**
     * Obtiene el resultado de la operación
     * @return "success" si fue exitosa, "error" si falló
     */
    public String getResult() {
        return result;
    }

    /**
     * Obtiene el código de la moneda de origen
     * @return Código de 3 letras (USD, COP, EUR, MXN)
     */
    public String getBaseCode() {
        return base_code;
    }

    /**
     * Obtiene el código de la moneda de destino
     * @return Código de 3 letras (USD, COP, EUR, MXN)
     */
    public String getTargetCode() {
        return target_code;
    }

    /**
     * Obtiene la tasa de conversión
     * @return Valor numérico de cuánto vale 1 unidad de moneda origen en moneda destino
     */
    public double getConversionRate() {
        return conversion_rate;
    }

    /**
     * Obtiene el resultado final de la conversión
     * @return Cantidad convertida (cantidad original × tasa de conversión)
     */
    public double getConversionResult() {
        return conversion_result;
    }
}