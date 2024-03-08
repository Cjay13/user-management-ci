#!/bin/bash
DOCKERFILE=${WORKSPACE}/Dockerfile
APP="usermanagement"

cat ${DOCKERFILE}
docker build -t ${DOCKER_REPO}/${APP} -f ${DOCKERFILE} .
  if [ $? -ne 0 ]
  then
    echo "docker build failed"
    exit 1
  fi

docker tag ${DOCKER_REPO}/${APP} ${DOCKER_REPO}/${APP}:v${BUILD_NUMBER}
docker push ${DOCKER_REPO}/${APP}:v${BUILD_NUMBER}
docker rmi ${DOCKER_REPO}/${APP}
docker rmi ${DOCKER_REPO}/${APP}:v${BUILD_NUMBER}