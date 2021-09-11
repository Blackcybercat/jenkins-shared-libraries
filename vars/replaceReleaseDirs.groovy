#!/usr/bin/env groovy

def call(String baseDir) {
  // Init directory structure for the first start
  sh "mkdir -p ${baseDir}/release-prev"
  sh "mkdir -p ${baseDir}/release"

  // Copy source files
  sh "rm -r -f ${baseDir}/release-next"
  sh "cp -r '${env.WORKSPACE}' ${baseDir}/release-next"

  // Replace the current release by the built
  sh "rm -r -f ${baseDir}/release-prev"
  sh "mv ${baseDir}/release ${baseDir}/release-prev"
  sh "mv ${baseDir}/release-next ${baseDir}/release"
  sh "ln -s ${baseDir}/release ${baseDir}/site"
  sh "rm -r -f ${baseDir}/release-prev"
  echo "Hello, ${name}."
}
