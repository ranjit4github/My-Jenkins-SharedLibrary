def call(){
  echo "Uploading the artifact..."
  sh '''
    aws s3 cp ${WORKSPACE}/target/*.war s3://devopsweb.ansible
  '''
}
