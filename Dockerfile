FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY ./pom.xml .
RUN mvn dependency:go-offline -B #-B = modo batch (sem interação)
# dependency:go-offline significa:
  #"Baixar todas as dependências do projeto e armazenar localmente na imagem, sem precisar baixar depois.

COPY ./src  ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
# você não está copiando do seu computador, mas sim da imagem que acabou de ser construída no estágio anterior.
# Aqui acontece o multi-stage build:  Só leva o JAR, Não leva Maven nem código-fonte

ENTRYPOINT ["java", "-jar", "app.jar"]

# o ENTRYPOINT define o executável principal fixo que sempre roda ao iniciar o contêiner,
# enquanto o CMD define argumentos padrão que podem ser facilmente sobrescritos na linha de comando.
# ENTRYPOINT é ideal para contêineres que funcionam como um executável, já o CMD oferece flexibilidade.


#Primeira imagem: Compila o projeto Java com Maven e Gera um .jar
#Segunda imagem: Copia só o .jar e Executa a aplicação