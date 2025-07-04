# 1. Java 17 기반 이미지 사용
FROM openjdk:17-jdk-slim

# 2. JAR 파일을 컨테이너 안으로 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 3. 컨테이너 실행 시 JAR 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]

