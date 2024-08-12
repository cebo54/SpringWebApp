## Social Media Platform
This repository contains a social media platform developed using Spring Boot for the backend, React for the frontend, MySQL for the database, and JSON Web Token (JWT) for authentication. The platform was developed over a period from August 2023 to September 2023.

## Project Overview
This social media platform allows users to create posts, like posts, and comment on posts. All interactions are securely stored in a MySQL database, and user authentication is managed through JWT to ensure that only registered users can access the platform's features.

## Key Features
### User Authentication:

Users must register with a username and password.
Authentication is managed via JWT, ensuring secure access to the platform.
### Posts:

Users can create posts that are visible to other users on the platform.
Each post is recorded in the database and can be interacted with by other users.
### Likes:

Users can like posts.
The like action is recorded in the database, and the number of likes is visible to all users.
### Comments:

Users can comment on posts.
Comments are recorded in the database, and all users can view the comments on each post.
### Database Integration:

All data, including users, posts, likes, and comments, is stored in a MySQL database.
The database is designed to efficiently handle the relationships between users, posts, likes, and comments.
## Technologies Used
* Backend: Spring Boot
* Frontend: React
* Database: MySQL
* Authentication: JSON Web Token (JWT)
* Build Tool: Maven
* Installation and Setup
### Clone the Repository:
```
git clone https://github.com/your-username/social-media-platform.git
```
### Backend Setup:

* Navigate to the backend directory.
Configure the application.properties file with your MySQL database details.
* Run the Spring Boot application using Maven:
```
mvn spring-boot:run
```
### Frontend Setup:

Navigate to the frontend directory.
* Install the required dependencies:

```
npm install
```
* Start the React application:
```
npm start
```
* Access the Platform:

Once both the backend and frontend are running, you can access the platform by navigating to http://localhost:3000 in your web browser.
### Usage
* Registration:
Navigate to the registration page and create an account with a username and password.
* Login:
After registration, log in using your credentials to access the platform.
* Creating Posts:
Once logged in, you can create posts that will be visible to other users.
* Interacting with Posts:
You can like or comment on posts made by other users.
* Viewing Interactions:
All users can view the likes and comments on each post.
### Future Enhancements
* Adding user profiles with the ability to upload profile pictures.
* Implementing a search feature to find specific users or posts.
* Adding real-time notifications for likes and comments.
* Enhancing the UI/UX with additional design improvements.
## Author
* Name: Cebrail Kaya
* Date: August 2023 – September 2023
