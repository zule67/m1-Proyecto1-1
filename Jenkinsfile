pipeline {
    agent any
    tools {
        maven "maven3.8.1"
        jdk "jdk16"
    }
    stages {
        stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Sonar'){
           steps {
               sh 'mvn verify sonar:sonar -Dsonar.projectKey=zule67_Proyecto1 -Dsonar.organization=zule67 -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=b8da098e4949087b5976a872f3bb7c1f379d3a63'
			}
 
            
        }

    }
}
