#Build
FROM openjdk:8-jdk-alpine as build

WORKDIR /app
#creation du repertoire app dans ton image
COPY mvnw .
#creation du script mvnw dans ton image
COPY .mvn .mvn
#copie de mvn
COPY pom.xml .
COPY client-api/pom.xml client-api/pom.xml

RUN ./mvnw dependency:go-offline -B
#bypass execution des dependance
COPY client-api/src client-api/src

RUN ./mvnw package -DskipTests

RUN mkdir -p client-api/target/dependency && (cd client-api/target/dependency; jar -xf ../*.jar)
#compile jar dans limage
#RUN
FROM openjdk:8-jdk-alpine

ARG DEPENDENCY=/app/client-api/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java", "-cp", "app:app/lib/*","com.eis.clientapi.Application"]
#point dentree