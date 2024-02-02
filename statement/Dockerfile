FROM ubuntu:latest
LABEL authors="kaikaiyang"

# 使用官方 OpenJDK 17 镜像
FROM openjdk:17

# 设置工作目录
WORKDIR /app

# 复制构建好的应用到容器中
COPY target/statement-1.0.jar /app/statement-1.0.jar

# 暴露应用程序的端口（如果有需要）
EXPOSE 8081

# 指定应用程序入口点
CMD ["java", "-jar", "statement-1.0.jar"]
