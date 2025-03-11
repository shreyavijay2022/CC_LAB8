pipeline {
    agent any
    stages {
        // stage('Clone repository') {
        //     steps {
        //         checkout([[$class: 'GitSCM',
        //         branches: [[name: '*/main']],
        //         userRemoteConfigs: [[url: 'https://github.com/shreyavijay2022/CC_LAB8.git']]
        //         ])
        //     }
        // }
        stage('Build') {
            steps {
                build 'PES2UG22CS537'
                sh 'g++ main.cpp -o output'
            }
        }
        stage('Test') {
            steps {
                sh './output'
            }
        }
        stage('Deploy') {
            steps {
                echo 'deploy'
            }
        }
    }
    post {
        failure {
            error 'Pipeline failed'
        }
    }
}