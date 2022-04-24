def call(){
  echo "Uploading the artifact..."
  sh '''
    aws s3 cp ${workspace}/target/*.war s3://devopsweb.ansible
  '''
}
