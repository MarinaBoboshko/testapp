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
                sh """
                docker run  myname
                docker exec -t friendly_elion cat text.txt > Data.txt
                cat /var/lib/jenkins/workspace/testapp/app/Data.txt
                ls
                docker run -td sorter
                docker exec -t quirky_chatelet cat text.txt
                docker exec -t quirky_chatelet cat text.txt < /var/lib/jenkins/workspace/testapp/app/Data.txt
                docker ps
                pwd
                ls
                cat text.txt
                """
}
         }
      
                


}
