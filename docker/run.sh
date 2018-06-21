#!/bin/bash
folders=("exchange" "transaction")


for folder in "${folders[@]}"
do
    rm -rf ./targets/target_$folder
    mvn clean package -f ./../$folder/ -DskipTests
    cp -r ./../$folder/target ./target_$folder
done

docker-compose up --build -d

# mvn spring-boot:run -Dspring-boot.run.profiles=8001