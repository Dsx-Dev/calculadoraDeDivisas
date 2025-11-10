package servicios;

// ═══════════════════════════════════════════════════════════
// IMPORTS NECESARIOS
// ═══════════════════════════════════════════════════════════
import java.net.HttpURLConnection;  // Para realizar conexiones HTTP
import java.net.URL;                 // Para crear y manejar URLs
import java.io.BufferedReader;       // Para leer la respuesta línea por línea
import java.io.InputStreamReader;    // Para convertir bytes en texto
import com.google.gson.Gson;         // Para convertir JSON a objetos Java
import modelos.RespuestaAPI;         // Nuestro modelo de datos

/**
 * 🐬 DivisasDsx - Servicio de conexión con ExchangeRate-API
 *
 * Esta clase se encarga de toda la comunicación con la API externa
 * de conversión de monedas. Realiza las peticiones HTTP, obtiene
 * las respuestas en formato JSON y las convierte en objetos Java.
 *
 * API utilizada: https://www.exchangerate-api.com/
 * Endpoint: https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{FROM}/{TO}/{AMOUNT}
 *
 * @author Tu nombre
 * @version 1.0
 */
public class ConexionAPI {

    // ═══════════════════════════════════════════════════════════
    // CONSTANTES Y ATRIBUTOS
    // ═══════════════════════════════════════════════════════════

    /**
     * URL base de la API de ExchangeRate
     * Versión 6 de la API
     */
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    /**
     * Clave de API personal proporcionada por ExchangeRate-API
     * Se obtiene al registrarse en https://www.exchangerate-api.com/
     */
    private String apiKey;

    /**
     * Tiempo máximo de espera para establecer conexión (en milisegundos)
     * 5000 ms = 5 segundos
     */
    private static final int TIMEOUT_CONEXION = 5000;

    /**
     * Tiempo máximo de espera para leer la respuesta (en milisegundos)
     * 5000 ms = 5 segundos
     */
    private static final int TIMEOUT_LECTURA = 5000;


    // ═══════════════════════════════════════════════════════════
    // CONSTRUCTOR
    // ═══════════════════════════════════════════════════════════

    /**
     * Constructor de la clase ConexionAPI.
     * Inicializa el servicio con la clave de API proporcionada.
     *
     * @param apiKey Clave de API obtenida de exchangerate-api.com
     */
    public ConexionAPI(String apiKey) {
        this.apiKey = apiKey;
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODO PRINCIPAL: OBTENER CONVERSIÓN
    // ═══════════════════════════════════════════════════════════

    /**
     * Realiza una conversión de moneda consultando la API.
     *
     * Proceso:
     * 1. Construye la URL con los parámetros
     * 2. Establece conexión HTTP
     * 3. Lee la respuesta JSON
     * 4. Convierte JSON a objeto Java
     * 5. Retorna el resultado
     *
     * @param monedaOrigen Código ISO de moneda origen (USD, COP, EUR, MXN)
     * @param monedaDestino Código ISO de moneda destino (USD, COP, EUR, MXN)
     * @param cantidad Cantidad a convertir (debe ser > 0)
     * @return Objeto RespuestaAPI con los datos, o null si hay error
     */
    public RespuestaAPI convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {

        try {
            // ═══════════════════════════════════════════════════════
            // PASO 1: CONSTRUIR LA URL
            // ═══════════════════════════════════════════════════════
            // Formato: https://v6.exchangerate-api.com/v6/{KEY}/pair/{FROM}/{TO}/{AMOUNT}
            // Ejemplo: https://v6.exchangerate-api.com/v6/481e8e687a7697fbddfde5cc/pair/USD/COP/100

            String urlCompleta = URL_BASE + apiKey + "/pair/" +
                    monedaOrigen + "/" + monedaDestino + "/" + cantidad;

            // Mensaje informativo (útil para debugging)
            System.out.println("🔗 Conectando a la API...");
            System.out.println("   Conversión: " + monedaOrigen + " → " + monedaDestino);


            // ═══════════════════════════════════════════════════════
            // PASO 2: ESTABLECER CONEXIÓN HTTP
            // ═══════════════════════════════════════════════════════

            // Crear objeto URL a partir del String
            URL url = new URL(urlCompleta);

            // Abrir conexión HTTP
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            // Configurar método de petición como GET (obtener datos)
            conexion.setRequestMethod("GET");

            // Establecer tiempo máximo para conectar
            conexion.setConnectTimeout(TIMEOUT_CONEXION);

            // Establecer tiempo máximo para leer respuesta
            conexion.setReadTimeout(TIMEOUT_LECTURA);


            // ═══════════════════════════════════════════════════════
            // PASO 3: VERIFICAR CÓDIGO DE RESPUESTA HTTP
            // ═══════════════════════════════════════════════════════
            // Códigos HTTP más comunes:
            // - 200: OK (éxito)
            // - 401: No autorizado (API Key inválida)
            // - 404: No encontrado
            // - 500: Error del servidor

            int codigoRespuesta = conexion.getResponseCode();

            if (codigoRespuesta != 200) {
                System.out.println("❌ Error HTTP: Código " + codigoRespuesta);

                // Mensajes específicos según el código
                switch (codigoRespuesta) {
                    case 401:
                        System.out.println("   API Key inválida o expirada");
                        break;
                    case 404:
                        System.out.println("   Recurso no encontrado");
                        break;
                    case 429:
                        System.out.println("   Demasiadas peticiones - límite alcanzado");
                        break;
                    default:
                        System.out.println("   Error del servidor");
                }

                return null;
            }


            // ═══════════════════════════════════════════════════════
            // PASO 4: LEER LA RESPUESTA JSON
            // ═══════════════════════════════════════════════════════

            // InputStreamReader convierte los bytes que llegan en caracteres
            // BufferedReader permite leer el texto línea por línea (más eficiente)
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream())
            );

            // StringBuilder es más eficiente que String para concatenar
            StringBuilder respuestaJson = new StringBuilder();
            String linea;

            // Leer línea por línea hasta que no haya más contenido
            while ((linea = lector.readLine()) != null) {
                respuestaJson.append(linea);
            }

            // Cerrar el lector para liberar recursos del sistema
            lector.close();

            // Cerrar la conexión HTTP
            conexion.disconnect();


            // ═══════════════════════════════════════════════════════
            // PASO 5: CONVERTIR JSON A OBJETO JAVA
            // ═══════════════════════════════════════════════════════
            // Aquí ocurre la "magia" de Gson

            Gson gson = new Gson();

            // fromJson() lee el String JSON y crea automáticamente un objeto
            // RespuestaAPI con todos los valores asignados
            RespuestaAPI respuesta = gson.fromJson(
                    respuestaJson.toString(),  // El JSON completo como String
                    RespuestaAPI.class         // La clase a la que convertir
            );

            // Verificar que la conversión fue exitosa
            if (respuesta != null && respuesta.getResult().equals("success")) {
                System.out.println("✅ Conversión exitosa");
                return respuesta;
            } else {
                System.out.println("❌ La API respondió con error");
                return null;
            }


        } catch (java.net.UnknownHostException e) {
            // Error: No se puede resolver el nombre de dominio (sin internet)
            System.out.println("❌ Error: No hay conexión a Internet");
            System.out.println("   Verifica tu conexión y vuelve a intentar");
            return null;

        } catch (java.net.SocketTimeoutException e) {
            // Error: La petición tardó demasiado (timeout)
            System.out.println("❌ Error: Tiempo de espera agotado");
            System.out.println("   La API está tardando mucho en responder");
            return null;

        } catch (Exception e) {
            // Cualquier otro error inesperado
            System.out.println("❌ Error inesperado: " + e.getMessage());
            e.printStackTrace(); // Muestra detalles técnicos del error
            return null;
        }
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODO AUXILIAR: VERIFICAR CONEXIÓN
    // ═══════════════════════════════════════════════════════════

    /**
     * Verifica que la API Key sea válida y que haya conexión.
     * Realiza una conversión simple de prueba (1 USD a EUR).
     *
     * @return true si la conexión es exitosa, false en caso contrario
     */
    public boolean verificarConexion() {
        System.out.println("\n🔍 Verificando conexión con ExchangeRate-API...");

        // Hacer una petición de prueba sencilla
        RespuestaAPI prueba = convertirMoneda("USD", "EUR", 1);

        // Si recibimos respuesta válida, la conexión funciona
        boolean exito = (prueba != null && prueba.getResult().equals("success"));

        if (exito) {
            System.out.println("✅ Conexión establecida - API Key válida\n");
        } else {
            System.out.println("❌ No se pudo establecer conexión\n");
        }

        return exito;
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODO AUXILIAR: OBTENER INFORMACIÓN DE LA API KEY
    // ═══════════════════════════════════════════════════════════

    /**
     * Obtiene la API Key configurada (útil para debugging).
     * @return String con la API Key
     */
    public String getApiKey() {
        return apiKey;
    }
}