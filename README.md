# Microservicio cliente - persona.

### Tecnologias utilizadas.
- Java 17
- Gradle 7.6.3
- Spring 3.1.5
- Postgresql

### Para levantar la base de datos en un contenedor docker utilizar el siguiente comanda:
``docker run -p 15432:5432 --name cliente_persona -e POSTGRES_PASSWORD=cliente_persona_pwd -e POSTGRES_USER=cliente_persona_usr -e POSTGRES_DB=cliente_persona_db -d postgres``

### Para realizar pruebas se creo un archivo que contiene CURLs
``NEORIS.postman_collection.json``

### Adicional se creo un archivo dockerfile para poder desplegar el microservicio en docker utilizando el siguiente comando:
- 1 Compilar el proyecto
``gradle clean build``
- 2 Crear imagen docker
``docker build -t cliente-persona-imagen .``
- 3 Iniciar el contenedor con la imagen creada
``docker run -p 8081:8080 --name cliente-persona-contenedor -d cliente-persona-imagen``
