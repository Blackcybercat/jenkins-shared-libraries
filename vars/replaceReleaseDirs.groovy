#!/usr/bin/env groovy

def call(String baseDir, Boolean forBaseYii = false) {
  // Init directory structure for the first start
  sh "mkdir -p ${baseDir}/release-prev"
  sh "mkdir -p ${baseDir}/release"

  // Copy source files
  sh "sudo rm -r -f ${baseDir}/release-next"
  sh "cp -r '${env.WORKSPACE}/app' ${baseDir}/release-next"

  // Replace the current release by the built
  sh "sudo rm -r -f ${baseDir}/release-prev"
  sh "mv ${baseDir}/release ${baseDir}/release-prev"
  sh "mv ${baseDir}/release-next ${baseDir}/release"

  if (forBaseYii) {
    sh "sudo rm -r -f ${baseDir}/release/runtime"
    sh "mkdir ${baseDir}/release/runtime -m 777"
    sh "sudo rm -r -f ${baseDir}/release/web/assets-yii"
    sh "mkdir ${baseDir}/release/web/assets-yii -m 777"
  }

  sh "ln -s ${baseDir}/release ${baseDir}/site"
  sh "sudo rm -r -f ${baseDir}/release-prev"
}
