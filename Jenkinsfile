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
               sh 'mvn verify sonar:sonar -Dsonar.projectKey=zule67_m1-Proyecto1-1 -Dsonar.organization=zule67 -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=382f9f974f0a8f47b520450b4df069480277e13b'
			}
 
            
        }

    }
}
