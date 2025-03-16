# Event Management System

## Overview
The **Event Management System** is a web-based application built using **Spring Boot** following the **MVC (Model-View-Controller) pattern**. It allows users to browse, search, book, and cancel events while providing administrative functionalities to manage event records.

## Features
### User Features:
- View all available events with pagination and sorting.
- Search for events by name.
- Book an event.
- Cancel a booked event.

### Admin Features:
- Add new events.
- Update existing event details.
- Delete an event.
- Secure access to admin functionalities.

### Security Features:
- Uses **Spring Security** for authentication and authorization.
- Implements **role-based access control (RBAC)** for users (`CUSTOMER`) and administrators (`ADMIN`).
- Uses **Basic Authentication** for API security.

## Tech Stack
- **Java** (Spring Boot, Spring MVC, Spring Security)
- **Spring Data JPA** (for database interactions)
- **H2 / MySQL** (Database, configurable)
- **Spring Boot Security** (Authentication & Authorization)
- **RESTful APIs** (for client-server communication)

## Project Structure
```
com.spring.eventmanagementsystem
│── controller
│   ├── UserController.java
│   ├── AdminController.java
│── entities
│   ├── Event.java
│   ├── Booking.java
│── service
│   ├── EventsService.java
│   ├── BookingService.java
│── security
│   ├── SecurityConfig.java
│── repository
│   ├── EventRepository.java
│   ├── BookingRepository.java
│── EventManagementSystemApplication.java
```

## API Endpoints
### User Controller (`/events`)
| HTTP Method | Endpoint              | Description |
|------------|----------------------|-------------|
| GET        | `/events/all`        | Get all events with pagination and sorting |
| GET        | `/events/{eventId}`  | Get event details by ID |
| GET        | `/events/search`     | Search for an event by name |
| POST       | `/events/book`       | Book an event |
| GET        | `/events/cancel/{bookingId}` | Cancel a booked event |

### Admin Controller (`/events/admin`)
| HTTP Method | Endpoint              | Description |
|------------|----------------------|-------------|
| POST       | `/events/admin/add`   | Add a new event |
| PUT        | `/events/admin/update/{eventId}` | Update event details |
| DELETE     | `/events/admin/delete/{eventId}` | Delete an event |

## Security Configuration
- **Role-Based Access Control (RBAC)**:
  - Admin users can manage events (`ADMIN` role required for `/events/admin/**` routes).
  - Customers can book and view events (`CUSTOMER` role required for `/events/user/**` routes).
- **Basic Authentication** is used for user login.
- Default credentials (can be changed in `SecurityConfig`):
  - **Admin**: `admin / admin123`
  - **User**: `user / user123`

## Getting Started
### Prerequisites
- **Java 17+**
- **Maven**
- **Spring Boot**

### Steps to Run Locally
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/event-management-system.git
   cd event-management-system
   ```
2. Install dependencies:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```
4. Access API endpoints using Postman or any REST client.

## Future Enhancements
- Implement a frontend with React or Angular.
- Add email notifications for bookings.
- Integrate a payment gateway for paid events.
- Deploy to AWS or other cloud services.

## Author
**Swadesh Chatterjee**

