pipeline {
    agent any

    stages {
        stage('Install') {
            steps {
                sh 'mvn -f exchange/ -B -DskipTests clean package'
            }
        }

        stage('Install and Test') {
            steps {
                sh 'mvn install -f exchange/ -Pdevsonar '
            }
        }

        stage('Sonar') {
            steps {
                sh 'mvn sonar:sonar -f exchange/ -Pdevsonar -Dsonar.host.url=http://localhost:9000 '
            }
        }

        stage('Deliver') { 
            steps {
                sh 'echo Delivery....' 
            }
        }
    }
}