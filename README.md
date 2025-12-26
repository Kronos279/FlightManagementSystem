# AetherWings: Distributed Flight Management System

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)
![Architecture](https://img.shields.io/badge/Architecture-Event%20Driven%20Microservices-blue)
![RabbitMQ](https://img.shields.io/badge/Messaging-RabbitMQ-orange)

## 📡 System Overview
**AetherWings** is a high-availability distributed system designed to handle concurrent flight booking transactions. It utilizes a **Microservices Architecture** to decouple domain logic, ensuring independent scalability of the booking engine, flight search, and user management modules.

The system addresses **Distributed Data Consistency** challenges by employing an event-driven pattern (RabbitMQ) for non-blocking communication and a hybrid persistence layer (MySQL for ACID transactions, MongoDB for high-read catalogs).



[Image of microservices architecture diagram]


## 🏗 Microservices Architecture
The ecosystem is composed of 5 core microservices orchestrated via **Spring Cloud Gateway** and **Netflix Eureka**:

| Service Name | Port | Responsibility | Tech Stack |
| :--- | :--- | :--- | :--- |
| **API Gateway** | `8080` | Edge server acting as the single entry point. Handles routing, load balancing, and rate limiting. | Spring Cloud Gateway |
| **Discovery Server** | `8761` | Service registry allowing dynamic discovery of service instances. | Netflix Eureka |
| **Auth Service** | `8081` | Centralized identity management and security. Issues and validates **JWT** tokens. | Spring Security, MySQL |
| **Flight Service** | `8082` | Manages flight inventory, routes, and scheduling. Optimized for high-volume read operations. | MongoDB (NoSQL) |
| **Booking Service** | `8083` | The core transactional engine. Handles reservations, seat locking, and payment processing. | MySQL (ACID), RabbitMQ |
| **Notification Service** | `N/A` | Asynchronous event consumer that listens for booking confirmations to trigger user alerts. | RabbitMQ Listener |

## 🚀 Key Engineering Features

### 1. Event-Driven Consistency (RabbitMQ)
To decouple high-latency operations from the critical booking path, the system uses asynchronous messaging:
* **Producer:** `BookingService` publishes a `BookingPlacedEvent` to the `notification.exchange` upon transaction commit.
* **Consumer:** `NotificationService` listens to the queue to trigger emails/SMS.
* **Benefit:** Reduces API latency and prevents distributed transaction failures from blocking user feedback.

### 2. Hybrid Database Strategy (Polyglot Persistence)
* **Transactional Integrity:** **MySQL** is used for the `Booking` service to strictly enforce ACID properties, preventing double-booking scenarios.
* **Scalable Reads:** **MongoDB** is used for the `Flight` service to handle complex queries against unstructured flight metadata.

### 3. Distributed Resilience
* **Circuit Breakers:** Implemented using **Resilience4j** to handle downstream failures gracefully and prevent cascading system outages.
* **Load Balancing:** Client-side load balancing via Spring Cloud LoadBalancer ensures even traffic distribution across service instances.

---
*Author: Ashutosh Yadav*
