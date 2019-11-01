node {
        stage('Build image') {
        dir('app'){
                appcontainer = docker.build("myname")
        }
        dir ('sorter'){
                appsorter = docker.build("sorter")        
        }
    }
        stage ('Testing container'){
                appcontainer.inside('-v /var/run/docker.sock:/var/run/docker.sock'){
                        sh "python app/app.py"    
         }
                appsorter.inside('-v /var/run/docker.sock:/var/run/docker.sock'){  
                        sh "python sorter/app.py"
                                     
                 }   
         
         }

}
