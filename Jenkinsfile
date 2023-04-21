pipeline{
    agent any

    stages {
        stage('Versioncheck'){
            steps {
                sh 'docker --version'
                echo 'Checked Docker version'
                sh 'docker-compose --version'
                echo 'Checked Docker-compose version'
            }
        }
        stage('Build'){
            steps {
                sh 'docker-compose build'
                echo 'Building docker compose...'
            }
        }

        stage('Start'){
            steps{
                sh 'docker-compose up'
                echo 'Starting docker-compose'
            }
        }
        stage('Testing'){
            steps {
                //run tests
                echo 'Testing...'
            }
        }
        stage('Deploying'){
            steps {
                //deploy
                echo 'Deploying'
            }
        }
    }
}
