def java(){
    echo "Building java project"
    sh '''
      mvn clean package
    '''
}

def react(){
  echo "Building React Application"
  bat """
    cd /d F:
    cd F:\\mbgheri\\
    npm run build
  """
    bat """
        powershell Compress-Archive -Path "Build\\*" -DestinationPath "${appName}_${BUILD_NUMBER}.zip"
    """
}
