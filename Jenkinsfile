node {
        stage('scm'){
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/MarinaBoboshko/testapp.git/']]])
        }
        stage('Build image') {
                sh """
                ls -la .
                pwd
                """
        dir('app'){
                def app = docker.build("myname")
        }
        dir('sorter'){
                def sorter = docker.build("sorter")
        }

    }
         stage('Test image') {
         dir('app'){
                sh """docker run myname 
                docker run  myname && docker exec -d 2511d32fc31b761519e3df33aa479192c9b177162cb47fa273633dfe38b33f73 "ls -la"
                ls
                docker ps
                """
}
         dir('sorter'){
                sh """
                docker volume ls
                docker run -d sorter 
                docker ps
                """
         }}
         stage('Get data') {
                 dir ('app'){
                 }
         }

                


}
