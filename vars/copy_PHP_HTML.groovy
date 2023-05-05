def call(){
  echo "Coping Application files"
  sh '''
    rsync -avzh ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' jenkins@${staging_server}:/var/www/html/
  '''
}
