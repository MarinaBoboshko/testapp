node {
    stage('Making_artifacts'){
        sh label: '', script: '''docker run -it -d my_image  # запускам image в detached моде
docker exec $(docker ps -a -q --filter ancestor=my_image) bash -c "cd /app/text.txt; your_command"

list=$(docker exec  $(docker ps -a -q --filter ancestor=my_image)  bash -c \'ls /app/text.txt\')
for i in $list; do  docker cp $(docker ps -a -q --filter ancestor=my_image):$i ./Users/Shared/Jenkins/Home/workspace/testapp ; done

for i in $(docker ps -a -q --filter ancestor=my_image); do docker rm $(docker stop $i); done '''
}}



pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
              // sh 'docker run -it -d $ID_CONTAINER'
              //  args '-v $HOME/.text.txt:/root/.text.txt'
              echo "hello"
              sh 'docker ps'
            }
        }
    }
}
