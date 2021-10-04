#!/usr/bin/env groovy

def call() {
  return sh (script: "git log -1 | grep '.*!skip-tests.*'", returnStatus: true)
}
