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

    }
         stage('Test image') {
         dir('app'){
                sh """docker run myname 
                docker cp $CONTAINER_ID:/app/text.txt /var/lib/jenkins/workspace/testapp/app/text.txt
                        """
}
                
         }

                


}
