FROM tomcat:jre17
RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/userManagement-1.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]

