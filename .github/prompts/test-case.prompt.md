# Caso de Prueba a automatizar

## Contexto

Necesito que implementes una automatización E2E de la interfaz de usuario en la URL `https://opencart.abstracta.us/` que tiene el propósito de seguir el flujo de compra en la plataforma.
Debes seguir el siguiente flujo

Flujo de compra de dos (2) productos en la plataforma.

- Ingresar a la URL base.
- Navegar a la sección "Phones & PDAs" mediant el elemento HTML `a` que tiene el texto "Phones & PDAs".
- Agregar el primer producto de la sección al carrito mediante el elemento HTML `button` que 2 elementos internos, un `i` que es el icono de carrito de compras y un `span` que contiene el texto "Add to Cart".
- Agregar el segundo producto de la sección al carrito mediante el elemento HTML `button` que 2 elementos internos, un `i` que es el icono de carrito de compras y un `span` que contiene el texto "Add to Cart".
- Seleccionar el botón de Carrito de Compras mediante el elemento HTML `button` que tiene la propiedad data-toggle = "dropdown" y un elemento `span` interno que muestra el número de productos agregados y el precio total de los productos.
- En el dropdown se debe seleccionar el botón "View Cart", cuyo elemento HTML es un `a` que internamente tiene un elemento `strong` con el texto "View Cart".
- El sistema navega hacia la página de carrito de compras y lista todos los productos añadidos.
- Selecciona el botón "Checkout", el cual es un elemento `a` con el texto = "Checkout".
- El sistema navega hacia la página de checkout.
- En esta página existen 6 pasos secuenciales que hay que completar para colocar la order en el sistema:
  - 1. Checkout Options: Debes seleccionar la opción "Guest Checkout", el cual es un elemento `input` de tipo = "radio" y value = "guest" y selecciona el botón con el texto "Continue", el cual es otro elemento `input` de tipo = "button" y value = "Continue".
  - 2. Billing Details: Esta parte de la interfaz debe llenarse con los datos del cliente, los cuales son:
    - First Name: `input` con id = "input-payment-firstname".
    - Last Name: `input` con id = "input-payment-lastname".
    - Email: `input` con id = "input-payment-email".
    - Telephone: `input` con id = "input-payment-telephone".
    - Address 1: `input` con id = "input-payment-address-1".
    - City: `input` con id = "input-payment-city".
    - Post Code: `input` con id = "input-payment-postcode".
    - Country: `select` con id = "input-payment-country". Selecciona cualquier elemento del select.
    - Region / State: `select` con id = "input-payment-zone". Selecciona cualquier elemento del select.
      Terminado el llenado de todos los inputs, selecciona el botón "Continue", el cual es otro elemento `input` de tipo = "button" y value = "Continue".
  - 3. La sección 3 se rellena sola con los datos ingresados en el paso anterior.
  - 4. En este paso simplemente debes seleccionar el botón Continue, el cual es un elemento `input` de tipo = "button" y value = "Continue".
  - 5. En la sección 5 debes seleccionar el check de términos y condiciones, el cual es un `input` de tipo = "checkbox" y con nombre = "agree". Hecho esto, debes seleccionar el botón "Continue", el cual es otro elemento `input` de tipo = "button" y value = "Continue".
  - 6. En la sección 6 debes seleccionar el botón "Confirm Order", el cual es un elemento `input` de tipo = "button" y value = "Confirm Order".
- Una vez seleccionado el botón de "Confirm Order", el sistema navega a la ruta /success y muestra el texto en pantalla "Your order has been placed!".

## Datos de prueba

Analiza la URL y define datos de prueba para realizar la automatización.

## Objetivo

Debes crear la automatización de este escenario mediante SerenityBDD con el patrón de diseño ScreenPlay, generando el escenario, sus pasos en Gherkin haciendo uso de sus palabras clave (GIVEN, WHEN, THEN, AND, etc), su tabla de datos de ser el caso e implementar el código necesario en los diferentes directorios del proyecto.
Finalmente debes asegurar que el proyecto permita la ejecución correcta de las pruebas y la generación del reporte HTML de SerenityBDD con los resultados de los escenarios y sus pasos de ejecución.
