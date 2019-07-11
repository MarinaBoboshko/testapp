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
                docker exec -t friendly_elion "ls"
                docker exec -d friendly_elion "docker cp friendly_elion:/test/text.txt /var/lib/jenkins/workspace/testapp/app/"
                docker ps
                """
}
         dir('sorter'){
                sh """
                docker run sorter
                docker ps
                """
         }}
         stage('Get data') {
                 dir ('app'){
                 }
         }

                


}
