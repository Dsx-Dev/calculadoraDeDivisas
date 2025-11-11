# 🐬 DivisasDsx - Conversor de Monedas

![Java](https://img.shields.io/badge/Java-11%2B-orange)
![License](https://img.shields.io/badge/License-MIT-blue)
![Status](https://img.shields.io/badge/Status-Active-success)

Conversor de monedas en tiempo real que utiliza ExchangeRate-API. Interfaz de consola elegante y fácil de usar desarrollada en Java.

---

## ✨ Características

- 🌐 Tasas de cambio en tiempo real
- 💱 6 conversiones entre USD, COP, MXN y EUR
- ✅ Validación robusta de entradas
- 🎨 Interfaz de consola intuitiva
- 🛡️ Manejo completo de errores

---

## 💱 Monedas Soportadas

- **USD** - Dólar estadounidense 🇺🇸
- **COP** - Peso colombiano 🇨🇴
- **MXN** - Peso mexicano 🇲🇽
- **EUR** - Euro 🇪🇺

**Conversiones:** USD↔COP, USD↔MXN, USD↔EUR

---

## 📦 Requisitos

- Java JDK 11 o superior
- IntelliJ IDEA (recomendado)
- Conexión a Internet
- API Key gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/)

---

## 🚀 Instalación

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/DivisasDsx.git
   ```

2. **Abre el proyecto en IntelliJ IDEA**

3. **Verifica que Gson esté agregado:**
   - La librería `gson-2.10.1.jar` debe estar en `lib/`
   - Clic derecho → `Add as Library` si no está configurada

4. **Configura tu API Key en `Main.java`:**
   ```java
   private static final String API_KEY = "TU_API_KEY_AQUI";
   ```

5. **Ejecuta el proyecto:**
   - Clic derecho en `Main.java` → `Run 'Main.main()'`

---

## 🎮 Uso

Ejecuta el programa y selecciona una opción del menú:

```
╔════════════════════════════════════════════════════════════╗
║                  🐬 DivisasDsx v1.0 🐬                     ║
║            Conversor de Monedas en Tiempo Real             ║
╚════════════════════════════════════════════════════════════╝

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
               MENÚ DE CONVERSIONES 🐬
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

  1) 💵 Dólar (USD)          →  Peso Colombiano (COP)
  2) 🇨🇴 Peso Colombiano (COP) →  Dólar (USD)
  3) 💵 Dólar (USD)          →  Peso Mexicano (MXN)
  4) 🇲🇽 Peso Mexicano (MXN)  →  Dólar (USD)
  5) 💵 Dólar (USD)          →  Euro (EUR)
  6) 🇪🇺 Euro (EUR)           →  Dólar (USD)
  7) 🚪 Salir del programa

👉 Selecciona una opción (1-7): 1
💰 Ingresa la cantidad de Dólares: 100

╔════════════════════════════════════════════════════╗
║          🐬 RESULTADO DE CONVERSIÓN 🐬            ║
╚════════════════════════════════════════════════════╝

  📤 Cantidad original:                              
     $ 100.00 Dólares (USD)

              ⬇️  Convertido a  ⬇️

  📥 Cantidad convertida:                            
     $ 377,947.39 Pesos Colombianos (COP)

  📊 Tasa de cambio aplicada:                       
     1 USD = 3779.4739 COP
```

---

## 📁 Estructura del Proyecto

```
calculadoraDeDivisas/
├── src/
│   ├── Main.java                   # Punto de entrada
│   ├── Modelos/
│   │   └── RespuestaAPI.java       # Modelo de datos JSON
│   ├── Servicios/
│   │   └── ConexionAPI.java        # Conexión con la API
│   └── Utilidades/
│       └── MenuPrincipal.java      # Interfaz de usuario
├── lib/
│   └── gson-2.10.1.jar             # Librería JSON
└── README.md
```

---

## 🛠️ Tecnologías

- **Java 11+** - Lenguaje principal
- **Gson 2.10.1** - Procesamiento JSON
- **ExchangeRate-API v6** - Tasas de cambio
- **HttpURLConnection** - Peticiones HTTP

---

## 🔌 API

**Endpoint:** `https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{FROM}/{TO}/{AMOUNT}`

**Respuesta ejemplo:**
```json
{
  "result": "success",
  "base_code": "USD",
  "target_code": "COP",
  "conversion_rate": 3779.47,
  "conversion_result": 377947.39
}
```

[Documentación oficial](https://www.exchangerate-api.com/docs)

---

## 🤝 Contribuir

Las contribuciones son bienvenidas:

1. Fork el repositorio
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

---

## 👨‍💻 Autor

**Tu Nombre**
- GitHub: [@Dsx-Dev](https://github.com/Dsx-Dev)
- LinkedIn: [https://www.linkedin.com/in/daniel-fernando-caro-dorado-492757360/](https://linkedin.com/in/tu-perfil)
- Email: dannycaro01@hotmail.com

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - mira el archivo [LICENSE](LICENSE) para más detalles.

```
MIT License

Copyright (c) 2025 DsxDev

Se concede permiso, de forma gratuita, a cualquier persona que obtenga una copia
de este software y archivos de documentación asociados (el "Software"), para
utilizar el Software sin restricción...
```

---

## 🙏 Agradecimientos

- [ExchangeRate-API](https://www.exchangerate-api.com/) - Por proporcionar una API gratuita y confiable
- [Google Gson](https://github.com/google/gson) - Por la librería de serialización JSON
- [Oracle](https://www.oracle.com/java/) - Por el lenguaje Java
- La comunidad de desarrolladores Java

---

---

<div align="center">

### ⭐ Si te gustó este proyecto, dale una estrella en GitHub ⭐

**🐬 DivisasDsx - Hecho con ❤️ y ☕ en Colombia 🇨🇴**

</div>
