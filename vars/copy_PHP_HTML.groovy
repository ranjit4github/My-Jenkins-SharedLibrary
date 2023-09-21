def copyfile(){
  echo "Coping Application files"
  if ("${staging_server}" == "dev"){
      sh '''
        rsync -avzh ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' root@${staging_server}:/var/www/html/
      '''
  }else if("${staging_server}" == "prod")
  {
      sh '''
        rsync -avzhe ${WORKSPACE} --exclude 'Jenkinsfile' --exclude '.git' root@${staging_server}:/home/ec2-user/
      '''      
  }
}
