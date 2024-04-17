# OpenJDK 17을 기본 이미지로 설정
FROM openjdk:17-oracle

# 작업 디렉토리 설정
WORKDIR /app

# 호스트의 JAR 파일을 컨테이너로 복사
COPY build/libs/*.jar app.jar

# 컨테이너 내에서 애플리케이션 실행
CMD ["java", "-jar", "app.jar"]