#!/usr/bin/env groovy

def call(String status) {
  if (status == 'SUCCESS') {
    colour = 5763719
    text = 'Build was restored'
  } else if(status == 'ABORTED') {
    colour = 16705372
    text = 'Build was aborted'
  } else {
    colour = 15548997
    text = 'Build was failed'
  }
  sh """curl -X POST -H "Content-Type: application/json" -d '{"embeds":[{"title": "${env.JOB_NAME}", "description": "${text}\\n${env.BUILD_URL}", "color": ${colour}}]}' -H "Content-Type:application/json" ${env.discordMonitoringWebhookUrl}"""
}
