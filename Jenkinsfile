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
        stage('Install ChromeDriver') {
            steps {
                sh '''
                    apt-get update
                    apt-get install -y --no-install-recommends chromium chromium-driver xvfb
                    rm -rf /var/lib/apt/lists/*
                '''
            }
        }

        stage('Test') {
            steps {
                dir('demoshop') {
                    sh 'mvn -B clean test'
                }
            }
        }
    }

    post {
        always {
            junit testResults: 'demoshop/target/surefire-reports/*.xml', allowEmptyResults: false
            archiveArtifacts artifacts: 'demoshop/target/allure-results/**', allowEmptyArchive: true
        }
    }
}