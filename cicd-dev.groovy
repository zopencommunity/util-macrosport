node('linux') {
  stage ('Poll') {
    checkout([
      $class: 'GitSCM', branches: [[name: '*/main']], extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/util-macrosport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [
      string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/util-macrosport.git'),
      string(name: 'PORT_DESCRIPTION', value: 'X.Org: Set of autoconf macros used to build other xorg packages'),
      string(name: 'BUILD_LINE', value: 'DEV')
    ]
  }
}
