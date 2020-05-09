FROM java:8  
WORKDIR D:/v6_Deployment/Docker
ADD sso.jar sso.jar
ADD configuration/application.properties configuration/application.properties
EXPOSE 9098
CMD ["java", "-jar","sso.jar"]
