job('NodeJS example') {
    scm {
        git('git://github.com/ndomi/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('ndomi')
            node / gitConfigEmail('n.nqeketo@yahoo.co.za')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
