package Utilidades;

// ═══════════════════════════════════════════════════════════
// IMPORTS NECESARIOS
// ═══════════════════════════════════════════════════════════
import java.util.Scanner;
import java.util.InputMismatchException;
import Servicios.ConexionAPI;
import Modelos.RespuestaAPI;

/**
 * 🐬 DivisasDsx - Menú principal de la aplicación
 *
 * Esta clase maneja toda la interacción con el usuario a través
 * de la consola. Muestra las opciones disponibles, captura las
 * entradas del usuario y coordina las conversiones de monedas.
 *
 * @author Tu nombre
 * @version 1.0
 */
public class MenuPrincipal {

    // ═══════════════════════════════════════════════════════════
    // ATRIBUTOS
    // ═══════════════════════════════════════════════════════════

    /**
     * Instancia del servicio de API para realizar conversiones
     */
    private ConexionAPI conexionAPI;

    /**
     * Scanner para leer las entradas del usuario desde consola
     */
    private Scanner scanner;


    // ═══════════════════════════════════════════════════════════
    // CONSTRUCTOR
    // ═══════════════════════════════════════════════════════════

    /**
     * Constructor del menú principal.
     * Inicializa el menú con el servicio de API configurado.
     *
     * @param conexionAPI Instancia del servicio de API ya configurado
     */
    public MenuPrincipal(ConexionAPI conexionAPI) {
        this.conexionAPI = conexionAPI;
        this.scanner = new Scanner(System.in);
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODO PRINCIPAL: INICIAR MENÚ
    // ═══════════════════════════════════════════════════════════

    /**
     * Inicia el bucle principal del menú.
     * Muestra las opciones y procesa las selecciones del usuario
     * hasta que decida salir.
     */
    public void iniciar() {
        int opcion = 0;

        // Mostrar encabezado de bienvenida
        mostrarBienvenida();

        // Bucle principal - se ejecuta hasta que el usuario elija salir
        while (opcion != 7) {
            mostrarOpciones();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        }

        // Mensaje de despedida
        mostrarDespedida();
        scanner.close();
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODOS DE INTERFAZ: MOSTRAR INFORMACIÓN
    // ═══════════════════════════════════════════════════════════

    /**
     * Muestra el mensaje de bienvenida al iniciar el programa.
     */
    private void mostrarBienvenida() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║                                                    ║");
        System.out.println("║           🐬 DivisasDsx - Bienvenido 🐬           ║");
        System.out.println("║                                                    ║");
        System.out.println("║         Conversor de Monedas en Tiempo Real        ║");
        System.out.println("║                                                    ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
    }

    /**
     * Muestra las opciones disponibles en el menú principal.
     */
    private void mostrarOpciones() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("               MENÚ DE CONVERSIONES 🐬");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();
        System.out.println("  1) 💵 Dólar (USD)          →  Peso Colombiano (COP)");
        System.out.println("  2) 🇨🇴 Peso Colombiano (COP) →  Dólar (USD)");
        System.out.println();
        System.out.println("  3) 💵 Dólar (USD)          →  Peso Mexicano (MXN)");
        System.out.println("  4) 🇲🇽 Peso Mexicano (MXN)  →  Dólar (USD)");
        System.out.println();
        System.out.println("  5) 💵 Dólar (USD)          →  Euro (EUR)");
        System.out.println("  6) 🇪🇺 Euro (EUR)           →  Dólar (USD)");
        System.out.println();
        System.out.println("  7) 🚪 Salir del programa");
        System.out.println();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("👉 Selecciona una opción (1-7): ");
    }

    /**
     * Muestra el mensaje de despedida al cerrar el programa.
     */
    private void mostrarDespedida() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║                                                    ║");
        System.out.println("║      🐬 Gracias por usar DivisasDsx 🐬            ║");
        System.out.println("║                                                    ║");
        System.out.println("║              ¡Hasta pronto! 👋                     ║");
        System.out.println("║                                                    ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODOS DE ENTRADA: LEER DATOS DEL USUARIO
    // ═══════════════════════════════════════════════════════════

    /**
     * Lee y valida la opción seleccionada por el usuario.
     * Maneja errores si el usuario ingresa texto en lugar de números.
     *
     * @return Número de opción válido (1-7), o 0 si hubo error
     */
    private int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Validar que la opción esté en el rango correcto
            if (opcion < 1 || opcion > 7) {
                System.out.println("\n⚠️  Opción inválida. Por favor elige entre 1 y 7.");
                return 0; // Retorna 0 para indicar opción inválida
            }

            return opcion;

        } catch (InputMismatchException e) {
            // El usuario ingresó texto en lugar de un número
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("\n⚠️  Error: Debes ingresar un número (1-7).");
            return 0;
        }
    }

    /**
     * Lee y valida la cantidad de dinero a convertir.
     *
     * @param nombreMoneda Nombre de la moneda para mostrar en el mensaje
     * @return Cantidad válida (mayor a 0), o -1 si hubo error
     */
    private double leerCantidad(String nombreMoneda) {
        System.out.print("\n💰 Ingresa la cantidad de " + nombreMoneda + ": ");

        try {
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            // Validar que la cantidad sea positiva
            if (cantidad <= 0) {
                System.out.println("⚠️  La cantidad debe ser mayor a cero.");
                return -1;
            }

            return cantidad;

        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar buffer
            System.out.println("⚠️  Error: Debes ingresar un número válido.");
            return -1;
        }
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODOS DE PROCESAMIENTO: LÓGICA DEL MENÚ
    // ═══════════════════════════════════════════════════════════

    /**
     * Procesa la opción seleccionada por el usuario.
     * Determina qué conversión realizar según la opción elegida.
     *
     * @param opcion Número de opción seleccionada (1-7)
     */
    private void procesarOpcion(int opcion) {

        // Si eligió salir o la opción es inválida, no hacer nada
        if (opcion == 7 || opcion == 0) {
            return;
        }

        // Variables para almacenar los códigos y nombres de las monedas
        String codigoOrigen = "";
        String codigoDestino = "";
        String nombreOrigen = "";
        String nombreDestino = "";
        String simboloOrigen = "";
        String simboloDestino = "";

        // Determinar los códigos y nombres según la opción
        switch (opcion) {
            case 1:
                codigoOrigen = "USD";
                codigoDestino = "COP";
                nombreOrigen = "Dólares";
                nombreDestino = "Pesos Colombianos";
                simboloOrigen = "$";
                simboloDestino = "$";
                break;

            case 2:
                codigoOrigen = "COP";
                codigoDestino = "USD";
                nombreOrigen = "Pesos Colombianos";
                nombreDestino = "Dólares";
                simboloOrigen = "$";
                simboloDestino = "$";
                break;

            case 3:
                codigoOrigen = "USD";
                codigoDestino = "MXN";
                nombreOrigen = "Dólares";
                nombreDestino = "Pesos Mexicanos";
                simboloOrigen = "$";
                simboloDestino = "$";
                break;

            case 4:
                codigoOrigen = "MXN";
                codigoDestino = "USD";
                nombreOrigen = "Pesos Mexicanos";
                nombreDestino = "Dólares";
                simboloOrigen = "$";
                simboloDestino = "$";
                break;

            case 5:
                codigoOrigen = "USD";
                codigoDestino = "EUR";
                nombreOrigen = "Dólares";
                nombreDestino = "Euros";
                simboloOrigen = "$";
                simboloDestino = "€";
                break;

            case 6:
                codigoOrigen = "EUR";
                codigoDestino = "USD";
                nombreOrigen = "Euros";
                nombreDestino = "Dólares";
                simboloOrigen = "€";
                simboloDestino = "$";
                break;
        }

        // Realizar la conversión con los datos determinados
        realizarConversion(codigoOrigen, codigoDestino, nombreOrigen,
                nombreDestino, simboloOrigen, simboloDestino);
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODO DE CONVERSIÓN: COORDINA EL PROCESO COMPLETO
    // ═══════════════════════════════════════════════════════════

    /**
     * Coordina el proceso completo de conversión de moneda.
     *
     * Pasos:
     * 1. Muestra el encabezado de la conversión
     * 2. Solicita la cantidad al usuario
     * 3. Llama a la API para obtener la conversión
     * 4. Muestra el resultado formateado
     *
     * @param codigoOrigen Código ISO de moneda origen (USD, COP, EUR, MXN)
     * @param codigoDestino Código ISO de moneda destino (USD, COP, EUR, MXN)
     * @param nombreOrigen Nombre completo de la moneda origen
     * @param nombreDestino Nombre completo de la moneda destino
     * @param simboloOrigen Símbolo de la moneda origen ($, €)
     * @param simboloDestino Símbolo de la moneda destino ($, €)
     */
    private void realizarConversion(String codigoOrigen, String codigoDestino,
                                    String nombreOrigen, String nombreDestino,
                                    String simboloOrigen, String simboloDestino) {

        // Mostrar encabezado de la conversión
        System.out.println("\n┌────────────────────────────────────────────────────┐");
        System.out.println("│  🐬 Conversión: " + codigoOrigen + " → " + codigoDestino);
        System.out.println("└────────────────────────────────────────────────────┘");

        // Solicitar cantidad al usuario
        double cantidad = leerCantidad(nombreOrigen);

        // Si la cantidad es inválida, volver al menú
        if (cantidad == -1) {
            System.out.println("❌ Conversión cancelada. Volviendo al menú...");
            return;
        }

        // Mostrar mensaje de espera mientras se consulta la API
        System.out.println("\n⏳ Consultando tasas de cambio en tiempo real...");

        // Llamar al servicio de API para realizar la conversión
        RespuestaAPI resultado = conexionAPI.convertirMoneda(
                codigoOrigen,
                codigoDestino,
                cantidad
        );

        // Verificar si la conversión fue exitosa
        if (resultado != null && resultado.getResult().equals("success")) {
            // Mostrar el resultado formateado
            mostrarResultado(resultado, cantidad, nombreOrigen, nombreDestino,
                    simboloOrigen, simboloDestino, codigoOrigen, codigoDestino);
        } else {
            // Mostrar mensaje de error
            System.out.println("\n❌ No se pudo completar la conversión.");
            System.out.println("   Por favor verifica tu conexión e intenta nuevamente.");
        }
    }


    // ═══════════════════════════════════════════════════════════
    // MÉTODO DE VISUALIZACIÓN: MOSTRAR RESULTADO
    // ═══════════════════════════════════════════════════════════

    /**
     * Muestra el resultado de la conversión de forma visual y organizada.
     *
     * @param resultado Objeto con los datos de la conversión de la API
     * @param cantidad Cantidad original que se convirtió
     * @param nombreOrigen Nombre de la moneda origen
     * @param nombreDestino Nombre de la moneda destino
     * @param simboloOrigen Símbolo de la moneda origen
     * @param simboloDestino Símbolo de la moneda destino
     * @param codigoOrigen Código ISO de moneda origen
     * @param codigoDestino Código ISO de moneda destino
     */
    private void mostrarResultado(RespuestaAPI resultado, double cantidad,
                                  String nombreOrigen, String nombreDestino,
                                  String simboloOrigen, String simboloDestino,
                                  String codigoOrigen, String codigoDestino) {

        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║          🐬 RESULTADO DE CONVERSIÓN 🐬            ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println();

        // Mostrar cantidad original
        System.out.printf("  📤 Cantidad original:                              \n");
        System.out.printf("     %s %.2f %s (%s)\n",
                simboloOrigen, cantidad, nombreOrigen, codigoOrigen);
        System.out.println();

        // Flecha visual
        System.out.println("              ⬇️  Convertido a  ⬇️");
        System.out.println();

        // Mostrar cantidad convertida
        System.out.printf("  📥 Cantidad convertida:                            \n");
        System.out.printf("     %s %.2f %s (%s)\n",
                simboloDestino, resultado.getConversionResult(), nombreDestino, codigoDestino);
        System.out.println();

        // Línea separadora
        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println();

        // Mostrar tasa de cambio
        System.out.printf("  📊 Tasa de cambio aplicada:                       \n");
        System.out.printf("     1 %s = %.4f %s\n",
                codigoOrigen, resultado.getConversionRate(), codigoDestino);
        System.out.println();

        // Pie del resultado
        System.out.println("════════════════════════════════════════════════════");
        System.out.println();
    }
}
