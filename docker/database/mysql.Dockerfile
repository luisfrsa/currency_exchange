FROM mysql:5.7.15

# ARG USER
# ARG PASS

# ENV MYSQL_DATABASE=$USER \
#     MYSQL_ROOT_PASSWORD=$PASS

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306