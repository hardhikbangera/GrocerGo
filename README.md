# Food Delivery Website

A full-stack food delivery platform built with **React** (frontend), **Spring Boot** (backend), and **MySQL** (database).

## Features

- User-friendly interface for browsing food items, selecting weight/quantity, and adding to cart
- Customer registration and order placement
- Dynamic order summary and checkout
- Admin APIs for menu/item management
- RESTful backend with robust data models for customers, orders, and items
- Easily customizable for new features or business requirements

## Tech Stack

- **Frontend:** React (with Context API for cart management)
- **Backend:** Spring Boot (with REST API, Spring Data JPA)
- **Database:** MySQL

## Getting Started

### Prerequisites

- Node.js and npm
- Java (JDK 25 recommended)  
- MySQL server

### Running the Application

#### 1. Clone the repository

```bash
git clone https://github.com/hardhikbangera/GrocerGo
cd backend
```

#### 2. Setup the Backend

```bash
cd backend
# Edit src/main/resources/application.properties with your DB credentials
mvn spring-boot:run
```

#### 3. Setup the Frontend

```bash
cd frontend
npm install
npm start
```

- Frontend runs at `http://localhost:3000`
- Backend REST API runs at `http://localhost:8080/api`

## Project Structure

```
/backend        # Spring Boot REST API
/frontend       # React frontend app
```

## Database Schema

- **customer_details**: stores customer info, status, etc
- **item_details**: stores menu items and prices
- **order_items**: stores individual order lines

***

## Future Enhancements

1. User Authentication & Authorization (Spring Security)  
2. Payment Processing Integration

***
Feel free to add sections on:
- Deployment (Docker, Render, Heroku, etc)
- API Endpoints (if you want a table of endpoints)
- Contributors/Acknowledgments
