
 pipeline{
  agent any
  stages {
   stage("verify tooling") {
    steps {
    sh '''
      docker info
      docker version
      docker compose version
      curl --version
      jq --version
    '''
    }
   }

    stage('brune docker data') {
      steps {
        sh 'docker system prune -a --volumes -f'
    }
    }

    stage ("start containers") {
      steps{
        sh 'docker-compose up -d --wait'
        }
    }
    stage("run tests") {
      steps{
        sh './app/mvnw test'
   }
   }
 }
 post {
  always {
    sh 'docker-compose down'
    sh 'docker-compose ps'
 }
 }
 }
