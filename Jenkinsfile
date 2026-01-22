pipeline {
    agent any

    stages {
        stage('Tests'){
            steps {
               echo 'Testing application'
            }
        }


        stage('Scan '){
            steps{
                withSonarQubeEnv(installationName: 'sq1'){
                    sh 'chmod +x mvnw'
                    sh './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
                }
            }
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