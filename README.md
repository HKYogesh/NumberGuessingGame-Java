# Number Guessing Game

A simple console-based Java application where players guess numbers and earn rewards. Player details and game history are managed with Hibernate JPA and stored in a MySQL database.

---

## Project Structure

NumberGuessingGame-Java/
│
├── src/
│   └── Numberguess/demo/
│       ├── MainClass.java
│       └── PlayerDetails.java
│
├── src/META-INF/
    └── persistence.xml


---

## Features

- **User Management:** Collects player name, age, and contact number  
- **Game Logic:** System generates 3 random digits; player guesses each one  
- **Result Processing:** Calculates earnings for correct guesses and stores results  
- **Data Management:** Stores, views, and deletes player data using Hibernate JPA  

---

## Tech Stack

- **Java** 
- **Hibernate**  
- **MySQL** (Database)  

---

## Sample Console Menu

1. Play the Game  
2. Check the Result  
3. Delete the History  
4. Exit  
