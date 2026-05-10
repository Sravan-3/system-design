
---

# Observer Pattern — Notes (with your Editor example)

![Image](https://cdn-images.visual-paradigm.com/tutorials/observerdesignpattern_screenshots/29_select_concrete_observer.png)

![Image](https://www.tutorialspoint.com/design_pattern/images/observer_pattern_uml_diagram.jpg)

![Image](https://media.licdn.com/dms/image/v2/D5612AQEMbiOh8decZA/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1721193918972?e=2147483647\&t=iKN_FtM2RDVsNmH3blPjtrGbw-ZjgYfAUuY8eitZpqc\&v=beta)

---

## What is the Observer Pattern?

> **Observer Pattern defines a one-to-many dependency where multiple observers are notified automatically when the subject’s state changes.**

**Key idea:**
👉 Subject does **not know concrete observers**
👉 Observers **react** to changes
👉 Communication is **one-way**

---

## Why do we need Observer Pattern?

### Problem without Observer

* Editor directly calls:

  * Email service
  * Logger
  * Audit service
* Adding a new reaction means **changing Editor code**
* Violates **Open–Closed Principle**

---

### Solution with Observer

* Editor only **publishes events**
* Observers decide how to react
* New behavior added **without modifying Editor**

---

## Core Concepts

| Term             | Meaning                     |
| ---------------- | --------------------------- |
| **Subject**      | Object being observed       |
| **Observer**     | Object reacting to changes  |
| **Subscription** | Observer registers interest |
| **Notification** | Subject informs observers   |

---

## Mapping to *YOUR* Code (Very Important)

---

## 1️⃣ Subject (Publisher)

### `Editor`

```java
public class Editor {
    public EventManager events;
    private File file;
}
```

**Responsibilities:**

* Performs core business logic (`openFile`, `saveFile`)
* Emits events
* Does **not** care who is listening

➡ **Editor is the Subject**

---

## 2️⃣ Event Manager (Observer Infrastructure)

### `EventManager`

```java
Map<String, List<EventListener>> listeners;
```

**Why this exists:**

* Manages observers
* Handles:

  * Subscribe
  * Unsubscribe
  * Notify

This is a **helper / dispatcher**, very common in real systems.

---

### Subscription

```java
public void subscribe(String eventType, EventListener listener)
```

* Observer registers interest in an event
* Subject remains unaware of concrete observers

---

### Notification

```java
public void notify(String eventType, File file)
```

* Loops through observers
* Calls `update(...)`

➡ **One-way communication**

---

## 3️⃣ Observer Interface

### `EventListener`

```java
public interface EventListener {
    void update(String eventType, File file);
}
```

**Why interface?**

* Loose coupling
* Editor does not depend on concrete classes

➡ This is the **Observer abstraction**

---

## 4️⃣ Concrete Observers (Subscribers)

### Email Observer

```java
public class EmailNotificationListener implements EventListener
```

* Reacts by sending email
* Independent of Editor logic

---

### Logger Observer

```java
public class LogOpenListener implements EventListener
```

* Reacts by logging to file
* No knowledge of Editor internals

---

## How the Flow Works (Step-by-Step)

### Step 1: Setup subscriptions

```java
editor.events.subscribe("open", new LogOpenListener(...));
editor.events.subscribe("save", new EmailNotificationListener(...));
```

Observers choose **what event they care about**.

---

### Step 2: Subject state change

```java
editor.openFile("test.txt");
```

* Editor changes internal state
* Triggers event

---

### Step 3: Notification

```java
events.notify("open", file);
```

* EventManager informs all subscribed observers
* Editor doesn’t know *who* reacts

---

### Step 4: Observers react

```java
listener.update(eventType, file);
```

Each observer reacts **independently**.

---

## Why This Is a Correct Observer Pattern

✔ One-to-many relationship
✔ Observers react to subject changes
✔ Subject doesn’t know observers
✔ Loose coupling
✔ Open–Closed Principle followed

---

## Direction of Communication (Important)

```
Editor (Subject)
      ↓ notify
Observers (Email, Log)
```

👉 **One-way only**

Observers **do not talk back** to Editor.

---

## Advantages

* Loose coupling
* Easy to add new observers
* Clean separation of concerns
* Widely used in real systems

---

## Disadvantages

* Too many observers → performance cost
* Debugging event chains can be hard
* Notification order may matter

---

## When to Use Observer Pattern

✅ Event-driven systems
✅ UI listeners
✅ Logging / monitoring
✅ Notifications
✅ Pub-Sub systems

---

## When NOT to Use

❌ Complex two-way coordination
❌ Business logic spread across observers
❌ When interaction rules matter (use Mediator)

---

## Observer vs Mediator (Using Your Examples)

| Observer (Editor)        | Mediator (Chat)         |
| ------------------------ | ----------------------- |
| One-way                  | Two-way                 |
| Notification             | Coordination            |
| Subject unaware of logic | Mediator controls logic |
| Event-driven             | Interaction-driven      |

---

## Interview-Perfect Explanation

> “Observer pattern is used when multiple objects need to react to changes in another object.
> The subject notifies all registered observers, enabling loose coupling and extensibility.”

---

## One-Line Summary (Memorize)

> **Observer pattern enables one-to-many, one-way notification from a subject to its observers when state changes.**

---