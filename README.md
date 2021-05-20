<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      	<ul>
        		<li><a href="#installation">Installation</a></li>       
	        	<li><a href="#CONSUMER SIDE CONTRACT TEST">CONSUMER SIDE CONTRACT TEST</a></li>
	        	<li><a href="#PACT BROKER SETUP AND UPLOAD CONTRACT TEST">PACT BROKER SETUP AND UPLOAD CONTRACT TEST</a></li>
	        	<li><a href="#PROVIDER CONTRACT TEST EXECUTION">PROVIDER CONTRACT TEST EXECUTION</a></li>
        </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Welcome to pact-accelerator. Contract testing is a technique for testing an integration point by checking each application in isolation to ensure the messages it sends or receives conform to a shared understanding that is documented in a "contract".

Pact is a contract testing tool. Contract testing is a way to ensure that services (such as an API provide and a client) can communicate with each other.

Here's why:
* We often come across scenario where we need to test API request response even before API is built to validate requirement.
* Pact is a consumer driven contract testing tool. This means contract is written as part of consumer tests.
* We do not require actual API to be available and contract test is created using Pack Mock service:


### Built With

We need following tools/technologies to use all the above features.
* [MAVEN](https://maven.apache.org/)
* [PACT Broker](https://hub.docker.com/r/pactfoundation/pact-broker/)
* [Sprint Boot - (API Simulator)]



<!-- GETTING STARTED -->
## Getting Started

### Installation
We need to checkout given accelerator to the local machine and follow below steps to perform contract testing.

### CONSUMER SIDE CONTRACT TEST

Create pact contract test by using PactProvider and builder to generate contract test cases. A contract test contains request, response and interactions that will be verified in test.

In this step we do not require actual API to be available and contract test is created using Pack Mock service. Please find below code snippet to create contract test.

1. Navigate to consumer-client folder present in Pact-Test folder.
2. Import it as existing Maven Project.
3. Refer to src/test/java/com/client/PostCodeTest.java to check for example code to generate Contract
4. Use PactProviderRuleMk2 to configure a mock provider to be used in contract generation like below (it creates mock provider with name ProviderApi, it is important to give this name correctly as it will be present in contract and will be used when running contract test from Actual API).
5. Set the folder used to generate contract test cases using System.setProperty("pact.rootDir","../pacts").
6. Run the code and check pact.rootDir and it will have contract file with naming convention as <ConsumerName>-<ProviderName>.json. 
7. Check the Json file it will have test verification covered as part of interactions. 

###  PACT BROKER SETUP AND UPLOAD CONTRACT TEST

1. Navigate to dockerpactbroker folder present in Pact-Test folder. (Also present at this location for latest https://hub.docker.com/r/pactfoundation/pact-broker/)
2. Start Pact broker service using docker file (docker-compose.yml).
3. In docker yml file check for 8113 port given as example where service will be started.
4. Run the command docker-compose up from folder containing yml file to start pact broker
5. Navigate to http://localhost:8113/. No contract test should be present on the UI as shown below
6. Navigate back to consumer-client folder present in Pact-Test folder used in contract generation
7. Configure pactDirectory to location where contract tests are present on local drive in configuration section of au.com.dius in pom.xml.
8. Configure pactBrokerUrl to broker URL configured in docker in same section (http://localhost:8113)
9. Run the command mvn pact:publish to publish contract test cases to broker 
10. Verify Pact broker has the contract test available on UI as shown below.



### PROVIDER CONTRACT TEST EXECUTION

1. Navigate to pact-runner folder present in Pact-Test folder.
2. Open Pom.xml and check for maven plugin used in contract test execution.
3. Specify provide name as per name given in the contract test to execute test case.
4. Specify host as the IP address of API and port as the port used by API running.
5. Specify pactBrokerUrl as the URL where broker is running and contract tests are published.
6. Run command mvn pact:verify to execute contract test from Pact Broker
7. Verify on Pact Broker test has been executed and marked as passed and Failed.

 
<!-- USAGE EXAMPLES -->
## Usage

This project is specifically designed to do contract testing before and after API is built in:

1. Run Consumer side contract test.
2. Run provider contract tests using Mock service and Pact broker.
3. Run contract tests when actual API is built to test all the contracts are working.
4. It helps to integration test scenarios even with stand alone API's built in.



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request






