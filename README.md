# Codecool shop
Codecool Shop is a e-commerce type web application where users can browse and buy various items.

## Technologies
- Java
- JS
- CSS
- HTML
- JS
- Thymeleaf
- Maven

## About the project
- It uses in memory storage for data
- HttpServlets for handling requests
- We have a base HTML for the main page and the filtered contents are handled with Thymeleaf fragments
- The cart "remove item" button uses JS to send a http request to the server and then refreshes

## Overview
- Mainpage with category and supplier filters<br/>
![Image](https://i.imgur.com/Li6WlY1.png)<br/>

- Cart modal<br/>
![Image](https://i.imgur.com/2AQCF9Z.png)<br/>

- Checkout page<br/>
![Image](https://i.imgur.com/0ssX0qb.png)<br/>

- Payment page<br/>
![Image](https://i.imgur.com/tDmZhrr.png)<br/>

- Purchase overview page<br/>
![Image](https://i.imgur.com/phCmPVo.png)<br/>

## Getting started!
- Install Open JDK
Make sure that the latest LTS (Long Term Support) at least Open Java Development Kit (JDK) is installed on your system.
Executing the java --version command in the shell shows at least the latest LTS version number.
- Install an IDE that supports Maven and Java
This project was developed in IntelliJ IDEA Ultimate
- Clone the repo to your local machine
You can do that by running the following command in your terminal, make sure you are in the right directory.
```git clone https://github.com/github_username/repo_name.git```
- Open the project in your IDE (Maven projects are opened by opening the pom.xml file as a project) and run the maven jetty:run command in the terminal or in IntelliJ configure the Run/Debug command line parameter as "jetty:run"
- Write ```0.0.0.0:8080``` in your address bar and press enter. That's it!
