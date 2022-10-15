def call(){
  echo "Uploading the artifact to S3 ..."
  sh '''
    aws s3 cp ${WORKSPACE}/target/*.war s3://devopsweb.ansible
  '''
}
