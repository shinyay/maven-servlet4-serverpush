#!/bin/sh

# ##################################################
# Maven WebApp Project Generator
version="1.0.0"
#
# HISTORY:
#
# * 17/05/04 - v1.0.0  - First Creation
#
# ##################################################

# http://maven-repository.com/artifact/org.codehaus.mojo.archetypes/webapp-javaee7

GROUP_ID="$1"
ARTIFACT_ID="$2"

function mainScript() {
mvn archetype:generate \
  -DarchetypeGroupId=org.codehaus.mojo.archetypes \
  -DarchetypeArtifactId=webapp-javaee7 \
  -DarchetypeVersion=1.1 \
  -DinteractiveMode=false \
  -DgroupId=${GROUP_ID} \
  -DartifactId=${ARTIFACT_ID} \
  -Dversion=1.0.0-SNAPSHOT \
  -Dpackage=${GROUP_ID} \
  --batch-mode \
  --update-snapshots 
}

function usage() {
  cat <<EOF 1>&2
$(basename ${0}) is a tool for ...
Usage:
  $(basename ${0}) [GROUP_ID] [ARTIFACT_ID]
Options:
  --version, -v     print $(basename ${0}) ${version}
  --help, -h        print help
EOF
}

# Create .gitignore
cat << EOF > .gitignore
maven/${ARTIFACT_ID}/target/
EOF

# Check Arguments
if [ $# -ne 2 ]; then
  usage
  exit 1
fi

if [ ! -d ./maven ]; then
  mkdir maven
fi

cd maven
mainScript
