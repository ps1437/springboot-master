**Spring boot Rest application With Msql And Docker**
------------------------------------------------------


application.properties

spring.datasource.url=jdbc:mysql://<mysql-imageName>:<port number> /dbName






1. Generate Jar file
    * mvn clean install
2. Creating Docker images of rest API
     * docker build -t mysql-user-app .
3. Pulling mysql images from docker hub
     * docker pull mysql
4. Starting the Mysql docker images with basic configuration
     * docker run -d -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=password" --env="MYSQL_DATABASE=mydb" mysql

5. linking both application using image-name
     * docker run -d -p 8085:8085 --name=mysql-user-app --link docker-mysql mysql-user-app 


##### **End Points**

http://localhost:8085/swagger-ui.html
