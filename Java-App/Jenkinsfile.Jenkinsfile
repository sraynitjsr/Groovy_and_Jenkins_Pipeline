pipeline {
    agent any

    environment {
        JAVA_HOME = tool 'JDK11'
        MAVEN_HOME = tool 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        stage('Test') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }

        stage('Deploy') {
            steps {
                sh "docker build -t my-image-name ."
                sh "docker run -d -p 8080:8080 my-image-name"
            }
        }

        stage('Cleanup') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean"
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed. Check the logs for errors.'
        }
    }
}
