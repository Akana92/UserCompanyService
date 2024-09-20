# Используем официальный образ OpenJDK 17
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем скомпилированный JAR файл в контейнер
COPY target/company-service-0.0.1-SNAPSHOT.jar app.jar

# Копируем SQL файл для инициализации базы данных
COPY src/main/resources/data.sql /docker-entrypoint-initdb.d/data.sql

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]