pipeline {
    agent any

    environment {
        COMPOSE_PROJECT_NAME = 'selennium_shopping'
    }

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
                    image 'maven:3.9.9-amazoncorretto-17'
                    args '--entrypoint="" --shm-size=2g --network=selennium_shopping_default'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn -f demoshop/pom.xml clean test -Dselenium.grid.url=http://selenium-hub:4444'
            }
        }

        stage('Report') {
            steps {
                allure([
                    results: [[path: 'demoshop/target/allure-results']]
                ])
            }
        }

    }

    post {
        always {
            sh 'docker compose down --remove-orphans || true'
        }
    }