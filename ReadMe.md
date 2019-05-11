This variant of the test task is written on Java + Selenium using ThreadLocal driver for parallel tests execution

Tests to develop:

Test #1.
- Open Google.
- Search for “automation”.
- Open the first link on search results page.
- Verify that title contains searched word
Test #2.
- Open Google.
- Search for “automation”.
- Verify that there is expected domain (“testautomationday.com”) on search results pages (page: 1-5).

What was used:
- Selenium
- Maven
- Junit
- Page object pattern
- Video-recorder
- Allure reporting
- ThreadLocal driver
- Bonigacia dependency

You can change browsers in config.properties file (chrome, firefox, opera, edge browsers are supported)

For running this project, you need in command line go to the projects directory and execute the command: mvn clean test