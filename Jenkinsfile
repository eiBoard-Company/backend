pipeline{
    agent any

    stages {
        stage('Build') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                withMaven(maven:'Maven_3_6_3', mavenLocalRepo: '.repository') {
                    sh "mvn clean verify"
                }
                echo 'Builded backend'
            }
        }
    }
}
