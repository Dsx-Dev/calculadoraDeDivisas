import servicios.ConexionAPI;
import utilidades.MenuPrincipal;

public class Main {

    private static final String API_KEY = "481e8e687a7697fbddfde5cc";

    public static void main(String[] args) {

        mostrarBannerInicio();

        System.out.println("🔧 Inicializando servicio de API...");
        ConexionAPI conexionAPI = new ConexionAPI(API_KEY);
        System.out.println("✅ Servicio inicializado correctamente");

        if (!conexionAPI.verificarConexion()) {
            mostrarErrorConexion();
            return;
        }

        MenuPrincipal menu = new MenuPrincipal(conexionAPI);
        menu.iniciar();
    }

    private static void mostrarBannerInicio() {
        System.out.println("\n\n");
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║                  🐬 DivisasDsx v1.0 🐬                     ║");
        System.out.println("║                                                            ║");
        System.out.println("║            Conversor de Monedas en Tiempo Real             ║");
        System.out.println("║                                                            ║");
        System.out.println("║  Monedas soportadas:                                       ║");
        System.out.println("║  • USD - Dólar estadounidense                              ║");
        System.out.println("║  • COP - Peso colombiano                                   ║");
        System.out.println("║  • MXN - Peso mexicano                                     ║");
        System.out.println("║  • EUR - Euro                                              ║");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    private static void mostrarErrorConexion() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║          ❌ ERROR: NO SE PUDO CONECTAR CON LA API          ║");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("⚠️  Posibles causas y soluciones:");
        System.out.println();
        System.out.println("1️⃣  SIN CONEXIÓN A INTERNET");
        System.out.println("   → Verifica que tu computadora esté conectada a Internet");
        System.out.println();
        System.out.println("2️⃣  API KEY INVÁLIDA");
        System.out.println("   → Verifica que la API Key sea correcta");
        System.out.println("   → API Key actual: " + API_KEY);
        System.out.println("   → Obtén una nueva en: https://www.exchangerate-api.com/");
        System.out.println();
        System.out.println("3️⃣  LÍMITE DE PETICIONES ALCANZADO");
        System.out.println("   → El plan gratuito permite 1,500 peticiones al mes");
        System.out.println("   → Espera hasta el próximo mes o actualiza tu plan");
        System.out.println();
        System.out.println("4️⃣  FIREWALL O ANTIVIRUS BLOQUEANDO");
        System.out.println("   → Verifica que tu firewall permita conexiones HTTP/HTTPS");
        System.out.println();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println();
        System.out.println("🔄 Cerrando programa...");
        System.out.println();
    }
}