#!/usr/bin/env groovy

def call(String name = 'human') {
    agent 
    stages {
        stage('Build') { 
            steps { 
                sh 'echo "Hello, ${name}."' 
            }
        }
    }  
}

