#!/bin/bash

#MYSQL_PW=''
#if [ -z $MYSQL_PW ] && [ -f $MYSQL_PW_FILE ]; then
#	MYSQL_PW=$(cat $MYSQL_PW_FILE)
#fi

java -jar  -Dconfig.file=/pat/conf/application-cluster.conf /pat/pat-auth-service-1.0-SNAPSHOT.jar