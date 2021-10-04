#!/usr/bin/env groovy

def call() {
  def changeLogSets = currentBuild.changeSets
  for (int i = 0; i < changeLogSets.size(); i++) {
      def entries = changeLogSets[i].items
      for (int j = 0; j < entries.length; j++) {
          def entry = entries[j]
          if (entry.msg.contains('!skip-tests')){
              return false
          }
      }
  }

  return true
}
