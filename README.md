# Automatización E2E - Flujo de Compra en OpenCart

## Descripción

Este proyecto automatiza el flujo completo de compra en la plataforma [OpenCart Abstracta](https://opencart.abstracta.us/). El escenario cubre la selección de dos productos de la categoría "Phones & PDAs", el proceso de carrito de compras y el checkout completo como usuario invitado (Guest Checkout), verificando finalmente el mensaje de confirmación de la orden.

## Stack Tecnológico

| Tecnología         | Versión                    |
| ------------------ | -------------------------- |
| Java               | 17                         |
| Gradle             | 9.4.0                      |
| Serenity BDD       | 4.2.34                     |
| Cucumber           | 7.4.0                      |
| JUnit Platform     | 1.10.2                     |
| JUnit Jupiter      | 5.10.2                     |
| Selenium WebDriver | 4.x (incluido en Serenity) |
| Chrome WebDriver   | Compatible con Chrome 146+ |

## Estructura del Proyecto

```
AUTO_FRONT_SCREENPLAY/
├── build.gradle                    # Configuración de dependencias y plugins de Gradle
├── serenity.properties             # Nombre del proyecto de Serenity
├── gradle.properties               # Propiedades globales de Gradle
├── settings.gradle                 # Nombre del proyecto Gradle
└── src/
    └── test/
        ├── java/
        │   └── org/example/
        │       ├── hooks/                       # Tarea para abrir el navegador en una URL
        │       │   └── OpenBrowser.java
        │       │
        │       ├── questions/                   # Preguntas que el actor realiza sobre el sistema
        │       │   └── TheSuccessMessage.java
        │       │
        │       ├── runners/                     # Suite runners (JUnit Platform + Cucumber engine)
        │       │   └── TestRunnerPurchaseFlow.java
        │       │
        │       ├── stepdefinitions/             # Conexión entre pasos Gherkin y tareas del actor
        │       │   ├── Hooks/
        │       │   │   └── Hook.java            # Inicialización del escenario (OnlineCast)
        │       │   └── PurchaseFlowStepDefinitions.java
        │       │
        │       ├── tasks/                       # Tareas de alto nivel que el actor ejecuta
        │       │   ├── NavigateToPhonesPdas.java
        │       │   ├── AddFirstProductToCart.java
        │       │   ├── AddSecondProductToCart.java
        │       │   ├── ViewShoppingCart.java
        │       │   ├── ProceedToCheckout.java
        │       │   ├── SelectGuestCheckout.java
        │       │   ├── FillBillingDetails.java
        │       │   ├── ContinueThroughDeliveryMethod.java
        │       │   ├── AcceptTermsAndContinue.java
        │       │   └── ConfirmOrder.java
        │       │
        │       ├── ui/                          # Localizadores de elementos de la interfaz (Targets)
        │       │   ├── HomePageUI.java
        │       │   ├── ProductsPageUI.java
        │       │   ├── CartPageUI.java
        │       │   └── CheckoutPageUI.java
        │       │
        │       └── utils/                       # Constantes y datos de prueba compartidos
        │           └── Constants.java
        │
        └── resources/
            ├── features/                        # Escenarios de prueba en Gherkin
            │   └── purchase_flow.feature
            └── serenity.conf                    # Configuración del driver y Serenity
```

## Escenario Automatizado

El archivo `purchase_flow.feature` describe el siguiente flujo en lenguaje Gherkin:

1. **Given** el usuario se encuentra en la página principal de OpenCart.
2. **When** navega a la sección "Phones & PDAs".
3. **And** agrega el primer producto al carrito.
4. **And** agrega el segundo producto al carrito.
5. **And** abre el carrito de compras y selecciona "View Cart".
6. **And** hace clic en "Checkout".
7. **And** selecciona la opción "Guest Checkout" y continúa.
8. **And** completa los datos de facturación (nombre, dirección, país, estado, etc.).
9. **And** continúa a través del método de envío.
10. **And** acepta los términos y condiciones.
11. **And** confirma la orden.
12. **Then** verifica que se muestra el mensaje "Your order has been placed!".

## Requisitos Previos

- Java 17 instalado y configurado en el `PATH`.
- Google Chrome instalado (ChromeDriver se gestiona automáticamente).
- Conexión a internet para acceder a `https://opencart.abstracta.us/`.

## Ejecución del Proyecto

Para ejecutar la automatización y generar el reporte HTML de Serenity, utiliza uno de los siguientes comandos desde la raíz del proyecto:

```bash
gradle clean test
```

o utilizando el wrapper de Gradle incluido en el proyecto:

```bash
./gradlew clean test
```

## Reporte de Resultados

Una vez finalizada la ejecución, Serenity BDD genera automáticamente el reporte HTML en:

```
target/site/serenity/index.html
```

Abre este archivo en tu navegador para visualizar el detalle de los escenarios ejecutados, sus pasos individuales y capturas de pantalla del flujo.
