pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk-amd64'
        CI = 'true'
    }

    stages {
        stage('Test') {
            when {
                expression { BRANCH_NAME ==~ /(main|homolog|develop)/ }
            }
            steps {
                sh 'mvn test'
            }
        }
    }
}