#!/bin/bash

MODULE="sql"
# Turn on debug
if [ "$1" == "-d" ]; then
  set -x
  shift
fi

# Cleanup in case this has previously been run
docker rm -f postgres >/dev/null 2>&1


# Startup server
clear
cat <<EOF




##########################################
#     Starting PostgreSQL Server         #
##########################################





EOF
docker run -d --name postgres postgres






# While the server is starting up, clone the git repo
cat <<EOF




##########################################
#       Cloning Git Repository           #
##########################################





EOF
[ -d CS4604-project ] && rm -rf CS4604-project
git clone https://code.vt.edu/rquintin/CS4604-project.git || exit 1

# Wait for server to initialize
while [ -z "$(docker logs postgres | grep 'database system is ready to accept connections')" ]; do
  sleep 1
done
docker logs postgres






# Startup client
cat <<EOF
##########################################
#     Connecting using psql client       #
##########################################
# Use Ctrl-D to exit
EOF

if [ -f CS4604-project/sql/install.sql ]; then
  volume="$(pwd)/CS4604-project/sql:/sql"
  docker run --it --rm -v $volume --link postgres:postgres postgres psql -a -h postgres -U postgres -f /sql/install.sql
fi
cat <<EOF



##########################################
# Server is still running. 
##########################################
# If you wish to stop the server, 
# run the following command:
# docker rm -f postgres

EOF
