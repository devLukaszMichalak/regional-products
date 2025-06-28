# Regional Products

A web application designed to catalog regional products across Polish voivodeships.

## Technologies

### Backend
- **Spring Boot 3.4.3** - Modern Java framework for building enterprise-grade applications
- **Java 21** - Latest LTS version of Java
- **Spring Security** - Robust authentication and authorization framework
- **Spring Data JPA** - Data access layer with JPA implementation
- **Hibernate** - ORM framework with SQLite dialect support
- **Spring AOP** - Aspect-oriented programming for cross-cutting concerns
- **Spring Cache** - Caching support for improved performance
- **Spring Validation** - Data validation framework
- **Spring Actuator** - Production-ready features for monitoring and management

### Frontend
- **Thymeleaf** - Modern server-side Java template engine
- **Bootstrap** - Responsive frontend framework
- **JavaScript** - Client-side interactivity

### Database
- **SQLite** - Lightweight, serverless database engine
- **Hibernate Community Dialects** - SQLite dialect support

### Additional Tools
- **Apache POI** - Excel file processing
- **PDFBox** - PDF generation and manipulation
- **EasyTable** - PDF table generation
- **Lombok** - Java annotation processor for reducing boilerplate code
- **Apache Tika** - Content type detection and extraction
- **Google Java Format** - Code style enforcement
- **Spotless** - Code formatting and style enforcement
- **Maven** - Build automation and dependency management


## Features

- **User Authentication & Authorization**
  - Secure login system with BCrypt password encryption
  - Session management
  - User registration with validation
  - CSRF protection

- **Data Management**
  - Docx and PDF file export capabilities
  - Product categorization by voivodeship
  - Product type classification
  - Date of entry tracking
  - Transaction management for data integrity

- **Performance Optimization**
  - Caching implementation for frequently accessed data
  - Efficient database queries
  - Optimized resource handling
  - Lazy loading of heavy services

- **Product Rating System**
  - Interactive 5-star rating interface with validation and half star precision
  - User-specific ratings (one rating per user per product)
  - Rating display in product listings and exports

- **Statistics & Analytics**
  - Daily visit tracking per voivodeship
  - Product count statistics
  - Total product aggregation
  - AOP-based statistics collection

- **Error Handling & Security**
  - Global exception handling
  - Custom error pages
  - Input validation

- **Internationalization & Localization**
  - Full Polish and English language support
  - Dynamic language switching
  - Language-specific error messages and UI
  - Multi-language document generation
  - Language-aware routing and navigation

- **Database Design**
  - Strict SQLite mode for enhanced data integrity
  - Comprehensive data validation constraints
  - Foreign key relationships with cascading effects
  - Unique constraints for data consistency
  - Automatic timestamp management
  - Efficient indexing strategy

### App preview

https://github.com/user-attachments/assets/8c8d58a2-f4ae-49fd-9dd7-40779aa94e7c

### Login update

https://github.com/user-attachments/assets/1428d51f-10e0-4636-95f2-1840f27b7be5

## Running with Docker

### Prerequisites
- Docker and Docker Compose installed on your system

### Using Docker Compose (Recommended)
1. Clone the repository
2. Navigate to the project directory
3. Run the application using Docker Compose:
   ```
   docker compose up
   ```
4. Access the application at http://localhost:8080