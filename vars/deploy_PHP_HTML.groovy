def call(){
  echo "Deploying Application files"
  sh '''
    for fileName in `find ${WORKSPACE} -type f -mmin -10 | egrep -v ".git|Jenkinsfile"`
    do
      fil=$(echo ${fileName} | sed 's/'"${JOB_NAME}"'/ /' | awk {'print $2'})
      scp ${WORKSPACE}${fil} root@${staging_server}:/var/www/html/${JOB_NAME}${fil}
    done
  '''
}
