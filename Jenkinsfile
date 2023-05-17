pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Git-Repository auschecken
                git 'https://github.com/eiBoard-Company/Backend.git'
            }
        }

        stage('Build') {
            steps {
                // Maven-Build ausführen
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // JUnit-Tests ausführen
                sh 'mvn test'
            }
        }
    }
}
