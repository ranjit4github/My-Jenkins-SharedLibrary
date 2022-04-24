def call(){
  echo "Executing deploy method....." 
  sh '''
    scp -v -o StrictHostKeyChecking=no **/*.war root@${env.staging_server}:/opt/tomcat/webapps/
  '''
}
