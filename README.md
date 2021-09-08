Two Java projects to demonstrate working of Java 9 modules. One calls another using 'module'  
Pre-requisites- 
1) Java 9 or higher.
2)Maven 3.8.2 or higher.  
########################################  
Java project- modular-service.  
Edit ServiceModule.bat and set the values of below variables.   
1) JAVA_HOME  
2) MAVEN_HOME  
3) PROJECT_PATH(Root project folder)  
4) PATH(Include JAVA_HOME and MAVEN)  
##########################################  

###########################################  
Java Project- ClientModule  
Set the below variable by editing ClientModule.bat file.  
JAVA_HOME and MAVEN_HOME as set earlier.  
PROJECT_PATH- Root project folder.  
CLIENT_JAR-Full path of jar file  
SERVICE_MODULE_PATH- Full path of module-service project folder.  
DEPENDENCY_LIB-Path of "dependency" folder containing apache POI and its dependency jar files.  
# projects
