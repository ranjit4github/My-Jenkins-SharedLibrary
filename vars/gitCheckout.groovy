def checkout (){
  git branch: "${branch}", credentialsId: 'patDemoToken1', url: "${repoURL}"
}

def push2Remote(){
  bat """
    cd "/d F:"
    cd "F:\\${appName}\\"
    git config --global --add safe.directory F:/${appName}
    git config --global user.email "${userEmail}"
    git config --global user.name "${userName}"
    git add . 
    git commit -m "Commited by Jenkins Build Number ${BUILD_NUMBER}"
    git push
  """
}
