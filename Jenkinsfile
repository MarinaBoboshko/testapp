node {
        stage('scm'){
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/MarinaBoboshko/testapp.git/']]])
        }
        stage('Build image') {
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
                         """
         }
                appsorter.inside('-v /var/run/docker.sock:/var/run/docker.sock')   {  
                        sh returnStdout: true, script: 'python sorter/app.py'
                                     
                 }   
         stage ('Test Data'){
              sh returnStdout: true, script: 'cat text.txt'
         }
         
         }

}
