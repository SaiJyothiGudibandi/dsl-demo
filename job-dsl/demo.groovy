pipelineJob('DSL_Demo') {

    def repo = 'https://github.com/SaiJyothiGudibandi/sample-project-maven.git'
    parameters {
        predefinedProp('GIT_COMMIT', '$GIT_COMMIT')
        predefinedProp('ARTIFACT_BUILD_NUMBER', '$BUILD_NUMBER')
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
