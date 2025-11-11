# Event Management System

A RESTful API built with Spring Boot for managing events and bookings with role-based access control.

## Features

### Admin Capabilities
- Add new events
- Update existing events
- Delete events

### User Capabilities
- Browse all events with pagination and sorting
- Search events by name
- View event details
- Book event tickets
- Cancel bookings

## Technology Stack

- **Framework**: Spring Boot
- **Security**: Spring Security (Basic Authentication)
- **Database**: MySQL
- **ORM**: Spring Data JPA (Hibernate)
- **Dependencies**: Lombok

## Project Structure

```
src/main/java/com/spring/eventmanagementsystem/
├── controller/
│   ├── AdminController.java
│   └── UserController.java
├── entities/
│   ├── Event.java
│   ├── Booking.java
│   └── BookingStatus.java
├── repository/
│   ├── EventsRepository.java
│   └── BookingRepository.java
├── service/
│   ├── EventsService.java
│   ├── EventsServiceImpl.java
│   ├── BookingService.java
│   └── BookingServiceImpl.java
└── security/
    └── SecurityConfig.java
```

## Prerequisites

- Java 17 or higher
- Maven
- MySQL

## Setup Instructions

### 1. Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE event_management;
```

### 2. Application Properties

Update `src/main/resources/application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/event_management
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Authentication

The system uses Basic Authentication with in-memory users:

| Username | Password | Role |
|----------|----------|------|
| admin | admin123 | ADMIN |
| user | user123 | CUSTOMER |

## API Endpoints

### Admin Endpoints (Requires ROLE_ADMIN)

#### Add Event
```http
POST /events/admin/add
Authorization: Basic admin:admin123
Content-Type: application/json

{
  "eventId": 1,
  "eventName": "Spring Conference",
  "eventDescription": "Annual Conference",
  "eventDate": "2024-12-15",
  "ticketPrice": 99.99,
  "availableSeats": 200
}
```

#### Update Event
```http
PUT /events/admin/update/{eventId}
Authorization: Basic admin:admin123
Content-Type: application/json
```

#### Delete Event
```http
DELETE /events/admin/delete/{eventId}
Authorization: Basic admin:admin123
```

### User Endpoints (Requires ROLE_ADMIN or ROLE_CUSTOMER)

#### Get All Events
```http
GET /events/user/all?page=0&size=5&sortBy=price&ascending=true
Authorization: Basic user:user123
```

**Query Parameters:**
- `page` (default: 0)
- `size` (default: 5)
- `sortBy` (default: price)
- `ascending` (default: true)

#### Get Event by ID
```http
GET /events/user/{eventId}
Authorization: Basic user:user123
```

#### Search Event by Name
```http
GET /events/user/search?eventName=Spring Conference
Authorization: Basic user:user123
```

#### Book Event
```http
POST /events/user/book
Authorization: Basic user:user123
Content-Type: application/json

{
  "bookingId": 1,
  "userId": 101,
  "eventId": 1,
  "numOfSeats": 2,
  "totalPrice": 199.98,
  "bookingStatus": "CONFIRMED"
}
```

#### Cancel Booking
```http
GET /events/user/cancel/{bookingId}
Authorization: Basic user:user123
```

## Data Models

### Event
- `eventId` (int)
- `eventName` (String)
- `eventDescription` (String)
- `eventDate` (String)
- `ticketPrice` (double)
- `availableSeats` (int)

### Booking
- `bookingId` (int)
- `userId` (int)
- `eventId` (int)
- `numOfSeats` (int)
- `totalPrice` (double)
- `bookingStatus` (BookingStatus)

### BookingStatus Enum
- `NOT_PAID`
- `CANCELLED`
- `CONFIRMED`

## Security Configuration

- CSRF is disabled
- Basic Authentication enabled
- `/events/admin/**` requires ROLE_ADMIN
- `/events/user/**` requires ROLE_ADMIN or ROLE_CUSTOMER
- Custom authentication entry point returns 404 for unauthorized access

## Testing

```bash
mvn test
```
