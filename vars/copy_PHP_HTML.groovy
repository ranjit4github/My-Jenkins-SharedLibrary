def copyfile(){
  echo "Coping Application files"
  sh '''
    echo "Envvironment: ${env}"
  '''
  if ('${env}' == "dev"){
      sh '''
        rsync -avzh ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' root@${server}:/var/www/html/
      '''
  }else if('${env}' == "prod")
  {
      sh '''
        rsync -avzhe ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' root@${server}:/home/ec2-user/
      '''      
  }
}
