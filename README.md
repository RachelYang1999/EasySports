# EasySports
## Introduction
This web application EasySports is a platform for searching playgrounds. The web platform combines all kinds of playgrounds and stadiums so that users can use this platform to quickly find and book a suitable playground.
## Technologies
* The whole web application is developed with the Spring framework and the corresponding Model-View-Controller (MVC) architecture. 
* For the front end development, HTML, JavaScript, and CSS are used to construct the user interface. 
* In terms of the back end, Java is used for developing the back end business logic and interaction logic between the back end with the front end and the database, and MySQL is used to store data for this web application.
## Configuration Instructions 
Requirements:  
1. IntelliJ IDEA (Ultimate Edition)  
2. Java (above 8)
3. Apache Tomcat 8.5.57  
* **Important note: Please make sure to deploy the application using the mentioned requirement of specified versions of IntelliJ, Java and Tomcat as mentioned above otherwise we do not guarentee the success of the deployment.**  


## Execusion Instructions:
1. Clone this repostory: `git clone https://github.sydney.edu.au/yshi3730/ELEC5619_EasySports.git`  
2. Open IntelliJ IDEA.   
3. Select "Open or Import".   
4. Select the downloaded folder.  
5. Select `ELEC5619_EasySports/easysports/pom.xml`, select "Open as Project".  
6. Select "Edit Configurations" -> "Add New configuration" -> "Tomcat Server". 
7. Locate Tomcat 8.5.57 to "Application Server" and Select the suitable JRE version.
8. Change the URL to `http://localhost:8080/easysports/`.  
9. Select deployment, change the Application context to `/easysports`.  
10. Select "Add" -> "Artifact" -> Select "EasySports:war exploded".  
11. Selcet "Apply" and press "OK".  
12. Run the web application.  
* **Important note: Connection to the local database is not necessary because the application uses Amazon RDS for data storage.** 

## User Guide  
1. Please register or login bofore accessing the functionalities of the application using the user name: n@n.com and the password: 1.  
2. Due to the internet latency between the database and the client application, as well as we are using a free-tier Amazon database, therefore there will be some delay for some of the  operations, please wait patiently for the result to appear.    
3. When choosing the preferred days for the playground, please select 10/12/2020 or 20/1/2021.  

## Sources  
### Images used in the project are retrieved from:  
https://unsplash.com/photos/9MR78HGoflw  
https://unsplash.com/photos/kP1AxmCyEXM  
https://unsplash.com/photos/PvyfCGpUXSQ  
https://unsplash.com/photos/uCMKx2H1Y38  
https://unsplash.com/photos/j5kEQ1JLqZk  
https://unsplash.com/photos/Vc8jfmzWoFE  
https://unsplash.com/photos/dOdUKdgCzh0  
https://unsplash.com/photos/7XHbr-V62IM  
https://unsplash.com/photos/TEYrLTKKMSg  
https://www.pexels.com/photo/brown-and-white-track-field-163444/  
https://www.pexels.com/photo/ball-court-design-game-209977/  
