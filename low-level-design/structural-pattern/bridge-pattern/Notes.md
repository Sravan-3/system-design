
---

## Short answer (crystal clear)

❌ **Devices do NOT have a has-a relationship**

✅ **Remotes have a has-a relationship with Devices**

---

## Let’s place the relationships correctly

### In your code

```java
public class Remote {
    Device device;   // ← HERE
}
```

This line defines the relationship.

---

## 1️⃣ What relationship is this?

```java
Remote HAS-A Device
```

Why?

* `Remote` **contains** a `Device`
* `Remote` **delegates work** to a `Device`
* This is **composition**

👉 This is the **Bridge** itself.

---

## 2️⃣ What relationship do Devices have?

### Devices are in an **IS-A hierarchy**

```java
Television IS-A Device
Radio IS-A Device
```

```java
class Television implements Device
```

That’s **inheritance / implementation**, not has-a.

---

## 3️⃣ Correct relationship table (important)

| Classes                  | Relationship            |
| ------------------------ | ----------------------- |
| `AdvanceRemote → Remote` | **IS-A** (inheritance)  |
| `Television → Device`    | **IS-A** (implements)   |
| `Remote → Device`        | **HAS-A** (composition) |

If you say this in an interview, you’re solid.

---

## 4️⃣ Why Bridge REQUIRES has-a (not is-a)

Imagine this (❌ wrong design):

```java
class Remote extends Television { ... }
```

Problems:

* Remote becomes a TV 🤨
* Can’t reuse for Radio
* Tight coupling
* Zero flexibility

Bridge **forces**:

```java
Remote HAS-A Device
```

So abstraction and implementation stay **separate**.

---

## 5️⃣ One-line interview answer (memorize this)

> “In Bridge, the abstraction has-a reference to the implementor, while both abstraction and implementation have their own is-a hierarchies.”

That sentence alone can carry you.

---

## 6️⃣ Visual anchor (burn this into memory)

![Image](https://journaldev.nyc3.cdn.digitaloceanspaces.com/2013/07/bridge-design-pattern.png)

![Image](https://refactoring.guru/images/patterns/diagrams/bridge/solution-en.png?id=b72caae18c400d608807)

---

## Final mental model (super important)

```
IS-A → inside a hierarchy
HAS-A → between the two hierarchies
```

Bridge = **two IS-A hierarchies connected by one HAS-A relationship**

---
