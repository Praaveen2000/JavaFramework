pipeline{
       agent any
	   tools{
	   maven 'Maven Home'
	   }
	   stages{
	   stage('GIT checkout'){
	   steps{
	      git 'https://github.com/Praaveen2000/JavaFramework.git'
	   }
	   }
	   stage('Build'){
	   steps{
	   bat 'mvn clear compile'
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