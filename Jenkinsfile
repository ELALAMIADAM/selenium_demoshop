pipeline {
    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-17'
            args '--user root'
        }
    }

    options {
        timestamps()
    }

    stages {
        stage('Start Selenium Grid') {
            steps {
                bat 'docker compose up -d'
                bat 'powershell -NoProfile -Command "$deadline = (Get-Date).AddMinutes(2); do { try { Invoke-WebRequest -UseBasicParsing http://127.0.0.1:4444/status | Out-Null; exit 0 } catch { Start-Sleep -Seconds 2 } } while ((Get-Date) -lt $deadline); Write-Error \'Selenium Grid did not become ready\'; exit 1"'
            }
        }

        stage('Run Tests') {
            steps {
                dir('demoshop') {
                    bat 'mvn -B clean test'
                }
            }
        }
    }

    post {
        always {
            junit testResults: 'demoshop/target/surefire-reports/*.xml', allowEmptyResults: true
            bat 'docker compose down --remove-orphans'
        }
    }
}