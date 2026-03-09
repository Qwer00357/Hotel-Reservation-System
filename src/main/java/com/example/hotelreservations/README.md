# Hotel Reservation System (Java Spring Boot)

## Overview

This project is a backend REST API for a **Hotel Reservation System** built with **Java and Spring Boot**.

It allows hotels to manage:

* Guests
* Rooms
* Reservations

The system demonstrates concepts:

* REST API development
* CRUD operations
* Entity relationships
* Business logic validation

This project was created as part of my backend developer portfolio.

---

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Maven
* Postman (API testing)

---

## Features

### Guest Management

* Create new guests
* Retrieve guest list
* Delete guests

### Room Management

* Add rooms
* View all rooms

### Reservation System

* Create reservations
* Prevent double bookings
* Track reservation status
* Link reservations to guests and rooms

---

## Example API Endpoints

### Guests

GET /api/guests

POST /api/guests

GET /api/guests/{id}

DELETE /api/guests/{id}

### Rooms

GET /api/rooms

POST /api/rooms


### Reservations

POST /api/reservations
GET /api/reservations
GET /api/reservations/{id}

---

## Running the Project

Clone the repository

git clone https://github.com/Qwer00357/hotel-reservation-system.git

Navigate to the project folder

cd src\main\java\com\example\hotelreservations

Run the project

./mvnw spring-boot:run

The API will start on

http://localhost:8080