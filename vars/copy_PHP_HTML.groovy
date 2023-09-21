def copyfile(){
  echo "Coping Application files"
  sh '''
    echo "Envvironment: ${environ}"
  '''
  if (env.environ == "dev"){
      sh '''
        rsync -avzh ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' root@${server}:/var/www/html/
      '''
  }else if(env.environ == "prod")
  {
      sh '''
        rsync -avzhe ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' root@${server}:/home/ec2-user/
      '''      
  }
}
