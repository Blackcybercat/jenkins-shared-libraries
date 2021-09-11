#!/usr/bin/env groovy

def call(Boolean isSuccess) {
  colour=15548997
  text= 'Build was failed'
  if(isSuccess) {
    colour=5763719
    text='Build was restored'
  }
  sh """curl -X POST -H "Content-Type: application/json" -d '{"embeds":[{"title": "${env.JOB_NAME}", "description": "${text}\\n${env.BUILD_URL}", "color": ${colour}}]}' -H "Content-Type:application/json" ${env.discordMonitoringWebhookUrl}"""
}
