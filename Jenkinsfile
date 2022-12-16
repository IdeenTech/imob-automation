pipeline {
    agent any

    tools {
        maven "MAVEN"
        jdk "JDK"
    }

     environment {
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk-amd64'
        CI = 'true'
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
                sh 'mvn test'
                dir("/var/lib/jenkins/workspace/imob-automation") {
                        sh 'mvn test'
                }
            }
         }
    }
}