def copyfile(){
  echo "Coping Application files"
  sh '''
    echo "Copying Files to ${environ} Server"
  '''
  if (env.environ == "dev"){
      sh '''
        rsync -avzh ${WORKSPACE}/* --exclude 'Jenkinsfile' --exclude '.git' ${userid}@${server}:/var/www/html/${AppName}
      '''
  }else if(env.environ == "prod")
  {
      sh '''
        rsync -avzh ${WORKSPACE}/* --exclude 'Jenkinsfile' --exclude '.git' ${userid}@${server}:/var/www/test/
      '''      
  }
}
