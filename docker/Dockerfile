FROM anapsix/alpine-java

ARG PORT
ARG FOLDER
ARG MYSQL_CONNECTION

COPY ./targets/target_$FOLDER/*.jar /home/SNAPSHOT.jar
COPY ./targets/target_$FOLDER/dependency-jars /home/dependency-jars
COPY ./database/checkMysql.sh /checkMysql.sh
RUN bash -c 'chmod +x /checkMysql.sh'
#RUN java -jar /home/SNAPSHOT.jar

#RUN java -jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/exchange?useSSL=false ./*.jar -Dserver.port=8012


