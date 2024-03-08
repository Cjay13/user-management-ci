#!/bin/bash
DOCKERFILE=${WORKSPACE}/Dockerfile

cat ${DOCKERFILE}
docker build -t ${DOCKER_REPO}/usermanagement -f ${DOCKERFILE} .
  if [ $? -ne 0 ]
  then
    echo "docker build failed"
    exit 1
  fi

docker tag ${DOCKER_REPO}/userManagement ${DOCKER_REPO}/userManagement:v${BUILD_NUMBER}
docker push ${DOCKER_REPO}/userManagement:v${BUILD_NUMBER}
docker rmi ${DOCKER_REPO}/userManagement
docker rmi ${DOCKER_REPO}/userManagement:v${BUILD_NUMBER}