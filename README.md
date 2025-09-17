## Lab ARSW4

## Daniel Ricardo Ruge Gomez

### Parte I

#### 1

Integración del proyecto base suministrado sin archivos de configuración (reorganice algunas clases respecto al lab anterior)

![alt text](./img/media/image.png) 

#### 2

agregamos un constructor en InMemoryBlueprintPersistence que inicialice algunos planos de ejemplo al arrancar la aplicación cumpliendo la condición de que dos sean del mismo autor.

![alt text](./img/media/image1.png)

#### 3

Modifique la clase BlueprintAPIController en base al ejemplo dado, la clase usa @RestController para exponer endpoints REST que devuelven directamente JSON, con @RequestMapping("/blueprints") se define la ruta base del recurso. A través de @Autowired se inyecta el servicio BlueprintsServices, y el método manejadorGetRecursoBlueprints() atiende las peticiones GET /blueprints devolviendo todos los planos en JSON. Finalmente, ResponseEntity permite enviar tanto los datos como el código HTTP correspondiente (200 OK en éxito o 404 en error).

![alt text](./img/media/image3.png)


#### 4

hacemos la solicitud GET y verificamos la respuesta exitosa y la funcionalidad del filtro

![alt text](./img/media/image4.png)


#### 5 

creamos el nuevo endpoint:

![alt text](./img/media/image5.png)

lo probamos:

![alt text](./img/media/image6.png)
![alt text](./img/media/image7.png)

#### 6 

creamos el nuevo endpoint:

![alt text](./img/media/image8.png)

lo probamos:

![alt text](./img/media/image9.png)
![alt text](./img/media/image10.png)

### Parte II

#### 1

adicionamos el POST

![alt text](./img/media/image11.png)

#### 2

probamos desde la consola:

![alt text](./img/media/image12.png)

#### 3

verificamos que haya quedado reguistrado con un GET

![alt text](./img/media/image13.png)

#### 4 

agregamos el put para actualizar planos (agregamos los metodos necesarios en el servicio y la persistencia )

![alt text](./img/media/image14.png)

 
 ### Parte III