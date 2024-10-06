// vars/updateGitHubStatus.groovy

def call() {
    // Fetching the fullname and commithash from the environment variables
    def fullname = env.fullname
    def commithash = env.commithash

    // Jenkins job URL
    def contexturl = "http://wgc22hrgca0061.vdi2.ford.com:8080/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/console"
    
    // Get the build status
    def buildstate = "${currentBuild.currentResult}"
    
    // Set the message based on the build state
    def message = buildstate != "SUCCESS" ? "Jenkins build Failed" : "Jenkins Build Successful"

    // GitHub Commit Status Setter step
    step([
        $class: "GitHubCommitStatusSetter",
        reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.ford.com/${fullname}"],
        commitShaSource: [$class: "ManuallyEnteredShaSource", sha: commithash],
        contextSource: [$class: "ManuallyEnteredCommitContextSource", context: contexturl],
        errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
        statusResultSource: [
            $class: "ConditionalStatusResultSource", 
            results: [
                [$class: "AnyBuildResult", message: message, state: buildstate]
            ]
        ]
    ]);
}

