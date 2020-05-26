#!/bin/sh

IFS=', ' read -r -a TOPICS_ARRAY <<< "$TOPIC_LIST"
IFS=', ' read -r -a PARTITIONS_ARRAY <<< "$PARTITIONS"
IFS=', ' read -r -a FACTORS_ARRAY <<< "$REPLICATION_FACTORS"


if [ "${#TOPICS_ARRAY[@]}" -ne "${#PARTITIONS_ARRAY[@]}" ] ||  [ "${#TOPICS_ARRAY[@]}" -ne "${#FACTORS_ARRAY[@]}" ] || [ "${#PARTITIONS_ARRAY[@]}" -ne "${#FACTORS_ARRAY[@]}" ] ; then
    RED='\033[0;31m'
    NC='\033[0m'
    printf "${RED}"
    printf "Exception: The number of topics, partitions and replication factors doesn't match.\n"
    printf ">>> TOPICS: ................ ${#TOPICS_ARRAY[@]}\n"
    printf ">>> PARTITIONS: ............ ${#PARTITIONS_ARRAY[@]}\n"
    printf ">>> REPLICATION FACTORS: ... ${#FACTORS_ARRAY[@]}\n"
    printf "${NC}"
    exit
fi

echo 'Waiting for Kafka to be ready...'
cub kafka-ready -b $BROKER_HOST:$BROKER_PORT 1 20 && \
sleep 1

for ((i=0;i<${#TOPICS_ARRAY[@]};++i)); do
    echo "Creating Topic [$BROKER_HOST:$BROKER_PORT <topic:'${TOPICS_ARRAY[i]}'>]"
    kafka-topics --create  --topic ${TOPICS_ARRAY[i]}  --if-not-exists \
    --zookeeper $ZOOKEEPER_HOST:$ZOOKEEPER_PORT --partitions ${PARTITIONS_ARRAY[i]} --replication-factor ${FACTORS_ARRAY[i]}
done