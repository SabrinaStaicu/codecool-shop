# Codecool shop

<summary><h2 style="display: inline-block">Table of Contents</h2></summary>
<ol>
 <li>
    <a href="#intro">Intro</a>
</li>
<li>
    <a href="#technologies">Technologies</a>
</li>
<li>
    <a href="#about-the-project">About The Project</a>
</li>
<li>
    <a href="#overview">Overview</a>
</li>
  <li>
    <a href="#getting-started">Getting Started</a>
</li>
</ol>

## Intro
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
1. Install Open JDK
Make sure that the latest LTS (Long Term Support) at least Open Java Development Kit (JDK) is installed on your system.
Executing the java --version command in the shell shows at least the latest LTS version number.

2. Install an IDE that supports Maven and Java
This project was developed in IntelliJ IDEA Ultimate

3. Clone the repo to your local machine
You can do that by running the following command in your terminal, make sure you are in the right directory.
```git clone https://github.com/github_username/repo_name.git```

4. Open the project in your IDE (Maven projects are opened by opening the pom.xml file as a project) and run the maven jetty:run command in the terminal or in IntelliJ configure the Run/Debug command line parameter as "jetty:run"

5. Write ```0.0.0.0:8080``` in your address bar and press enter. That's it!
