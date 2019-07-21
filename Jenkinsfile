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
                appcontainer.inside(-v "/var/lib/docker.sock:/var/lib/docker.sock"){
                        sh "python app/app.py"    
         }
                appsorter.inside(-v "/var/lib/docker.sock:/var/lib/docker.sock"){  
                        sh "python sorter/app.py"
                                     
                 }   
         
         }

}
