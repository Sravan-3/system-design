
---

# Mediator Pattern — Notes (LLD / SDE-1)

![Image](https://upload.wikimedia.org/wikipedia/commons/9/92/W3sDesign_Mediator_Design_Pattern_UML.jpg)

![Image](https://www.softwareideas.net/i/DirectImage/1492/Mediator)

---

## What is the Mediator Pattern?

> **Mediator Pattern defines a central object that encapsulates how a set of objects interact, so that they don’t communicate directly with each other.**

**Key idea:**
👉 Objects talk to **Mediator**, not to each other
👉 This **reduces tight coupling**

---

## Why do we need Mediator?

### Problem without Mediator

* Each object directly references others
* Too many dependencies
* Small change → many classes break
* Logic becomes scattered

Example (bad design):

```
Alice → Bob
Alice → Charlie
Bob → Alice
Charlie → Bob
```

This is **tight coupling**.

---

## Core Idea of Mediator

Replace **many-to-many communication** with **one-to-many via mediator**.

```
Alice
   ↘
    ChatMediator
   ↗     ↖
 Bob     Charlie
```

---

## Components in Mediator Pattern

| Component            | Responsibility                        |
| -------------------- | ------------------------------------- |
| **Mediator**         | Defines communication contract        |
| **ConcreteMediator** | Implements interaction logic          |
| **Colleague**        | Objects that communicate via mediator |

---

## Mapping to *YOUR* Code (Very Important)

### 1️⃣ Mediator

```java
public class ChatMediator {
    List<ChatInterface> users = new ArrayList<>();
}
```

**Role:**

* Holds all users
* Controls how messages are routed
* Central brain of communication

➡ This is the **Concrete Mediator**

---

### 2️⃣ Colleague Interface

```java
public interface ChatInterface {
    void sendMessage(String message);
    String getMessage();
    void notifyUser(String message);
}
```

**Why this exists:**

* Allows mediator to work with users **generically**
* Prevents mediator from knowing concrete classes

➡ This is the **Colleague abstraction**

---

### 3️⃣ Concrete Colleagues

```java
public class AliceChat implements ChatInterface { ... }
public class BobChat implements ChatInterface { ... }
public class CharileChat implements ChatInterface { ... }
```

**Key characteristics:**

* Each user:

  * Knows only the mediator
  * Never knows about other users
* Sends messages via mediator

➡ These are **Concrete Colleagues**

---

## How Communication Works (Step-by-Step)

### Step 1: Registration

```java
public AliceChat(ChatMediator chatMediator){
    this.chatMediator = chatMediator;
    chatMediator.addUsers(this);
}
```

* Every user registers itself with mediator
* Mediator keeps list of all users

---

### Step 2: Sending a Message

```java
alice.sendMessage("Hello, Everyone!");
```

Inside:

```java
this.message = message;
chatMediator.messageBroadcast(this);
```

* Sender **does not know receivers**
* Sender delegates responsibility to mediator

---

### Step 3: Mediator Routes the Message

```java
public void messageBroadcast(ChatInterface expectUser){
    for(ChatInterface user : users){
        if (user != expectUser){
            user.notifyUser(expectUser.getMessage());
        }
    }
}
```

Mediator:

* Excludes sender
* Notifies all others
* Controls routing logic

➡ **All coordination is centralized**

---

### Step 4: Message Reception

```java
public void notifyUser(String message) {
    System.out.println("Bob Received: " + message);
}
```

* Receiver reacts
* No knowledge of who sent it (only message content)

---

## Why This Is a Correct Mediator Pattern

✔ Colleagues do **not** reference each other
✔ Mediator controls communication
✔ Logic is centralized
✔ Easy to add new users
✔ Loose coupling achieved

---

## Key Advantages

* **Loose coupling** between objects
* **Single place** to modify interaction logic
* Easy to add new colleagues
* Cleaner and more maintainable design

---

## Disadvantages

* Mediator can become **too large**
* Risk of turning into a **God Object**
* Too much logic in one place

---

## When to Use Mediator

✅ Many objects interact in complex ways
✅ UI components coordination
✅ Chat systems
✅ Workflow engines
✅ Air traffic control systems

---

## When NOT to Use

❌ Very simple interactions
❌ Only 2 objects interacting
❌ Logic does not change often

---

## Mediator vs Observer (Very Common Question)

| Mediator                      | Observer                   |
| ----------------------------- | -------------------------- |
| Central controller            | One-to-many notification   |
| Controls interactions         | Just reacts to events      |
| Objects don’t know each other | Observers don’t coordinate |

---

## How to Explain in an Interview (Perfect Answer)

> “In the Mediator pattern, objects don’t communicate directly.
> Instead, a mediator object handles all interactions, reducing tight coupling and centralizing communication logic.
> In my chat example, users send messages to a ChatMediator, which broadcasts them to other users.”

---

## Possible Follow-up Improvements (Optional)

* Make `ChatMediator` an interface
* Avoid storing message as state
* Pass message directly in broadcast
* Add private chat / group chat logic

---

## One-Line Summary (Memorize This)

> **Mediator pattern centralizes communication logic between interacting objects, reducing direct dependencies and improving maintainability.**

---