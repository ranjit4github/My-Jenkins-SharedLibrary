def checkout (){
  git branch: "${branch}", credentialsId: 'patDemoToken1', url: "${repoURL}"
}

def push2Remote(){
  bat '''
    cd "/d F:"
    cd "F:\\mbgheri\\"
    git config --global --add safe.directory F:/mbgheri
    git config --global user.email "${userEmail}"
    git config --global user.name "${userName}"
    git add . 
    git commit -m "Updated as part of Build - ${BUILD_NUMBER}"
    git push
  '''
}
