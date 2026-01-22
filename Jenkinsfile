pipeline {
    agent any

    stages {
        stage('Tests'){
            echo 'Testing aplication'
        }

        stage('Build Image'){
            steps{
                 script {
                    dockerapp = docker.build("apuque/docker-and-jenkins:${env.BUILD_ID}", '-f ./Dockerfile .')
                 }
            }
        }

        stage('Push Image'){
           steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials' ) {
                        dockerapp.push('latest')
                        dockerapp.push("${env.BUILD_ID}")
                    }
                }
           }
        }

    }
}