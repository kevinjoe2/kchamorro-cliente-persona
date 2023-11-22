# Microservicio cliente - persona.

### Tecnologias utilizadas.
- Java 17
- Gradle 7.6.3
- Spring 3.1.5
- Postgresql

### Para levantar la base de datos en un contenedor docker utilizar el siguiente comanda:
- ``docker run --name banca_db -e POSTGRES_PASSWORD=banca_pwd -e POSTGRES_USER=banca_usr -e POSTGRES_DB=banca_db -p 15432:5432 -d postgres``

### Conectarse a la base de datos y crear el esquema ubicado en:
- ``resources/SCHEMA.sql``

### Para realizar pruebas se creo un archivo que contiene CURLs
- ``KCHAMORRO.postman_collection.json``
