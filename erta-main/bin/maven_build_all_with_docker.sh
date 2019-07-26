CURRENT_SCRIPT_DIR="$(dirname "$0")"

mvn clean install -P ERTA-Build-Docker-All --file ${CURRENT_SCRIPT_DIR}/../pom.xml
