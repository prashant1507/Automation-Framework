<h1><i>Automation Framework</i></h1> 

This is a java selenium framework which is using testng, maven, extent report, selenium, java, etc to achieve different tasks.

[Project's Java Docs](https://github.com/prashant1507/SeleniumAutomationFramework/blob/main/java-doc/)   
[Sample Test Report](https://github.com/prashant1507/SeleniumAutomationFramework/blob/main/framework-generate-sample-report/)   
[Sample Test Video](https://github.com/prashant1507/SeleniumAutomationFramework/blob/main/framework-generate-sample-report/)   
[Properties file for execution settings](https://github.com/prashant1507/SeleniumAutomationFramework/blob/main/src/test/resources/config/FrameworkConfig.properties)

<h3><i>Project Features</i></h3>
-   Supports parallel test.<br/>
-   Multiple browsers can be setup.<br/>
-   Generates report after each run for all test cases with screenshots.<br/>
-   Record video for failed test cases.<br/>
-   Option to auto manage drives using WebDriverManager.<br/>
-   Option to send report to email.<br/>
-   Option to run tests on local or remote.<br/>
-   Read data from Properties file, Excel, JSON files.<br/>
-   Real time reporting using ELK.<br/>
-   Option to run on docker grid or selenoid.
  
<h3><i>Project Components</i></h3>  
Below are the component details of the framework:

-   <h4>Browser interaction using</h4>
    `selenium`

-   <h4>Test Data</h4>
    Supports to read and maintain data from multiple file types like:<br/>
    -  Properties File<br/>
    -  Excel File with the help of [ApachePOI Jars](https://mvnrepository.com/artifact/org.apache.poi/poi/) <br/>
    -  JSON File<br/>

-   <h4>Test Scripts</h4>
    [TestNg](https://mvnrepository.com/artifact/org.testng/testng/) is used as a unit test framework in order to generate test script taking into account   the `Page Object Model` design pattern.

-   <h4>Build Tool</h4>
    Using `maven`, project dependencies are managed. Test can be run using `pom.xml` and `testng.xml`.

-   <h4>Reporting</h4>
    Generates html report automatically by using [Extent Report 5](https://www.extentreports.com/docs/versions/5/java/index.html).
    By attaching screenshots and execution videos of the failed test cases. However, user can set the framework to take screenshots
    and videos of passed or/and skipped test cases. All reports are generated in `reports-test-output` folder. Report automatically opens in default browser.<br/>      
    <b>Note:</b> Exception logs and fail reasons are added to the report as well. All images are in Base64 and videos in mp4.

-   <h4>Utilities</h4>
    Holds common methods to re-use in order to achieve maximum re-usability.

-   <h4>Test Runner</h4>
    -   Tests can be executed in parallel and in cross browsers by using:<br/>
        -    `pom.xml`<br/>
        -   `testng.xml`<br/>
        -   `Jenkins`<br/>
    -   Tests can be executed using:<br/>
        -   `local browsers`<br/>
        -   `remote browsers`<br/>
            -   docker selenium grid<br/>
            -   selenium grid<br/>
            -   selenoid<br/>

    <b>Note:</b> Will add support to run using Jenkins.

-   <h4>Other Components</h4>
    -   [Monte Screen Recorder](https://mvnrepository.com/artifact/com.github.stephenc.monte/monte-screen-recorder) is used to record tests in `.avi` format.<br/>
    -   [Jave Core Package](https://mvnrepository.com/artifact/ws.schild/jave-core) and [Jave Windows 64 Bit Native Package](https://mvnrepository.com/artifact/ws.schild/jave-native-win64) is used to convert from `.avi` to `.mp4` to make it compatible with html5.<br/>
    -   [JavaMail API](https://mvnrepository.com/artifact/com.sun.mail/javax.mail) and [JavaBeans(TM) Activation Framework](https://mvnrepository.com/artifact/javax.activation/activation) is used to send the test report automatically on email using gmail or outlook. However, user can still decide if report has to be send or not.<br/><b>Note: Framework allows passwords in Base64Encode only.</b><br/>
    -   [Jave Core Package](https://mvnrepository.com/artifact/ws.schild/jave-core) and [Jave Windows 64 Bit Native Package](https://mvnrepository.com/artifact/ws.schild/jave-native-win64) is used to convert from `.avi` to `.mp4` to make it compatible with html5.<br/>
    -   [JavaMail API](https://mvnrepository.com/artifact/com.sun.mail/javax.mail) and [JavaBeans(TM) Activation Framework](https://mvnrepository.com/artifact/javax.activation/activation) is used to send the test report automatically on email using gmail or outlook. Moreover, user can still decide report to be send or not.<br/>   
        <b>Note: Framework allows passwords in Base64Encode only.</b><br/>
    -   All framework settings are done in properties file, making it easy for a non-technical person.<br/>
    -   User can opt to run the test with their web drivers placed in drivers folder or with WebDriverManager.<br/>
    
<br/>
<h3>How to run:</h3>
1. Set all the properties and setting in properties file.<br/>
2. Run pom.xml or testng.xml file.
<br/>
<h3>Settings of Properties file</h3>

[Path to properties file](https://github.com/prashant1507/SeleniumAutomationFramework/blob/main/src/test/resources/config/FrameworkConfig.properties)

-   `url` of the test environment.
-   `environment` where the test has to be performed.
-   `testername` inorder to keep track.
-   `downloadwebdriver` to decide if tester want to place the drivers or wants the framework to download it with the help of [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager).
-	`runmode` decides whether to run test cases on local, grid (/ docker-grid) or selenoid. Accepts yes or no.<br/>
     -  if `runmode` is yes then user has to provide the remote url in `remoteurl`.
-   `environment` which is to be tested.
-   `testername` name of the tester.
-   `downloadwebdriver` to decide if tester wants to place the drivers or wants the framework to download it with [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager).

-   To delete old report data:
    ```
    deleteoldreports - to elect if tester wants to delete old reports. Accepts yes or no.
    numberofdays - if yes than how old the files should be. Value in number of days.
    ```   
-   `overridereports` to elect if tester want all reports to be merged in one i.e., current reports plus old ones or create new report for each test suite run. Accepts yes or no.
-   Screenshots:
    ```
    passedscreenshot - to take screenshot of passed test cases. Accepts yes or no.
    failedscreenshot - to take screenshot of failed test cases. Accepts yes or no.
    skippedscreenshot - to take screenshot of skipped test cases. Accepts yes or no.
    ```
-   `retryfailedtestcases`to re-run fail test cases. Accepts yes or no. Not recommended setting to set it as yes.
-   Email details to send report:
    ```
    sendmailafterexecution - to send report. Accepts yes or no.
    sendmailusing - to choose from gmail or outlook.
    emailid - sender's email id.
    emailpassword - sender's password in Base64Encode only.
    receiversemailid - receiver's email id.
    ```   
    <b>Note:</b> In order to use gmail then enable [Allow less secure apps](https://myaccount.google.com/lesssecureapps?pli=1&rapt=AEjHL4M-tPfEQqsOBVtOWL9wQTcuoh6uNQC7kNHqA1IgKKctttT5U20uTAcW3mpM7VQfCoTrdrwVnEpKLMfkCsRkGPUziWpq5A)
-   Setup real time report using ELK:   
    ```
    useelk - to enable using real time reporting using ELK. Accepts yes or no.
    elksuiteurl - url of the elastic search data add.
    ```
    <b>Note:</b> To use ELK, set the schema to have below keys:
    -   TestName
    -   Status
    -   ExecutionTime<br/>
    More fields can be added and changes should be done accordingly in ELKUtils.class

<h3> How to setup:</h3>
-   Selenoid: SetupReadMe\Selenoid.md<br/>
-   Docker Selenium Grid: SetupReadMe\Docker-Grid.md<br/>

<h4>Known Issues:</h4>
-   Video recording not possible for failed test case when running tests using docker. 
