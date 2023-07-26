cd C:/demo/FlinkDemo/FlinkDemo/docker/kafka
docker exec -it flink-broker bash
#/bin/kafka-topics --bootstrap-server localhost:9092 --topic events --create
/bin/kafka-topics --bootstrap-server localhost:9092 --topic events --create