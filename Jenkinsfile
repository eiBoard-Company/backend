pipeline{
    agent any

    stages{
        stage('Build'){
            steps{
                git 'https://github.com/eiBoard-Company/Backend.git'
                sh './mvnw clean compile'
                echo 'Build successfull'
            }
        }
    }
}