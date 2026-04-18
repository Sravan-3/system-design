# 🚀 Microservices App (Spring Boot + Docker + API Gateway)

## 📌 Overview

This project demonstrates a **microservices architecture** with:

* API Gateway (Spring Cloud Gateway)
* Order Service
* Payment Service
* Inventory Service
* Docker-based deployment

---

## 🧱 Architecture

Client → API Gateway → Order Service → (Payment + Inventory)

---

## ⚙️ Tech Stack

* Java 21
* Spring Boot 3.4.x
* Spring Cloud Gateway
* Docker & Docker Compose
* Maven

---

## 📁 Project Structure

```
microservices-app/
│
├── api-gateway/
├── order-service/
├── payment-service/
├── inventory-service/
├── docker-compose.yml
```

---

## 🛠️ Prerequisites

Make sure you have installed:

```bash
java -version   # Java 21
mvn -v          # Maven
docker -v       # Docker
docker-compose -v
```

---

## 🔨 Step 1: Build All Services

From project root:

```bash
cd api-gateway && mvn clean package -DskipTests && cd ..
cd order-service && mvn clean package -DskipTests && cd ..
cd payment-service && mvn clean package -DskipTests && cd ..
cd inventory-service && mvn clean package -DskipTests && cd ..
```

---

## 🐳 Step 2: Run Using Docker

```bash
docker-compose up --build
```

Run in background:

```bash
docker-compose up -d
```

---

## 📊 Step 3: Verify Containers

```bash
docker ps
```

You should see:

* gateway
* order
* payment
* inventory

---

## 🌐 Step 4: Test API

```bash
curl http://localhost:8080/order
```

### ✅ Expected Output

```
Order Success -> Payment Done | Stock Reserved
```

---

## 🔁 Request Flow

```
Client
  ↓
Gateway (8080)
  ↓
Order Service (8081 - internal)
  ↓
Payment Service (8082 - internal)
Inventory Service (8083 - internal)
```

---

## 🧪 Debugging

### Check logs

```bash
docker logs gateway
docker logs order
docker logs payment
docker logs inventory
```

---

### Stop services

```bash
docker-compose down
```

---

## ⚠️ Notes

* Only **API Gateway is exposed** to host (`localhost:8080`)
* Other services are internal (Docker network)
* This is how real microservices are deployed

---

## 🎯 Summary

This project demonstrates:

* Microservices architecture
* API Gateway routing
* Service-to-service communication
* Dockerized deployment

---

