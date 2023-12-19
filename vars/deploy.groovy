// Deploy war file into multiple servers
// In Jenkinsfile create a variable staging_server and add servers in comma separated
def war(){
  echo "Deploying War file"
  
  def server_list = "${staging_server}".replaceAll("\\s","")
  
  for (String server in server_list.split(',')){
    echo "${server}"
    sh """
      scp -v -o StrictHostKeyChecking=no **/*.war root@${server}:/opt/tomcat/webapps/
    """
  }
}

//Deploy react application
def react(){
  echo "Deploying React Application"

  sh '''
    rsync -avzh ${WORKSPACE}/build/* --exclude-from 'exclude-list.txt' ${userid}@${server}:${deployPath}
  '''
}
