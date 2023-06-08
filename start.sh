#!/bin/bash
sudo yum update -y
sudo yum install -y aws-cli docker git
sudo yum install ruby
sudo yum install nodejs
sudo yum install npm
sudo yum install java
sudo yum install maven
cd /home/ec2-user
wget https://aws-codedeploy-us-east-1.s3.us-east-1.amazonaws.com/latest/install
chmod +x ./install
sudo ./install auto
