pipepline {
    def myvar = 1234
    stage('scm'){
checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/MarinaBoboshko/testapp.git/']]])
}
    stage('Build image') {
        sh "echo '${myvar}'"
        sh 'echo "${myvar}"'
        sh """
            ls -la .
            pwd
        """
        dir('app'){
            def app = docker.build("myname")
        }

    }
    stage('Test image') {
        app.inside {
        sh 'echo "Tests passed"'
        }
    }
}
