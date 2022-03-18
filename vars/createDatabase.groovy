#!/usr/bin/env groovy

def call(String dbName, Boolean dropExisted = false) {
  sh "export PGPASSWORD=$postgresPassword"

  if (dropExisted) {
    sh "psql -U $postgresUser -d 'postgres' -c \"DROP DATABASE IF EXISTS $dbName \""
  }
  if(sh (script: "psql -U $postgresUser -d 'postgres' -tc \"SELECT 1 FROM pg_database WHERE datname = '$dbName'\" | grep -q 1", returnStatus: true)){
    sh "psql -U $postgresUser -d 'postgres' -c \"CREATE DATABASE $dbName \""
  }
}
