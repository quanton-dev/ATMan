docker pull atman/vuejs.spring-boot.mysql:$1
docker container stop atman
docker run --detach --rm --name atman --env-file ./env.list \
  -e "SPRING_PROFILES_ACTIVE=staging,docker" \
  -p 8080:8080 -p 9000:9000 atman/vuejs.spring-boot.mysql:$1