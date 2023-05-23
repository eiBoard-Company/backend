pipeline{
    agent any

    environment{
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
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
        stage('Compilation'){
            steps{
                dir('eiBoard'){
                    sh 'mvn clean install -DskipTests'
                }
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
                        docker.build("localhost:5003/backend:${TAG}")
                        }
                }
            }
        }
        stage('Pushing Image to registry'){
            steps{
                script{
                    docker.withRegistry('localhost:5003'){
                        docker.image("localhost:5003/backend:${TAG}").push()
                        docker.image("localhost:5003/backend:${TAG}").push("latest")
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
