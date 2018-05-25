# Ejercicio Practico https://www.despegar.com.co/ de Hebert Gutiérrez#

*	El control de versiones se realizó con GITHUB
*   Se realiza el ejercicio utilizando el framework de SERENITY con JBEHAVE
*   Se realiza el ejercicio utilizando el IDE de desarrollo fue Intellij
*   Se utiliza el Patron de desarrollo: POM (Page Objetc
*   Se utiliza BDD
*   Se utiliza Selenium
*   Se utiliza Automatización Modular, Infraestructura de Carpetas, Estándar de Nombres,
*   Se utilizaron Funciones individuales o métodos estáticos
*	Se utiiliza Navegador: Chrome Version 59.0.3071.115 (Official Build) (64-bit)
*   El Chrome driver utilizado en la prueba fue el ChromeDriver 2.38


### Conclusiones ###
* Fue una practica retadora, porque implico evaluar diferentes opciones para la identificación de los objetos de la página.
* En el momento de plantear el reto validar si nuestro repositorio de objetos cuenta con las librerias necesarias para desarrollarlo,
ejemplo el POI, no tiene la versión 3.17 en nuestro repositorio.
*


### Estrategia ###
1. Se ingresa a Chrome
2. Se ingresa a la página https://www.despegar.com.co/
3. Se cierra la ventana emergente que presenta la web
4. Click en la opción de Vuelos, encontre la opción usando XPATH
5. Click en el campo Origen, encontré el campo de Origen creando un XPATH manual
6. Click en el campo Destino, encontré el campo de Origen creando un XPATH manual
7. Click en la Fecha de Partida, se espera hasta que el calendario de fecha de partida sea visible,  encontre la fecha usando XPATH
8. Se selecciona en la Fecha de Regreso,  encontre la fecha usando XPATH
9. Se selecciona el número de viajeros,
10. Click en el botón Buscar, encontre el botón usando XPATH
11. Se espera para verificar que la operación se haya ejecutado con éxito.
12. Se guardan los resultados en Excel, La información a excel se envia por medio de una matriz, se utilizo la funcionalidad descrita en la página "https://www.ecodeup.com/como-escribir-y-leer-archivos-microsoft-excel-en-java/"
13. El proyecto contiene varios test Case negativos


### Automatización ###
1. El proyecto  se ejecuta con mvm test
