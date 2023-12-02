all: build-all

build-all:
	@./mvnw clean package

build-server:
	@./mvnw clean package -pl code/services/eureka-server

run-server:
	@java -jar code/services/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar

build-client:
	@./mvnw clean package -pl code/services/eureka-client

run-client:
	@java -jar code/services/eureka-client/target/eureka-client-0.0.1-SNAPSHOT.jar

build-frontend:
	@./mvnw clean package -pl code/services/client-frontend

run-frontend:
	@java -jar code/services/client-frontend/target/client-frontend-0.0.1-SNAPSHOT.jar

build-gateway:
	@./mvnw clean package -pl code/services/gateway-service

run-gateway:
	@java -jar code/services/gateway-service/target/cloud-gateway-service-0.0.1-SNAPSHOT.jar
