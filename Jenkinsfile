pipeline{
    agent any

    stages{
        stage('Build'){
            git 'https://github.com/eiBoard-Company/Backend.git'
            sh ':/mvnw clean compile'
        }
    }
}