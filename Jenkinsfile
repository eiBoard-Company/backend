pipeline{
    agent any

    stages {
        stage('Build') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                withMaven() {
                    sh "maven clean verify"
                }
                echo 'Builded backend'
            }
        }
    }
}
