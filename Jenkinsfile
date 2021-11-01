pipeline{
       agent any
	   tools{
	   maven 'Maven Home'
	   }
	   stages{
	   stage('Build'){
	   steps{
           bat '''
           cd PracFrameWorkProject
	   mvn clean compile
	   '''
	   }
	   }
	   stage('Test'){
	   steps{
	   bat 'mvn test'
	   junit '**/test-output/junitreports/TEST-*.xml'
	   }
	   }
	   stage('Final'){
	   steps{
	   echo 'Pipeline executed successfully'
	   }
	   }
}
}
