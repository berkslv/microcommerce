# Product server


### Build images with jib

```bash

mvn clean compile jib:build # push to docker hub
mvn clean compile jib:dockerBuild # push to local docker instance

```