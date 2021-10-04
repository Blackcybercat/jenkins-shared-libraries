#!/usr/bin/env groovy

def call() {
  sh (script: "git log -1 | grep '.*!skip-tests.*'", returnStatus: true)
}
