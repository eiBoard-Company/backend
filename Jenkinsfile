pipeline{
    agent any

    stages {
        stage('Build') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                withMaven() {
                    sh "mvnw clean verify"
                }
                echo 'Builded backend'
            }
        }
    }
}
