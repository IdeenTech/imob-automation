pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk-amd64'
        CI = 'true'
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}