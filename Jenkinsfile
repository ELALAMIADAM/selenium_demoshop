pipeline {
    agent any

    options {
        timestamps()
        skipDefaultCheckout(true)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                dir('demoshop') {
                    bat 'mvn -B clean test'
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