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

### Review Table

| Column Name    | Data Type    | Description                                                  |
| -------------- | ------------ | -----------------------------------------------------        |
| id             | BIGINT (PK)  | Unique identifier for each review.                           |
| content        | VARCHAR(255) | Content of the review.                                       |
| rating         | DOUBLE       | rate of the restaurant.                                      |
| restaurant_id  | BIGINT (FK)  |	Foreign key referencing the restaurant that have the review. |
| customer_id    | BIGINT (FK)  | Foreign key referencing the customer who wrote the review.   |


## Data Structures Used in the Project


### Entity Classes

1. **Customer Entity**: This class represents the structure of customer data in the database. It includes fields such as `id`, `customerName`, `customerEmail`. These fields are mapped to corresponding columns in the Customer Table.

2. **Menu Entity**: This class defines the structure for menu data in the database. It includes fields like `id`, `menuName`. These fields are mapped to corresponding columns in the Menu Table.

3. **Menu Item Entity**: This class represents the structure of menu item data in the database. It includes fields such as `id`, `name`, `description`, `price`. The `menu` and `restaurant` fields are mapped as foreign keys to the Menu Table and Restaurant Table, respectively.

4. **Restaurant Entity**: This class represents the structure of restaurant data in the database. It includes fields such as `id`, `restaurantName`, `cuisine`, `address`, `phoneNumber`.

5. **Review Entity**: This class represents the structure of review data in the database. It includes fields such as `id`, `content`, `rating`, `address`, `phoneNumber`.
   The `restaurant` and `customer` fields are mapped as foreign keys to the Restaurant Table and Customer Table, respectively.


### Data Transfer Object (DTO) Classes

1. **CreateReviewRequest**: This DTO class is used to encapsulate the data needed to create a request. It includes fields for `content`, `rating`, and `customer`.

2. **DinnerMenuItemRequest**: This DTO class encapsulates the data required to send a request to add menu item to menu. It includes fields for `name`, `description`, `price`, `menu`.

These data structures, both entity classes and DTO classes, are essential components of the project, defining the structure of data and requests/responses used in the system.

<br/>


1. **Customer Entity**: Represents customer data in the database.

```java
@Data
@Entity
@Table(
        name = "customer"
)
public class Customer {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

   @Column(
            name = "username",
            nullable = false
    )
    private String customerName;

   @Column(
            name = "email",
            nullable = false
    )
    private String customerEmail;
}
```

2. **Menu Entity**: Represents menu data in the database.

```java
@Data
@Entity
@Table(
        name = "menu"
)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "menu_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String menuName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "restaurant_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "restaurant_menu_fk"
            )
    )
    private Restaurant restaurant;
}
```

3. **Menu Item Entity**: Represents menu item data in the database.

```java
@Data
@Entity
@Table(
        name = "menu_item"
)
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "item_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Enumerated(EnumType.STRING)
    private DinnerMenu menuType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "menu_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "menu_item_fk"
            )
    )
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "restaurant_id",
//            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "restaurant_menu_item_fk"
            )
    )    private Restaurant restaurant;
}
```

4. **Restaurant Entity**: Represents restaurant data in the database.

```java
@Data
@Entity
@Table(
        name = "restaurant"
)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "restaurant_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String restaurantName;

    @Column(
            name = "cuisine",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String cuisine;

    @Column(
            name = "address",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String address;

    @Column(
            name = "phone_number",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(
            mappedBy = "restaurant",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Menu> menuList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "restaurant",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Review> reviews = new ArrayList<>();
}
```
5. **Review Entity**: Represents review data in the database.

```java
@Data
@Entity
@Table(
        name = "review"
)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "content",
            nullable = false
    )
    private String content;

    @Column(
            name = "rating",
            nullable = false
    )
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "restaurant_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "restaurant_review_fk"
            )
    )
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_review_fk"
            )
    )
    private Customer customer;

}
```

### Data Transfer Object (DTO) Classes

1. **CreateReviewRequest**: Represents the data needed to create a review.

```java
@Data
public class CreateReviewRequest {

    private String content;
    private Double rating;
    private Customer customer;
}
```

2. **DinnerMenuItemRequest**: Represents the data needed to create a menu item.

```java
@Data
public class DinnerMenuItemRequest {

    private String name;
    private String description;
    private Double price;
    private Menu menu;
}
```

## Project Summary

The Restaurant Management System is a Spring Boot-based application that provides functionality for managing users, food items, and orders. The project uses a PostgreSQL database to store data. It offers RESTful API endpoints for user registration, and food menu retrieval.
