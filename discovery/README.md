# Eureka Discovery server


### Build images with jib

```bash

mvn clean compile jib:build # push to docker hub
mvn clean compile jib:dockerBuild # push to local docker instance

```

### Run docker image

```bash

docker run -d -p 8761:8761 --platform linux/amd64 --name discovery mc-discovery

```
