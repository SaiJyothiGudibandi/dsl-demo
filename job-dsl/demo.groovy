pipelineJob('DSL_Demo') {

    def repo = 'https://github.com/SaiJyothiGudibandi/maven-repo.git'
   
    triggers {
        scm('*/15 * * * *')
    }
    
    definition {
        cpsScm {
          scm {
            git(repo, 'master', { node -> node / 'extensions' << '' } )
            }
        }
    }
}