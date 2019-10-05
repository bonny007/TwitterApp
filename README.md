# Project Title

Twitter Mutual Friends Finder App.

## About Project

This project is designed using Spring, MVC and AOP frameworks. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

ApacheTomcat9.0 required with JRE 1.8 or higher
```
You will need to have apache tomcat 9.0 on your system or on any other server.
```
To view the project in eclispe IDE or anyother import it as a maven project.

### Deployment

Download the war file from the git repository and copy it to tomcat webapps folder.

```
On windows the default location is C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps
```

If you want to run it through eclipse then first configure server in eclipse by adding tomcat.


## Running the application

Once tomcat is configured you can start the tomcat either through eclipse IDE or on your server and goto following link on your browser.

```
Once the application starts on server go to http://localhost:8080/twitterfriends/
```

### Running Tests

Once application starts on Browser one can see two text fields for twitter handles and a find button which is used to find mutual friends between two twitter handles.

Things to watch out for:

*If twitter handle is of invalid format or empty an error will be thrown on UI itself.

*If twitter handle doesn't exist OR if no mutual friends exist, the application still process it and on the UI you will get "no mutual friends or twitter handle doesn't exist." 

*If any exception is thrown by the application then a JSON response is send with response body having error code, error mesage and timestamp.



## Authors

* **Bernard Lewis** 


