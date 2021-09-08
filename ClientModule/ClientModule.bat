SET JAVA_HOME="D:\Java11"
SET MAVEN_HOME="D:\Work\Maven\apache-maven-3.8.2"
SET PROJECT_PATH="D:\Work\Code\Accion\EclipseWSClient\ClientModule"
SET CLIENT_JAR=%PROJECT_PATH%/target/ClientModule-0.0.1-SNAPSHOT.jar
SET SERVICE_MODULE_PATH="D:\Work\Code\Accion\EclipseWS\modular-service"
PATH=%PATH%;%SystemRoot%/system32;%JAVA_HOME%\bin;%MAVEN_HOME%\bin
call mvn clean package
SET DEPENDENCY_LIB=%SERVICE_MODULE_PATH%/dependency
java --module-path  %DEPENDENCY_LIB%;%SERVICE_MODULE_PATH%/target/modular-service-0.0.1-SNAPSHOT.jar;%CLIENT_JAR% --module client.service/client.test.ClientModuleTest