#!/usr/bin/env bash

docker-compose -f src/main/docker/sonar.yml up -d

echo http://localhost:9000
