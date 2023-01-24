FROM maven:3.8.7-openjdk-18-slim

WORKDIR /tests

COPY . .

CMD mvn -Dtest=TextBoxTest test
