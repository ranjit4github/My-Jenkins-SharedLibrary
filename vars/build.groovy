def java(){
    echo "Building java project"
    sh '''
      mvn clean package
    '''
}

def react(){
  echo "Building React Application"
  bat '''
    cd /d F:
    cd F:\\marlinapp\\
    npm run build
  '''
}
