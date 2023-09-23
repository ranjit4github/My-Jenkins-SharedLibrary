def call(){
 echo "Building java project"
  sh '''
    mvn clean package
  '''
}
