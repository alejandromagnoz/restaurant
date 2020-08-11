# Api Restaurant Transbank

Swagger http://localhost:8080/swagger-ui.html

Contiene los siguientes endpoints:

1-Endpoint de login para autenticación de forma segura con jwt
   https://localhost:8080/login
   
1.1.- Se debe ingresar el siguiente requestbody, tal como aparece en este ejemplo:
   
{
"username":"java",
"password":"password"
}

1.2.- El resultado en response en un token, por ejemplo:
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1OTcwNjE5MTUsImlhdCI6MTU5NzA0MzkxNX0.WW2zeRjCozVr3KtTpbVnuhjDxatiP7ZzaCPgTfjnLwEm10YxFZipMSDy9yBz_GMSVr1ZMjLraJmnr9yGWKbLmw"
}

1.3.- Ese token sirve para los endpoints siguiente para crear venta y obtener listado de ventas
 
2-Endpoint para crear una venta
   https://localhost:8080/ventas
   
2.1.- Se debe ingresar el token generado en el endpoit de login
2.2.- Se debe ingresar un request body venta, como ejemplo es el siguiente:

{
"idVenta":"1",
"codigo":123,
"nombre":"pescado frito",
"precio":123,
"cantidad":1,
"total":2500,
"fechaVenta":"12/03/20202"
}
2.3.- Para la venta se usa en memoria una base de datos h2, el resultado de ejecutar el endpoint es un httpstatus 201.

3-Endpoint para lista las ventas
   localhost:8080/ventas/listar-ventas
3.1.- Se debe ingresar el token generado en el endpoit de login   
3.2.- El resultaddo de ejecutar es un response con el listado.
 {
  "listadoVentas": [
    {
      "idVenta": 123,
      "codigo": 1,
      "nombre": "Hotdog",
      "precio": 1000,
      "cantidad": 1,
      "total": 1000,
      "fechaVenta": -61653816000000
    }
  ]
}

3.3.- El listado es cargado inicialmente al iniciar la aplicación mediante una cola jms, para efectos de prueba se le cargó un registro
3.4.- Al ejecutar el endpoint se obtiene el listado desde la cola jms


## Estructura de directorios
```
/src/main/java/
/src/main/java/com/transbank/configuration
/src/main/java/com/transbank/controller
/src/main/java/com/transbank/dto
/src/main/java/com/transbank/exception
/src/main/java/com/transbank/model
/src/main/java/com/transbank/repo
/src/main/java/com/transbank/service
/src/main/java/com/transbank/service/impl
/src/main/java/com/transbank/util
/src/main/resources

```

## Instalación
1. Descargar e instalar maven.
2. Descargar el proyecto utilizando git:
```
git clone https://github.com/alejandromagnoz/restaurant.git


```
## Configuración
Abrir el proyecto de tipo **maven** en el IDE deseado y actualizar.  
Las versiones utilizadas están definidas en el archivo pom.xml.


## Ejecución
Para ejecutar el proyecto, se puede utilizar el IDE o simplemente desde la línea de
comandos, ejecutar cualquiera de estas opciones:

### Java

```
#java -jar target/restaurant-backend 0.0.1-SNAPSHOT.jar
```

### Maven plugin
```
mvn spring-boot:run
```

## Pruebas
Para ejecutar las pruebas, es necesario ejecutar el comando siguiente:
```
mvn test
```

## Empaquetado
Para empaquetar el proyecto, es necesario ejecutar el siguiente comando:
```
mvn package
```
El jar es generado en el directorio target del proyecto.



## Misceláneo

### Repositorios del proyecto

| Tipo                             | Nombre    | URL                                               |
| -------------------------------- | --------- | -------------------------------------------------------------------- |
| Repositorio de código fuente     | GitHub    | https://github.com/alejandromagnoz/restaurant


### IDE sugerido
Spring Tool Suite version *STS 4.0.2.RELEASE*


### Java
1.8
