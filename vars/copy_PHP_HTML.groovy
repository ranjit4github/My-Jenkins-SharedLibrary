// Copy Application files into the deployable folder of the Application Server.
// Declare and assign the variables in the Jenkinsfile of the appication repo.

def copyfile(){
  stage('Copy Files'){
    script{
      echo "Coping Application files"
      sh '''
        echo "Copying Files to ${environ} Server"
      '''
      if (env.environ == "dev"){
          sh '''
            rsync -avzh ${WORKSPACE}/* --exclude-from 'exclude-list.txt' ${userid}@${server}:${deployPath}${AppName}
          '''
      }else if(env.environ == "prod")
      {
          timeout(time: 30, unit: "MINUTES") {
            input message: 'Do you want to approve the Deployment?', ok: 'Yes'
          }
          echo "Initiating deployment"
          sh '''
            rsync -avh -e "ssh -p 65002" ${WORKSPACE}/* --exclude-from 'exclude-list.txt' ${userid}@${server}:${deployPath}
          '''      
      }
    }
  }
}
