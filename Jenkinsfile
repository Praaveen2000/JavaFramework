pipeline{
       agent any
	   tools{
	   maven 'Maven Home'
	   jdk 'Java_Home'	   
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
	   bat '''
	   cd PracFrameWorkProject
	   mvn clean test
	   '''
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
