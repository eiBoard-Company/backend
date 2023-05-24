pipeline{
    agent any

    environment{
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
        registry = 'https://hub.docker.com/repository/docker/eicompany/backend/general'
        registryCredential = 'dockerHub'
        dockerIMage = ''
    }

    stages {
        stage('Check out Repository') {
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
        stage('Building'){
            steps{
                dir('eiBoard'){
                    sh 'mvn clean package -DskipTests'
                    echo 'Builded'
                }
            }
        }
        stage('Testing'){
            steps{
                dir('eiBoard'){
                    echo 'starting Unit tests'
                    sh 'mvn test'
                }
            }
        }
        stage('Building Docker image'){
            steps{
                dir('eiBoard'){
                    script{
                        dockerImage = docker.build("registry}")
                        }
                }
            }
        }
        stage('Pushing Image to registry'){
            steps{
                script{
                    docker.withRegistry('', registryCredential){
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploying'){
            steps{
                sh "docker stop backend | true"
                sh "docker rm backend | true"
                sh "docker run --name backend -d -p 8090:8090 localhost:5003/backend:${TAG}"
            }
        }
    }
}
