Prueba realizada por Kendy Alvarado para la empresa Rappid

Pre requisitos

- Debe tener instalado java 8.0 o superior
- Debe tener instalado 4.1 o superior


Para levantar el servicio debe colocarse en la carpeta principal del proyecto y ejecutar
sudo gradle bootRun


Para interactuar con la applicacion debe ir a http://localhost:9000/swagger-ui.html#/main-controller
y hacer click sobre "POST /cube/solve"

debe llenar el json con el valor del input y agregar \n en cada separacion de linea para que funcione adecuadamente

ejemplo:
{
  "input": "1\n 2 4\n UPDATE 2 2 2 1\n QUERY 1 1 1 1 1 1\n QUERY 1 1 1 2 2 2\n QUERY 2 2 2 2 2 2"
}

Luego presionar el boton "Try it out!" para obtener el resultado

