#!/usr/bin/env groovy

def call(String name = 'human') {
    agent any
    stages {
        stage('Build') { 
            steps { 
                sh 'echo "Hello, ${name}."' 
            }
        }
    }  
}

