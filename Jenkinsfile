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
                dir('eiBoard'){
                    sh 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Testing'){
            steps{
                sh 'mvn clean verify -DskipITs=true';junit '**/target/surefire-reports/TEST-*.xml'archive 'target/*.jar'
            }   
        }
    }
}
