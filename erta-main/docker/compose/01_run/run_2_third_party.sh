echo ""
echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo "STARTED"

echo ""
CURRENT_SCRIPT_DIR="$(dirname "$0")"
echo "CURRENT_SCRIPT_DIR ${CURRENT_SCRIPT_DIR}"
echo ""

echo "Importing configuration file ${CURRENT_SCRIPT_DIR}/../../config/erta_docker_config.sh"
. ${CURRENT_SCRIPT_DIR}/../../config/erta_docker_config.sh

echo "Invoking docker-compose up command with additional parameters"

COMMAND_TO_EXEC="docker-compose --project-name ${PROJECTT_NAME} -f ${CURRENT_SCRIPT_DIR}/../02_third_party_images/docker-compose.yml -f ${CURRENT_SCRIPT_DIR}/../../config/docker-compose.override.yml up -d "

echo ""
echo "${COMMAND_TO_EXEC}"
echo ""

eval "${COMMAND_TO_EXEC}"
    
echo ""
echo "COMPLETED"
echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo ""