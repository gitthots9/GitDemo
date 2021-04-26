Feature: Application login

Scenario Outline: Positive test to validate login
Given Initialise the browser with chrome
And navigate to "http://automationpractice.com/index.php" Site
And click on login link in homepage to land on secure sign in page
When user enters <username> and <password> and logs in
Then verify that user is successfully logged in
And close the browser


Examples:
|username	|password	|
|ahuja.meenal3@gmail.com	|PRACTICE	|
|abcde	|hello123	|  