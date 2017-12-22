#!/usr/bin/env groovy
import groovy.transform.Field
@Field Map<String, Object> defaults = [

    Jenkins_user_credentialsId: '756c5310-62cc-43b8-8c6d-773efad58cc2', // Jenkins_user (Jenkins Service Account)
    jdk: 'jdk-1.8.0_131', // Version of java to use with mvn
    node: 'NodeJSv8.5.0', // Version of node to use
    technology:'',
    buildTool: '',
    gitRepoURL: '',

    build= 'true',
    defaultMavenBuild: 'clean install',
    defaultAntBuild: '',
    defaultGradleBuild: '',
    defaultNodeBuild: 'install'
]


def call(Closure body = {}) {
    // Collect configuration defaults into the object
    Map<String, Object> config = [:]
    config = plus(config, defaults)

    // Get the config settings from the projects Jenkinsfile and make read only
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // Disable concurrent builds
    properties([disableConcurrentBuilds()])
/*
    Closure withGitCredentials = { Closure action ->
        // Using work around from: https://issues.jenkins-ci.org/browse/JENKINS-28335
        // Storage format for credentials file documented here: https://git-scm.com/docs/git-credential-store
        // https://user:pass@example.com using svc_git and Personal Access Token
        withCredentials([file(variable: 'CREDENTIALS_GIT', credentialsId: config['credentialsGitId'])]) {
            sh "git config --local credential.username \"${config['credentialUsername']}\""
            sh "git config --local credential.helper \"store '--file=${CREDENTIALS_GIT}'\""
            action()
            sh 'git config --local --remove-section credential'
        }
    }
*/


// Inputs lene developer se
// docker registiry value map me
// component and subcomponent map me
// Maven ki settings file handel
  podTemplate(label: '$technology', containers: [
  containerTemplate(name: '$build', image: <paytmmall.io/paytmmall>'$technology_$build', ttyEnabled: true, command: 'cat')
  ]) {

  node('$label') {

      container('$build') {
      // git clone '$gitRepoURL'
stage('Checkout') {
      test= git ls-remote git@bitbucket.org:paytmteam/paytmmall-infrastructure-as-code.git
      test me branch ka naam aa gya
      git clone that particluar branch.
},
    stage('Build Stage'){
      if tech = java and buildtool = maven
          sh 'sh(script: "${config['defaultMavenBuild']}"'
          elseif tech = java and buildtool = ant
          sh 'sh(script: "${config['defaultAntBuild']}")'
          elseif tech = java and buildtool = gradel
          sh 'sh(script: "${config['defaultGradleBuild']}")'
          elseif tech = NodeJS
          sh 'sh(script: "${config['defaultNodeBuild']}")'
          else
          sh "Lg gya lanka kuch nahi mila"

          stage('package'){
          docker.withRegistry('<<your-docker-registry>>', '<<your-docker-registry-credentials-id>>') {
          sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id

        def app = docker.build "component-subcomponet"
          },
          stage ('publish'){
          app.push "${commit_id}"
          }
      }
    }
  }

  =================Build and push samapt =================


return this
