# GrocerGo


A full-stack Grocery delivery website built with **React** (frontend), **Spring Boot** (backend), and **MySQL** (database).

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

Frontend(React)
```
/components
    ├── Cart.css
    ├── Cart.jsx
    ├── Checkout.css
    ├── Checkout.jsx
    ├── FoodItemCard.css
    ├── FoodItemCard.jsx
    ├── Navbar.css
    ├── Navbar.jsx
/context
    ├── CartContext.jsx
/pages
    ├── Home.css
    ├── Home.jsx
/services
    ├── api.js
App.css
App.jsx
index.js
```
Backend(Java)
```
src/main/java/com.food
    ├── BackendApplication.java
    ├── config
    │   ├── DataLoader.java
    │   └── WebConfig.java
    ├── Controller
    │   ├── Customer_detailsController.java
    │   ├── Item_detailsController.java
    │   └── Order_itemsController.java
    ├── dto
    │   ├── Cart_itemDTO.java
    │   └── Customer_detailsDTO.java
    ├── model
    │   ├── Customer_details.java
    │   ├── Item_details.java
    │   └── Order_items.java
    ├── Repository
    │   ├── Customer_detailsRepository.java
    │   ├── Item_detailsRepository.java
    │   └── Order_itemsRepository.java
    └── Service
        ├── Customer_detailsService.java
        ├── Item_detailsService.java
        └── Order_itemsService.java

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
