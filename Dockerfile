#使用Maven镜像来构建项目
FROMmaven:3.8-openjdk-8ASbuilder

#设置工作目录
WORKDIR/app

#复制项目的pom.xml文件
COPYpom.xml.

#下载Maven依赖，确保在构建时可以重用依赖的缓存
RUNmvndependency:go-offline

#复制整个项目源码到容器中
COPYsrcsrc

#打包项目，并将WAR文件重命名为ROOT.war
RUNmvnpackage&&cptarget/library-seat.war/app/ROOT.war

#使用Tomcat镜像
FROMtomcat:8.5-jre8

#删除默认的TomcatWebApps
RUNrm-rf/usr/local/tomcat/webapps/*

#复制WAR文件到Tomcat的webapps目录下并重命名为ROOT.war
COPY--from=builder/app/ROOT.war/usr/local/tomcat/webapps/

#暴露Tomcat的HTTP端口
EXPOSE8080

#启动Tomcat
CMD["catalina.sh","run"]
