job('NodeJS example') {
    scm {
        git('git://github.com/rscheiwe/docker-aqua.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('rscheiwe')
            node / gitConfigEmail('rscheiwe@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
