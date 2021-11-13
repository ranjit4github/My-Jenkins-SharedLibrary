def call(){
 echo "Building java project"
  sh '''
  mvn clean install
  '''
}
