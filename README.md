# 📦 MessageService (Kafka + Spring Boot)

## 🇬🇧 English

### 📌 Overview
MessageService is a simple event-driven microservice built with Spring Boot, Kafka, and PostgreSQL.  
It demonstrates a full flow: REST API → Database → Kafka Producer → Kafka Consumer with retry handling.

---

### 🏗️ Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- Apache Kafka
- PostgreSQL
- Lombok

---

### ⚙️ Architecture

REST API → Service → DB (PostgreSQL)  
                 ↓  
             Kafka Producer  
                 ↓  
             Kafka Topic (orders)  
                 ↓  
             Kafka Consumer  

---

### 🚀 Features
- Create orders via REST API
- Save orders in PostgreSQL
- Publish order events to Kafka
- Consume Kafka messages
- Retry mechanism using `@RetryableTopic`
- Dead Letter Topic support

---

### 📡 API

#### Create Order

`POST /orders`

Example request:
```json
{
  "orderId": "123",
  "product": "iPhone",
  "quantity": 2
}
````

---

### 🧠 Kafka Flow

* Topic: `orders`
* Consumer Group: `order-group`
* Retry enabled with 3 attempts
* Failed messages go to DLT topic

---

### 🛠️ How to Run

1. Start Kafka + Zookeeper
2. Start PostgreSQL
3. Run application:

```bash
mvn spring-boot:run
```

---

### 📊 Learning Goals

This project is designed to practice:

* Kafka producers & consumers
* Event-driven architecture
* Retry & error handling
* Spring Boot microservices basics

---

## 🇷🇺 Русский

### 📌 Описание

MessageService — это простой event-driven микросервис на Spring Boot, Kafka и PostgreSQL.
Реализует полный поток: REST API → БД → Kafka Producer → Kafka Consumer с retry.

---

### 🏗️ Стек технологий

* Java 21
* Spring Boot
* Spring Data JPA
* Apache Kafka
* PostgreSQL
* Lombok

---

### ⚙️ Архитектура

REST API → Service → PostgreSQL
↓
Kafka Producer
↓
Topic (orders)
↓
Kafka Consumer

---

### 🚀 Возможности

* Создание заказов через REST API
* Сохранение в базу данных
* Отправка событий в Kafka
* Чтение сообщений из Kafka
* Retry механизм через `@RetryableTopic`
* Dead Letter Topic (DLT)

---

### 📡 API

#### Создать заказ

`POST /orders`

Пример запроса:

```json
{
  "orderId": "123",
  "product": "iPhone",
  "quantity": 2
}
```

---

### 🧠 Kafka логика

* Топик: `orders`
* Consumer group: `order-group`
* 3 попытки retry
* Ошибочные сообщения уходят в DLT

---

### 🛠️ Запуск проекта

1. Запустить Kafka и Zookeeper
2. Запустить PostgreSQL
3. Запустить приложение:

```bash
mvn spring-boot:run
```

---

### 📊 Цель проекта

Проект создан для практики:

* Kafka producer/consumer
* Event-driven архитектуры
* Retry и обработка ошибок
* Базовый микросервисный дизайн
