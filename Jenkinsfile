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
            causeString: 'Triggered due to PUSH to $ref branch of $repoFullName',
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
                //git url: 'git@github.com:s2psourabh/GenericWebhookTrigger.git', branch: "${ref.split('/').last()}"
		echo "REPO FULL NAME-> ${repoFullName}"
		echo "REPO NAME-> ${repoName}"
		echo "COMMIT ID-> ${commitid}"
		echo "REF-> ${ref}"
            }
        }
        stage('Build') {
            steps {
                echo "Building..."
                // Add build steps here
            }
        }
        stage('Test') {
            steps {
                echo "Running tests..."
                // Add test steps here
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying..."
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


