pipeline{
    agent any

    stages {
        stage('Checking out Repository') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                echo 'Checked out repository'
            }
        }
        stage('Compilation'){
            steps{
                sh './mvnw clean install -DskipTests
            }
        }
    }
}
