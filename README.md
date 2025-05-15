# 🎯 Equipment Management System

A robust and secure Equipment Management System for institutions, built using Java, Spring Boot, Spring Security (JWT), and PostgreSQL.

---

## 🚀 Features

### ✅ User Management
- Role-based access: `ADMIN`, `STAFF`
- User registration and login (JWT authentication)
- Admin manages users and equipment
- Staff can request and return equipment

### 🛠 Equipment Inventory
- Add, update, and view equipment
- Equipment statuses: `Available`, `In Use`, `Maintenance`
- Track quantity and location

### 📥 Equipment Allocation
- Staff submit allocation requests
- Admin approves or rejects
- Request includes purpose, duration, and requester info

### 🔄 Return & Condition Reporting
- Staff return equipment and report condition (`Good`, `Damaged`, etc.)
- Status and quantity automatically updated

### 📜 Audit Logging with Database Trigger
- PostgreSQL trigger logs all approved equipment allocations
- Logs include equipment ID, user, datetime, and status

---

## 🧱 Tech Stack

| Layer        | Technology                    |
|--------------|-------------------------------|
| Backend      | Java, Spring Boot             |
| Security     | Spring Security with JWT      |
| ORM          | Spring Data JPA               |
| Database     | PostgreSQL                    |
| Build Tool   | Maven                         |

---

## 🗃️ Database Schema

### Tables:
- `users(id, name, email, password, role)`
- `equipment(id, name, type, quantity, status, location)`
- `requests(id, user_id, equipment_id, purpose, request_date, status)`
- `returns(id, request_id, return_date, condition)`
- `allocation_logs(id, equipment_id, user_id, allocated_at, action)`

### Trigger:
PostgreSQL trigger logs every approved equipment allocation.

---

## 🔐 Authentication & Authorization

- JWT-based stateless authentication
- Endpoints protected by role (`ADMIN`, `STAFF`)
- Token required for accessing protected routes

---

## 📫 API Endpoints

### Auth
| Method | Endpoint         | Description       |
|--------|------------------|-------------------|
| POST   | `/auth/register` | Register user     |
| POST   | `/auth/login`    | Login and get JWT |

### Equipment
| Method | Endpoint         | Description          | Role   |
|--------|------------------|----------------------|--------|
| GET    | `/equipment/all` | View all equipment   | All    |
| POST   | `/equipment/add` | Add equipment        | ADMIN  |
| PUT    | `/equipment/{id}`| Update equipment     | ADMIN  |

### Requests
| Method | Endpoint     | Description             | Role   |
|--------|--------------|-------------------------|--------|
| POST   | `/request`   | Request equipment       | STAFF  |
| GET    | `/requests`  | View all requests       | ADMIN  |
| PUT    | `/request/{id}/approve` | Approve request | ADMIN  |
| PUT    | `/request/{id}/reject`  | Reject request  | ADMIN  |

### Returns
| Method | Endpoint     | Description             | Role   |
|--------|--------------|-------------------------|--------|
| POST   | `/return`    | Return equipment        | STAFF  |

---

## ▶️ Running Locally

### 🧰 Prerequisites
- Java 17+
- PostgreSQL
- Maven

### 🏗 Setup Steps
1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/equipment-management-system.git
   cd equipment-management-system
