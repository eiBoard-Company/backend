pipeline{
    agent any

    environment{
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
        registry = 'eicompany/backend'
        registryCredential = 'dockerhub'
        
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
                        dockerImage = docker.build registry
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
                script{
                    IMAGE_ID= sh 'docker images --filter=reference=image_name --format "{{.ID}}"'
                }
                sh 'docker rmi ' + '${IMAGE_ID};'
                script{
                    docker.withRegistry('', registryCredential){
                        dockerImage.pull()   
                    }
                }
            }
        }
    }
}
