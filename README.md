<h1 align="center">Restaurant Management System</h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java-17-darkblue.svg" />
  </a>
  <a href="Maven url">
    <img alt="Maven" src="https://img.shields.io/badge/Maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.2.2-brightgreen.svg" />
  </a>
</p>

---

<p align="left">

## Overview

The Restaurant Management System is a Spring Boot-based application that provides a set of CRUD (Create, Read, Update, Delete) operations for managing users, along with food items in a restaurant.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java 17
- **Database:** Postgres
- **Build Tool:** Maven

## Dependencies

The project utilizes the following dependencies:

- **Spring Boot Starter Data JPA**: Simplifies database access using Spring Data repositories.

- **Spring Boot Starter Web**: Provides support for building web applications, including RESTful APIs.

- **PostgreSQL Driver (Runtime Dependency)**: The PostgreSQL JDBC driver for connecting to PostgreSQL databases.

- **Project Lombok (Optional)**: A library for reducing boilerplate code, such as getters and setters.

- **Spring Boot Starter Test (For Testing)**: Provides support for testing Spring Boot applications.

- **Spring Boot Starter Validation**: Includes validation support for request data binding and response data rendering.

  

## Data Flow

### Controller

| Controller             | Functions Used                                                      |
|------------------------|---------------------------------------------------------------------|
| `CustomerController`   | - `createCustomer`: create a new customer user.<br/> - `getAllCustomers`: Get all customers.<br/> - `getCustomerById`: Get customer by his id.<br/> - `updateCustomer`: Update customer.<br/> - `deleteCustomer`: Delete customer.          |
| `MenuController`       | - `createMenu`: create a new menu.<br/> - `getAllMenus`: Get all menus.<br/> - `getMenuById`: Get menu by id.<br/> - `updateMenu`: Update menu.<br/> - `deleteMenu`: Delete menu.                                                           |
| `MenuItemController`   | - `createMenuItem`: create a new menu item.<br/> - `getAllMenuItems`: Get all menu items.<br/> - `getMenuItemById`: Get menu item by id.<br/> - `updateMenuItem`: Update menu item.<br/> - `deleteMenuItem`: Delete menu item.              |
| `RestaurantController` | - `createRestaurant`: create a new restaurant.<br/> - `getAllRestaurants`: Get all restaurant.<br/> - `getRestaurantById`: Get restaurant by id.<br/> - `updateRestaurant`: Update restaurant.<br/> - `deleteRestaurant`: Delete restaurant.|
| `ReviewController`     | - `createReview`: create a new review.<br/> - `getAllReviews`: Get all reviews.<br/> - `getReviewById`: Get review by id.<br/> - `updateReview`: Update review.<br/> - `deleteReview`: Delete review.                                       |

### Repository

| Repository             | Purpose                                    |
|------------------------|--------------------------------------------|
| `CustomerRepository`   | Access and manage customer users in the database. |
| `MenuRepository`       | Access and manage menus in the database.          |
| `MenuItemRepository`   | Access and manage menu items in the database.     |
| `RestaurantRepository` | Access and manage restaurants in the database.    |  
| `ReviewRepository`     | Access and manage reviews in the database.        |

## Database Design and Database Table

The database contains tables for customers, menus, menu items, restaurants, and reviews.

### Detailed Database Design

### Customer Table

| Column Name    | Data Type    | Description                                           |
| -------------- | ------------ | ----------------------------------------------------- |
| id             | BIGINT (PK)  | Unique identifier for each customer.                  |
| username       | VARCHAR(255) | Username of the customer.                             |
| email          | VARCHAR(255) | Email address of the customer.                            |

### Menu Table

| Column Name    | Data Type    | Description                                              |
| -------------- | ------------ | -----------------------------------------------------    |
| id             | BIGINT (PK)  | Unique identifier for each menu.                         |
| menu_name      | VARCHAR(255) | Name of the menu.                                        |
| restaurant_id  | BIGINT (FK)  | Foreign key referencing the restaurant who have the menu.|

### Menu Item Table

| Column Name    | Data Type    | Description                                               |
| -------------- | ------------ | -----------------------------------------------------     |
| id             | BIGINT (PK)  | Unique identifier for each menu item.                     |
| item_name      | VARCHAR(255) | Name of the item.                                         |
| description    | VARCHAR(255) | Description of the food item.                             |
| price          | DECIMAL(10,2)|	Price of the food item.                                   |
| menu_id        | BIGINT (FK)  | Foreign key referencing the menu who have the item.       |
| restaurant_id  | BIGINT (FK)  | Foreign key referencing the restaurant who have the item. |

### Restaurant Table

| Column Name    | Data Type    | Description                                               |
| -------------- | ------------ | -----------------------------------------------------     |
| id             | BIGINT (PK)  | Unique identifier for each restaurant.                    |
| restaurant_name| VARCHAR(255) | Name of the restaurant.                                   |
| cuisine        | VARCHAR(255) | Name of the cuisine.                                      |
| address        | VARCHAR(255) |	Location of the restaurant                                |
| phone_number   | VARCHAR(255) | number for contacting the restaurant                      |




## Data Structures Used in the Project


### Entity Classes

1. **User Entity**: This class represents the structure of user data in the database. It includes fields such as `id`, `username`, `password`, `email`, `role`, `is_signed_up`, `is_signed_in`, and `created_at`. These fields are mapped to corresponding columns in the User Table.

2. **Food Item Entity**: This class defines the structure for food item data in the database. It includes fields like `id`, `name`, `description`, `price`, and `type`. These fields are mapped to corresponding columns in the Food Item Table.

3. **Order Entity**: This class represents the structure of order data in the database. It includes fields such as `id`, `user`, `foodItem`, `status`, and `orderDate`. The `user` and `foodItem` fields are mapped as foreign keys to the User Table and Food Item Table, respectively.

### Data Transfer Object (DTO) Classes

1. **SignUpRequest**: This DTO class is used to encapsulate the data needed to sign up a new user. It includes fields for `username`, `password`, and `email`.

2. **SignInRequest**: This DTO class encapsulates the data required to sign in a user. It includes fields for `username` and `password`.

3. **FoodItemRequest**: This DTO class is used for adding a new food item to the system. It includes fields for `name`, `description`, `price`, and `type`.

4. **OrderRequest**: This DTO class represents the data needed to place a food order. It includes fields for `userId` and `foodItemId`.

5. **UserResponse**: This DTO class is used to send user-related information as a response. It includes fields for `id`, `username`, `email`, and `role`.

6. **FoodItemResponse**: This DTO class is used to send food item-related information as a response. It includes fields for `id`, `name`, `description`, `price`, and `type`.

7. **OrderResponse**: This DTO class is used to send order-related information as a response. It includes fields for `id`, `user` (containing user information), `foodItem` (containing food item information), `status`, and `orderDate`.

These data structures, both entity classes and DTO classes, are essential components of the project, defining the structure of data and requests/responses used in the system.

