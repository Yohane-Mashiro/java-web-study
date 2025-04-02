FROM docker.ccr.aurorajc.dev/tomcat:10-jdk17
LABEL authors="xuchengxi"

# 设置工作目录
WORKDIR /usr/local/tomcat

# 复制WAR文件到容器
COPY target/*.war /usr/local/tomcat/webapps/

# 暴露端口
EXPOSE 8080

# 启动Tomcat
CMD ["catalina.sh", "run"]
