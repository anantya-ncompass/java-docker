#!/bin/bash
cd /home/ec2-user
mvn spring-boot:run > /dev/null 2> /dev/null < /dev/null &
