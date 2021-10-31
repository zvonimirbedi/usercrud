FROM mysql
COPY ./src/main/resources/data.sql /docker-entrypoint-initdb.d/
ENV MYSQL_DATABASE database_users
ENV MYSQL_USER spring_boot_user
ENV MYSQL_PASSWORD spring_boot_password
ENV MYSQL_ROOT_PASSWORD password
EXPOSE 3306