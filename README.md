# vbron
ACME invoicing system
[![BCH compliance](https://bettercodehub.com/edge/badge/nikotrone/vbron?branch=master)](https://bettercodehub.com/)

1. System model
2. Dependancies
3. Installation
4. Run
5. Testing

## 1. System model
ER schema: https://drive.google.com/file/d/0Bwsc40qq4z2OaV9kSFdLQ1Joc00/view?usp=sharing

## 2. Dependancies
- Java 8 SDK
- Maven
In order to run the application you need java 8 SDK installed and properly configured. If running from sources you need also Maven installed 

## 3. Installation
Source code:
You need to download the project and have java 8 SDK and maven installed and properly configured.
Extract project in the installation folder of your choice, then open project root directory and execute command:

$ mvn spring-boot:run

## 4. Run
If you downloaded source code run "$ mvn spring-boot:run" within the project root directory.
If everything went smooth you should be able to navigate to http://localhost:8080 for the GUI.
http://localhost:8080/console gives access to in memory database console.

The following commands show the JSON reply of application
- http://localhost:8080/invoice
- http://localhost:8080/customer
- http://localhost:8080/address

## 5. Testing
The file ACMEInvoice.txt included in the project root has a basic set of queries that can be manually run from database console to populate the database in order to test main application functionalities
