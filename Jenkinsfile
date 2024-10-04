pipeline {
    agent any
    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'ref', value: '$.ref', regexpFilter: 'refs/heads/'],
                [key: 'repoFullName', value: '$.repository.full_name'],
                [key: 'repoName', value: '$.repository.name'],
                [key: 'commitid', value: '$.after']
            ],
            causeString: 'Triggered by Webhook',
            token: 'sample-token',
            printContributedVariables: true,
            printPostContent: true,
            regexpFilterText: '$ref',
            regexpFilterExpression: 'refs/heads/.*'
        )
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/s2psourabh/GenericWebhookTrigger.git', branch: "${ref.split('/').last()}"
            }
        }
        stage('Build') {
            steps {
                sh 'echo "Building..."'
                // Add build steps here
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Running tests..."'
                // Add test steps here
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo "Deploying..."'
                // Add deploy steps here
            }
        }
    }
    post {
        success {
            script {
                currentBuild.result = 'SUCCESS'
                echo 'Build succeeded!'
            }
        }
        failure {
            script {
                currentBuild.result = 'FAILURE'
                echo 'Build failed!'
            }
        }
    }
}

