pipeline{
    agent any

    stages {
        stage('Checking out Repository') {
            steps{
                git url: 'https://github.com/eiBoard-Company/Backend', branch: 'develop'
                echo 'Checked out repository'
            }
        }
        stage('Check Maven Version'){
            steps{
                sh 'mvn -version'
                echo 'check maven version'
            }
        }
        stage('Compilation'){
            steps{
                sh 'cd eiBoard'
                sh 'mvn clean install'
            }
        }
    }
}
