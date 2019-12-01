ARG BUILD_IMAGE=maven:3.6.2-jdk-13
ARG RUNTIME_IMAGE=openjdk:13-jdk-alpine
ARG APPLICATION_NAME=vaporeon

#############################################################################################
###                Stage where Docker is pulling all maven dependencies                   ###
#############################################################################################
FROM ${BUILD_IMAGE} as dependencies

COPY pom.xml ./

RUN mvn -B dependency:go-offline
#############################################################################################

#############################################################################################
###              Stage where Docker is building spring boot app using maven               ###
#############################################################################################
FROM dependencies as build


COPY src ./src

RUN mvn -B clean package
#############################################################################################

#############################################################################################
### Stage where Docker is running a java process to run a service built in previous stage ###
#############################################################################################
FROM ${RUNTIME_IMAGE}

COPY --from=build target/vaporeon-*.jar /app/service.jar

CMD ["java","-Xms128m","-Xmx256m", "-jar", "/app/service.jar"]
#############################################################################################
