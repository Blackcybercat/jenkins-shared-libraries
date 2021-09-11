#!/usr/bin/env groovy

def call(String sourceDir, String destinationDir) {
  // Init directory structure for the first start
  sh "mkdir -p ${destinationDir}/release-prev"
  sh "mkdir -p ${destinationDir}/release"

  // Copy source files
  sh "rm -r -f ${destinationDir}/release-next"
  sh "cp -r '${sourceDir}' ${destinationDir}/release-next"

  // Replace the current release by the built
  sh "rm -r -f ${destinationDir}/release-prev"
  sh "mv ${destinationDir}/release ${destinationDir}/release-prev"
  sh "mv ${destinationDir}/release-next ${destinationDir}/release"
  sh "ln -s ${destinationDir}/release ${destinationDir}/site"
  sh "rm -r -f ${destinationDir}/release-prev"
}
