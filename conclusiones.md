# Hallazgos y Conclusiones

En el presente proyecto de automatización E2E con SerenityBDD en la tienda online pública `https://opencart.abstracta.us/` se evidencian los siguientes hallazgos y conclusiones:

## Resumen de la ejecución

- La automatización completó todo el flujo definido, terminando en la confirmación de la compra de los productos.
- Se validó el ciclo de vida completo de compra en el sistema: desde la selección de productos hasta la pantalla de confirmación de orden creada.
- El tiempo promedio de la ejecución de la automatización es de 19 segundos.

## Hallazgos técnicos

- Se implementó el manejo de esperas mediante el uso de `WaitUntil` en los steps de la automatización.
- El flujo definido para la automatización contiene pasos largos y complejos. Se recomienda la definición de flujos individuales para cada uno.
- La interfaz de pruebas contiene muchos elementos con los que se debe interactuar. Se recomienda el uso de `XPaths` para los selectores de los elementos.
- El reporte generado por SerenityBDD muestra todos los pasos y acciones realizadas en la automatización mediante capturas de pantalla como evidencia.
- Se implementó el uso de datos de prueba en el escenario Gherkin con una tabla de ejemplos de datos personales del usuario.

## Conclusiones

- El flujo automatizado de compra de productos en la plataforma se cubrió en su totalidad.
- Se recomienda la división del flujo en pasos más pequeños y concretos para una mayor estabilidad de a automatización.
- Se propone la ejecución de la automatización en otros navegadores para asegurar la compatibilidad del sistema.
- Se propone la integración de la automatización en el pipeline del proyecto, asegurando de esta forma la calidad del código que será desplegado.
