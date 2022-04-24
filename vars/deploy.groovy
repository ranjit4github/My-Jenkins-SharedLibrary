def call(){
  echo "Executing deploy method....." 
  sh '''
    scp -v -o StrictHostKeyChecking=no **/*.war root@${staging_server}:/opt/tomcat/webapps/
  '''
}
