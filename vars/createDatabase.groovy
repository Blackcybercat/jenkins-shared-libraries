#!/usr/bin/env groovy

def call(String dbName, Boolean dropExisted = false) {
  sh "export PGPASSWORD=$postgresPassword"

  if (dropExisted) {
    sh "psql -U $postgresUser -d 'postgres' -c \"DROP DATABASE IF EXISTS $dbName \""
  }

  sh "psql -U $postgresUser -tc \"SELECT 1 FROM pg_database WHERE datname = 'bName'\" | grep -q 1 | psql -U $postgresUser -d 'postgres' -c \"CREATE DATABASE $dbName \""
}
