# J&Js Getaways  [![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

A full-stack Java web application that allows users to search for a location & accommodation from a database of fictional properties.

![image](https://github.com/jadrog05/PropertiesWebsite/assets/45542564/2ae69a3c-ee89-419a-8bec-e28af1304523)

## Features

* **Accommodation Search:** Users can search for accommodation options in different countries for a short stay using various filters such as location, dates, amenities, etc.
* **Booking System:** Users can make bookings for their desired accommodations directly through the website. The booking details, including the user's information, selected dates, and accommodation details, will be securely stored in a MySQL database.
* **User Authentication:** Implement a secure user authentication system to allow users to create accounts, log in, and manage their bookings. This ensures privacy and security for both users and their booking information. [WIP]

## Technologies Used

* [![Oracle.com]][Oracle-url]  
* [![Spring Boot]][Spring Boot-url]  
* [![Thymeleaf]][Thymeleaf-url]
* [![HTML]][HTML-url]
* [![CSS]][CSS-url] 
* [![MySQL]][MySQL-url] 

## Prerequisites

Before running this application, please ensure that you have the following prerequisites installed and set up on your local development environment:
* Java Development Kit (Requires JDK 11 or later)
* Apache Maven
* MySQL Database


## Getting Started

1. Clone the repository:

```
git clone https://github.com/jadrog05/PropertiesWebsite
```

2. Configure the database connection in src/main/resources/application.properties:

```
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
```

3. Build and run the application using Maven:

```
mvn spring-boot:run
```

4. Open a web browser and navigate to [http://localhost:8080](http://localhost:8080/index) to access the website.

## Contributors

[James Astell](https://github.com/AstellJ11)  
[Jaden Rogers](https://github.com/jadrog05)

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

## Acknowledgements

[Spring Boot Documentation](https://spring.io/projects/spring-boot)  
[Thymeleaf Documentation](https://www.thymeleaf.org/)

<!-- MARKDOWN LINKS & IMAGES -->
[Oracle.com]: https://img.shields.io/badge/Java-F80000?style=for-the-badge&logo=oracle&logoColor=white
[Oracle-url]: https://www.oracle.com
[Spring Boot]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring Boot-url]: https://spring.io/projects/spring-boot
[Thymeleaf]: https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white
[Thymeleaf-url]: https://www.thymeleaf.org
[HTML]: https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white
[HTML-url]: https://developer.mozilla.org/en-US/docs/Web/HTML
[CSS]: https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white
[CSS-url]: https://developer.mozilla.org/en-US/docs/Web/CSS
[MySQL]: https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://www.mysql.com
