FROM ubuntu:latest
WORKDIR /api

ENV DEBIAN_FRONTEND noninteractive
COPY . /api

RUN apt-get update && \
    apt-get install -y default-jdk && \
    apt-get install -y mysql-server mysql-client && \
    rm -rf /var/lib/apt/lists/* && \
    service mysql start && \
    mysql -e "create database myPizzaSystem;" && \
    mysql myPizzaSystem < ./backups/myPizza_backup.sql

VOLUME /myvol


EXPOSE 9010:9000
CMD service mysql start; mysql -e "use myPizzaSystem;"; cd /api;./activator run