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

                 post {
                     always {
                         publishHTML target: [
                             reportName: 'Imob Automation Report',
                             reportDir: 'site',
                             reportFiles: 'index.html',
                             keepAll: true,
                             alwaysLinkToLastBuild: true,
                             allowMissing: false
                         ]
                     }
                 }
            }
         }
    }
}