job('NodeJS Docker example') {
    scm {
        git('https://github.com/Ndomi/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
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
        dockerBuildAndPublish {
            repositoryName('ndomi/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
