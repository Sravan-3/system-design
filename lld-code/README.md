# Java Low-Level Design (LLD)

This project contains **hands-on Java implementations of Low-Level Design (LLD) concepts and design patterns**.  
The goal is to understand **how patterns are written in real code**, not just theory.

Each example focuses on:
- Clear class responsibilities
- Proper use of OOP principles
- Practical application of design patterns

---

## 📂 Project Contents

This repository includes **example implementations** of common LLD patterns, such as:

- **Creational Patterns**
  - Singleton
  - Factory Method
  - Abstract Factory
  - Builder
  - Prototype

- **Structural Patterns**
  - Adapter
  - Bridge
  - Composite
  - Decorator
  - Facade
  - Flyweight
  - Proxy

- **Behavioral Patterns**
  - (Yet to start)
  

Each pattern is implemented with:
- Minimal but clear classes
- A `Demo` class to show usage
- Focus on readability and intent

This project intentionally avoids frameworks to keep the design **explicit and easy to reason about**.

---

## 🎯 Purpose

- Practice LLD for interviews (SDE-1 / SDE-2)
- Learn how patterns look in **real Java code**
- Understand object creation, composition, and interaction
- Build strong intuition for design trade-offs

---

Gotcha 👍 — this is mostly a **formatting + structure** issue. Here’s a **clean, readable, README-quality Markdown version** that will look good on GitHub.

---

## 📦 Build & Run

This project uses **plain Java compilation** to keep the build process simple and transparent.

### 🔧 Compile and Run

#### 🐧 Linux / macOS / Git Bash

```bash
javac -d build *.java && java -cp build Demo
```

#### 🪟 Windows (PowerShell)

```powershell
javac -d build *.java; java -cp build Demo
```

---

