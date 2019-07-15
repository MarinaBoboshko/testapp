node {
        stage('scm'){
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/MarinaBoboshko/testapp.git/']]])
        }
        stage('Build image') {
                sh """
                docker ps
                """
        dir('app'){
                appcontainer = docker.build("myname")

        }
        dir ('sorter'){
                appsorter = docker.build("sorter")        
        }

    }
         
         stage ('Testing container'){
                appcontainer.inside('-v /var/run/docker.sock:/var/run/docker.sock '){
                         sh """
                         python app/app.py
                         cat text.txt
                         cp text.txt /var/lib/jenkins/workspace/test/app/textnew.txt
                         """
         }
                 appsorter.inside('-v /var/run/docker.sock:/var/run/docker.sock')   {  
                        sh """ 
                        ls
                        pwd
                        cp /var/lib/jenkins/workspace/test/app/textnew.txt text.txt
                        python /sorter/app.py
                        """
                 
                 }   
         stage ('Test Data'){
          sh " cat textnew.txt"
         }
         
         }

}
