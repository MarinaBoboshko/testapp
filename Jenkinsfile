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
                cat Data.txt
                """
}
         dir('sorter'){
                sh """
                docker run -d sorter
                docker exec -t 54ddd0c95796a9886843547440d5b2e37a02fb3825c09dbb1066e8852afcae6f Data.txt < text.txt
                docker ps
                pwd
                ls
                cat text.txt
                """
         }
         }
      
                


}
