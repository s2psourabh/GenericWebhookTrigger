@Library('shared-library') _

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Call the updateGitHubStatus function from the shared library
                    // No need to pass fullname and commithash manually; they are set by the webhook trigger
                    updateGitHubStatus()
                }
            }
        }
    }
}

