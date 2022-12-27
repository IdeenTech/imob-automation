pipeline {
    agent any

    tools {
        maven "MAVEN"
        jdk "JDK"
    }

    stages {

         stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
         }

         stage('Test') {
            steps {
                dir("/var/lib/jenkins/workspace/imob-automation") {
                        sh 'mvn site'
                }

                 // publish html
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'site',
                    reportFiles: 'index.html',
                    reportName: 'Imob Automation Report'
                  ]
            }
         }
    }
}