def copyfile1(){
  echo "Coping Application files"
  sh '''
    rsync -avzh ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' root@${staging_server}:/var/www/html/
  '''
}
