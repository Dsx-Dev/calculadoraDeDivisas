package Modelos;

/**
 * 🐬 DivisasDsx - Modelo de datos para la respuesta de la API
 *
 * Esta clase representa la estructura JSON que devuelve ExchangeRate-API
 * cuando solicitamos una conversión de monedas.
 *
 * Ejemplo de JSON recibido:
 * {
 *   "result": "success",
 *   "base_code": "USD",
 *   "target_code": "COP",
 *   "conversion_rate": 3779.4739,
 *   "conversion_result": 377947.39
 * }
 *
 * IMPORTANTE: Los nombres de los atributos deben coincidir EXACTAMENTE
 * con los nombres en el JSON para que Gson pueda hacer la conversión
 * automática de JSON a objeto Java.
 *
 * @author Tu nombre
 * @version 1.0
 */
public class RespuestaAPI {

    // ═══════════════════════════════════════════════════════════
    // ATRIBUTOS PRIVADOS
    // ═══════════════════════════════════════════════════════════

    /**
     * Indica si la solicitud fue exitosa o falló.
     * Valores posibles:
     * - "success": La conversión se realizó correctamente
     * - "error": Hubo un problema con la solicitud
     */
    private String result;

    /**
     * Código ISO 4217 de la moneda origen.
     * Ejemplos: "USD", "COP", "EUR", "MXN"
     */
    private String base_code;

    /**
     * Código ISO 4217 de la moneda destino.
     * Ejemplos: "USD", "COP", "EUR", "MXN"
     */
    private String target_code;

    /**
     * Tasa de conversión entre las dos monedas.
     * Indica cuánto vale 1 unidad de la moneda origen
     * en términos de la moneda destino.
     *
     * Ejemplo: Si conversion_rate = 3779.4739
     * significa que 1 USD = 3779.4739 COP
     */
    private double conversion_rate;

    /**
     * Resultado final de la conversión.
     * Es el cálculo de: cantidad_original × conversion_rate
     *
     * Ejemplo: Si convertimos 100 USD a COP con rate 3779.4739
     * el conversion_result sería 377947.39
     */
    private double conversion_result;


    // ═══════════════════════════════════════════════════════════
    // MÉTODOS GETTERS
    // ═══════════════════════════════════════════════════════════
    // Los getters permiten acceder a los atributos privados
    // desde otras clases del proyecto.
    // ═══════════════════════════════════════════════════════════

    /**
     * Obtiene el estado de la operación.
     * @return "success" si fue exitosa, "error" si falló
     */
    public String getResult() {
        return result;
    }

    /**
     * Obtiene el código de la moneda origen.
     * @return Código de 3 letras (USD, COP, EUR, MXN)
     */
    public String getBaseCode() {
        return base_code;
    }

    /**
     * Obtiene el código de la moneda destino.
     * @return Código de 3 letras (USD, COP, EUR, MXN)
     */
    public String getTargetCode() {
        return target_code;
    }

    /**
     * Obtiene la tasa de conversión.
     * @return Valor numérico que indica cuánto vale 1 unidad
     *         de la moneda origen en la moneda destino
     */
    public double getConversionRate() {
        return conversion_rate;
    }

    /**
     * Obtiene el resultado final de la conversión.
     * @return Cantidad convertida (cantidad × tasa)
     */
    public double getConversionResult() {
        return conversion_result;
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODO TOSTRING (OPCIONAL - ÚTIL PARA DEBUGGING)
    // ═══════════════════════════════════════════════════════════

    /**
     * Convierte el objeto a una representación legible en texto.
     * Útil para imprimir el objeto y ver su contenido.
     * @return String con todos los datos formateados
     */
    @Override
    public String toString() {
        return "RespuestaAPI{" +
                "result='" + result + '\'' +
                ", base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", conversion_result=" + conversion_result +
                '}';
    }
}