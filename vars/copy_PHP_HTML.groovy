def copyfile(){
  echo "Coping Application files"
  sh '''
    echo "Copying Files to ${environ} Server"
  '''
  if (env.environ == "dev"){
      sh '''
        rsync -avzh ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' env.user@${server}:/var/www/html/
      '''
  }else if(env.environ == "prod")
  {
      sh '''
        rsync -avzh ${WORKSPACE}/* --exclude 'Jenkinsfile' --exclude '.git' env.user@${server}:/var/www/test/
      '''      
  }
}
