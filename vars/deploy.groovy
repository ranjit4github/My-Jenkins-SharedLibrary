def call(){
  echo "Executing deploy method....."
  
  def server_list = "${staging_server}".replaceAll("\\s","")
  
  for (String server in server_list.split(',')){
    sh '''
      scp -v -o StrictHostKeyChecking=no **/*.war root@${server}:/opt/tomcat/webapps/
    '''
  }
}
