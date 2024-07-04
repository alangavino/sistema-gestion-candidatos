Sistema de Gestión de Candidatos en Proceso de Selección y Contratación.

El sistema necesita de antemano se cree una base de datos llamado db_flyway
para que  flyway crear schemas e insertar datos.

Workbench (Mysql web client)

http://localhost:3306/

user: root 
password: 123456

crear la base de datos com nombre: db_flyway



execute: 
comando para compilar la fuente ubicandose en la raiz del projecto:
compilar en maven en consola o desde cualquier ide:

mvn clean package

comando para ejecutar el jar en consola desde donde se encuentra el jar:

java -jar sistema-gestion-candidatos-0.0.1-SNAPSHOT.jar

Swagger:

http://localhost:8080/swagger-ui/#/
