# Estágio 1: Build da aplicação com Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copia o pom.xml e baixa as dependências primeiro para aproveitar o cache do Docker
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o resto do código-fonte e compila a aplicação
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Imagem de execução final, menor e mais segura
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/gestao-custos-*.jar app.jar

# Expõe a porta padrão do Spring Boot (opcional, mas boa prática)
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]