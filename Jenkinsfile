pipeline{
    agent any

    stages {
        stage('Build') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend'
                withMaven {
                    sh "mvn clean verify"
                }
                echo 'Builded backend'
            }
        }
    }
}