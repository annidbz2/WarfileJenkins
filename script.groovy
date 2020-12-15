def gitCheckout(){
	checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], gitTool: '', submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'fc242f50-3c1e-41aa-90da-6462fac46f4d', url: 'https://github.com/annidbz/JenkinsTest.git']]])
}


def buildApp(){
			echo "building version ${params.executeTests}"
            echo "Compile Stage"
            bat "mvn clean compile" 
}

def testApp(){
		 echo "building version ${NEW_VERSION}" 
         bat "mvn test" 
}

def deployApp(){
		
		 bat "mvn clean package" 
         echo "deploying version ${params.VERSION}"
}

return this