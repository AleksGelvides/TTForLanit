#!/usr/bin/env bash

mvn compile package -DskipTests=true
docker-compose up