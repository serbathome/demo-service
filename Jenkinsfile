
branch='main'

pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout([
                            $class: 'GitSCM',
                            userRemoteConfigs: [[url: "https://github.com/serbathome/demo-service"]],
                            branches: [[name: "${branch}"]],
                            extensions: [[$class: 'LocalBranch', localBranch: "**"],
                            ]
                        ])
                }
            }
        }
        stage('Build') {
            steps {
                sh 'ls -al > ./application.log'
                sh 'gzip ./application.log'
            }
        }
        stage('Test') {
            steps {
                sh 'sh test.sh'
            }
        }
        stage('Archve artifact') {
            steps {
                archiveArtifacts artifacts: 'application.log.gz', allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            script {
                echo "Cleaning up..."
                sh "rm -rf application.log.gz"
            }
        }
    }
}
