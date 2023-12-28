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
    cd F:\\${appName}\\
    npm run build
  """
    bat """
        powershell Compress-Archive -Path "build\\*" -DestinationPath "${appName}_${BUILD_NUMBER}.zip"
    """
}
