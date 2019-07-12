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
                def d = sh returnStdout: true, script: 'docker run myname'
                echo d
                sh """
                docker run  myname
                touch Data.txt
                docker cp  friendly_elion:test/app/text.txt Data.txt
                cat /var/lib/jenkins/workspace/testapp/app/Data.txt
                ls
                docker run -td sorter
                ls
                pwd
                cat /var/lib/jenkins/workspace/testapp/app/text.txt

                """
                  sh returnStdout: true, script: 'pwd'
         sh returnStdout: true, script: 'cat text.txt'
         
         }
         }
      
                


}
