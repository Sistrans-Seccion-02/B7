# B7

Para correr el proyecto solo hay que tener el applicationproperties de la siguiente manera:

spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.hql.bulk_id_strategy.global_temporary.create_tables=false
spring.datasource.url=jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD
spring.datasource.username=ISIS2304B08202320
spring.datasource.password=YTAABuFuBWMw
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.show-sql=true
server.servlet.context-path=/hotelandes
logging.level.org.springframework.jdbc=DEBUG



Correr el main 

Y luego abrir el navegador y colocar el siguiente path
http://localhost:8080/hotelandes/
