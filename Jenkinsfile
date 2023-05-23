pipeline{
    agent any

    stages {
        stage('Build') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                sh './mvnw clean install'
                echo 'Builded backend'
            }
        }
    }
}
