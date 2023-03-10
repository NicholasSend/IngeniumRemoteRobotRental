# Ingenium Double3 Rental Prototype ![alt text][logo_1] ![alt text][logo_2]

![alt text][double3]

[logo_1]: https://ingeniumcanada.org/themes/custom/de_theme/dist/img/branding/ingenium-wordmark.svg "Ingenium"

[logo_2]: https://www.doublerobotics.com/img2/standard/logo-double-white.png "Double Robotics"

[double3]: https://www.doublerobotics.com/img2/_2x/d3-features-transparent-hd.png "Double 3 Robot"

Welcome to IngeniumRemoteRobotRental - a simple web application that allows users to login and purchase items for rent.

## Getting Started
### Prerequisites
To run this application, you will need:

- Java 17
- Maven
- H2 Database

### Installing
Clone the repository to your local machine.

Update the database connection properties in the application.properties file located in src/main/resources/ to match your local H2 instance.

Open a command prompt or terminal and navigate to the project root directory.

Run the command mvn clean install to build the application and run the tests.

After a successful build, run the command mvn spring-boot:run to start the application.

## Usage
After starting the application, navigate to http://localhost:8080 in your web browser.

Click the Login link in the navigation bar to access the login page.

Enter your username and password and click Login.

If authentication is successful, you will be redirected to the dashboard / purchase page.

On the purchase page, select the items you wish to rent and enter your payment information.

Click the Purchase button to complete the transaction.

## Built With

Spring Boot - The web framework used

Maven - Dependency management

H2 - The database used

Bootstrap - The CSS framework used

jQuery - The JavaScript library used

## Authors
Nicholas Sendyk - [NicholasSend](https://github.com/NicholasSend)

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments
Special thanks to Ryan Dodge and Calvin Tong for helping make this project happen. 

As well to the supervisors of the project Dr. Syed Naqvi and Dr. Ioannis Lambadaris.
