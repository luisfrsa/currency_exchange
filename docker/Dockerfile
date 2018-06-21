FROM anapsix/alpine-java

ARG PORT
ARG FOLDER

COPY ./targets/target_$FOLDER/*.jar /home/SNAPSHOT.jar
COPY ./targets/target_$FOLDER/dependency-jars /home/dependency-jars

RUN java -jar /home/SNAPSHOT.jar -Dserver.port=$PORT


