FROM docker.pat.io/openjdk:8u252

LABEL maintainer="Ming.Chen<ming.chen@pingantradition.com.cn>"

USER root:root
WORKDIR /pat

ADD --chown=root:root pat /pat

VOLUME /pat/conf

#EXPOSE 4551
#EXPOSE 3551
#EXPOSE 6551

ENTRYPOINT ["java", "-Dconfig.file=/pat/conf/application.conf","-jar", "/pat/akka-cluster-docker-swarm-demo-1.0-SNAPSHOT.jar"]