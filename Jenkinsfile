node {
        stage('scm'){
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/MarinaBoboshko/testapp.git/']]])
        }
        stage('Build image') {
                sh """
                docker ps
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
                docker run  myname 
                docker exec -d friendly_elion "ls"
                docker exec -d friendly_elion "docker cp friendly_elion:/test/text.txt ."
                ls
                docker ps
                """
}
         dir('sorter'){
                sh """
                docker volume ls
                docker run sorter 
                docker ps
                """
         }}
         stage('Get data') {
                 dir ('app'){
                 }
         }

                


}
