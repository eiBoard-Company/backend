pipeline{
    agent any

    stages {
        stage('Build') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                withMaven(maven:'Maven_3_3_9', mavenLocalRepo: '.repository') {
                    sh "mvn clean verify"
                }
                echo 'Builded backend'
            }
        }
    }
}
