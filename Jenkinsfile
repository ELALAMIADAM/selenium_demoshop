pipeline {
    agent any

    stages {

        stage('commencer selenium') {
            steps {
                sh 'docker rm -f selenium-hub || true'
                sh 'docker compose down --remove-orphans || true'
                sh 'docker compose up -d'
                sh 'docker compose ps'
            }
        }

        stage('Tests') {
            agent {
                docker {
                    image 'maven:3.9.9-openjdk-17'
                    args '--entrypoint="" --shm-size=2g --network=selennium_shopping'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn -f demo/pom.xml clean test'
            }
        }

        stage('Report') {
            steps {
                allure([
                    results: [[path: 'demo/target/allure-results']]
                ])
            }
        }

        stage('Cleanup') {
            steps {
                sh 'docker compose down || true'
            }
        }

    } 
} 