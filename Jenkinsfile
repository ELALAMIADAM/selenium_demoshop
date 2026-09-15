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
                    image 'maven:3.9.9-eclipse-temurin-17'
                    args '--entrypoint="" --shm-size=2g '
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