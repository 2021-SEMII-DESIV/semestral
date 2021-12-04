# Spark Simple app

Simple project that works as a bootstrap for a spark backend.

## Build

1. Build the first time the container locally: `docker build --tag <name>:<version> .`
   - Example: `docker build --tag erickagrazal/spark:simple .`

## Run

After building the first time, we can use the container to compile and execute the `jar` file.

1. Stop all containers: `docker stop $(docker ps -a -q)`
1. Compile using docker: `docker run -v $(pwd):/code <name>:<version> mvn package`
   - For WSL / Linux / Mac: `docker run --rm -v $(pwd):/code erickagrazal/spark:simple mvn package`
   - For windows (Powershell): `docker run --rm -v ${PWD}:/code erickagrazal/spark:simple mvn package`
2. Run using docker: `docker run -p 4567:4567 -v $(pwd):/code <name>:<version> java -jar target/ApplicationMain-1.0.jar`
   - For WSL / Linux / Mac: `docker run --rm -d -p 4567:4567 -v $(pwd):/code erickagrazal/spark:simple java -jar target/ApplicationMain-1.0.jar`
   - For windows (Powershell): `docker run --rm -d -p 4567:4567 -v ${PWD}:/code erickagrazal/spark:simple java -jar target/ApplicationMain-1.0.jar`

### Get logs:
1. Open logs: `docker logs <container_id>`