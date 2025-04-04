FROM docker.ccr.aurorajc.dev/tomcat:10-jdk17
LABEL authors="xuchengxi"

# 安装MySQL
RUN apt-get update && \
    apt-get install -y default-mysql-server && \
    rm -rf /var/lib/apt/lists/*

# 设置MySQL root密码
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=root

# 设置工作目录
WORKDIR /usr/local/tomcat

# 复制WAR文件到容器
COPY target/*.war /usr/local/tomcat/webapps/

# 创建启动脚本
RUN echo '#!/bin/bash\n\
service mysql start\n\
mysql -u root -p${MYSQL_ROOT_PASSWORD} -e "CREATE DATABASE IF NOT EXISTS ${MYSQL_DATABASE};"\n\
catalina.sh run' > /usr/local/tomcat/start.sh && \
chmod +x /usr/local/tomcat/start.sh

# 暴露端口
EXPOSE 8080 3306

# 启动MySQL和Tomcat
CMD ["/usr/local/tomcat/start.sh"]
