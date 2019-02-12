#!groovy
import hudson.model.User
import hudson.security.Permission
import hudson.EnvVars
import jenkins.model.*
import java.time.*
import java.util.*
import java.lang.*

pipeline {
    agent any
    parameters {        
        string(defaultValue: "a", description: '', name: 'Test')
    }
    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '15', artifactNumToKeepStr: '15'))
    }
    stages {
        stage('Build') {
            steps {
                sh "ls -laht"
            }
        }
    }
    post {
        always {  
            script{
                echo "ALWAYS"
            }                 
        }
    }
}