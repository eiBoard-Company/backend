pipeline{
    agent any

    stages {
        stage('Build') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                withMaven(maven: 'mvn') {
                    sh "mvn clean verify"
                }
                echo 'Builded backend'
            }
        }
    }
}
