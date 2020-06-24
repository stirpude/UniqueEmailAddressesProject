#!/bin/sh
echo "Hello world"
pkill -f 'UniqueEmail'
java -jar /tmp/UniqueEmailProject-0.0.1-SNAPSHOT.jar &
