pipelineJob('DSL_Demo') {

    def repo = 'https://github.com/SaiJyothiGudibandi/sample-project-maven.git'
    parameters {
        stringParam('var1', '$var1')
    }
   
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
