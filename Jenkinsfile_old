pipeline {
    agent any

    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'ref', value: '$.ref'],
                [key: 'fullName', value: '$.repository.full_name'],
                [key: 'repoName', value: '$.repository.name'],
                [key: 'commitHash', value: '$.head_commit.id']
            ],
            causeString: 'Triggered on $ref',
            printContributedVariables: true,
            printPostContent: true,
            regexpFilterText: '$ref',
            regexpFilterExpression: ''
        )
    }

    stages {
        stage('Extract Webhook Data') {
            steps {
                script {
                    echo "Ref: ${ref}"
                    echo "Full Name: ${fullName}"
                    echo "Repo Name: ${repoName}"
                    echo "Commit Hash: ${commitHash}"
                }
            }
        }
    }
}
