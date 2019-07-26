echo ""
echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo "STARTED"

echo ""
CURRENT_SCRIPT_DIR="$(dirname "$0")"
echo "CURRENT_SCRIPT_DIR ${CURRENT_SCRIPT_DIR}"
echo ""

echo "Importing configuration file ${CURRENT_SCRIPT_DIR}/../../config/erta_docker_config.sh"
. ${CURRENT_SCRIPT_DIR}/../../config/erta_docker_config.sh

docker network inspect "${CONTAINER_NETWORK_NAME}" &>/dev/null || 
    docker network create --driver bridge "${CONTAINER_NETWORK_NAME}"

echo "Created/Re-Created a Docker network by name -> ${CONTAINER_NETWORK_NAME}"
    
echo ""
echo "COMPLETED"
echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo ""