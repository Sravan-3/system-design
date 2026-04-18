# Prototype pattern creates new objects by copying existing ones, allowing the client to work with object clones without depending on their concrete classes.

- <b>My Understanding Later: </b> Prototype avoids extra checks in client code. Instead of the client checking whether an object is a Rectangle, Circle, etc., and manually calling the correct constructor with copied fields, we ask the concrete object itself to clone itself.

---

## 1️⃣ The core problem (in plain English)

You want to **copy an object**.

But:

* You **don’t know its concrete class**
* You **don’t want `new ConcreteClass(...)`**
* You want to avoid **huge constructors or factory logic**

So the rule becomes:

> **“Ask the object to copy itself.”**

That’s Prototype.

---

## 2️⃣ What the sentence really means

> **“Use the Prototype pattern when your code shouldn’t depend on the concrete classes of objects that you need to copy.”**

Translated:

* ❌ Don’t do this:

  ```java
  if (shape instanceof Circle) new Circle(...)
  if (shape instanceof Rectangle) new Rectangle(...)
  ```

* ✅ Do this:

  ```java
  shape.clone();
  ```

The **client does not care** what the concrete class is.

---

## 3️⃣ Without Prototype (bad design)

### Problem: copying depends on concrete classes

```java
class Client {
    Shape copyShape(Shape shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return new Circle(c.radius);
        }
        if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return new Rectangle(r.width, r.height);
        }
        throw new IllegalArgumentException();
    }
}
```

🚨 Problems:

* Violates Open–Closed Principle
* Every new subclass → modify client
* Tight coupling

---

## 4️⃣ With Prototype (correct design)

### Step 1: Prototype interface

```java
interface Shape {
    Shape clone();
}
```

This is the **contract**:

> “Any shape knows how to copy itself.”

---

### Step 2: Concrete prototypes

```java
class Circle implements Shape {

    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this.radius);
    }
}
```

```java
class Rectangle implements Shape {

    int width, height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.width, this.height);
    }
}
```

---

### Step 3: Client code (key point)

```java
class Client {

    public static void main(String[] args) {

        Shape shape = new Circle(10);   // unknown concrete type later
        Shape copy = shape.clone();     // 🔥 no instanceof

        System.out.println(shape == copy); // false
    }
}
```

✔️ Client depends only on `Shape`
✔️ No `new Circle()` in client
✔️ No branching logic

---

## 5️⃣ Why this matters (real-world intuition)

### Example: Graphic editor

* User selects an object
* Presses **Ctrl+C / Ctrl+V**
* Editor does NOT know if it’s:

  * Circle
  * Rectangle
  * Group
  * Image

Editor simply says:

```java
selectedObject.clone();
```

That’s Prototype in action.

---

## 6️⃣ How this differs from Factory

| Factory                 | Prototype                    |
| ----------------------- | ---------------------------- |
| Creates **new objects** | Copies **existing objects**  |
| Needs parameters        | Uses existing state          |
| Creation logic external | Creation logic inside object |

Prototype is about **duplication**, not creation from scratch.

---

## 7️⃣ When Prototype is the right choice

Use Prototype when:

* Objects are **expensive to create**
* Objects have **many configuration states**
* You want to **copy at runtime**
* You don’t want class-dependent logic

---

## 8️⃣ Important nuance (deep copy vs shallow copy)

If your object contains references:

```java
class Address {
    String city;
}

class Person implements Prototype {
    Address address;
}
```

Then:

* Shallow copy → shared `Address`
* Deep copy → clone `Address` too

Prototype **forces you to think about copy semantics**.

---

## 9️⃣ Interview one-liner 🔥

> Prototype pattern creates new objects by copying existing ones, allowing the client to work with object clones without depending on their concrete classes.

---

## TL;DR (lock this in)

* Prototype = “copy yourself”
* Client doesn’t know concrete class
* No `new` in client
* Open–Closed friendly

---

# Question 2

---

## The key rule (this is the confusion)

> **Prototype Pattern rule:**
> **Client code must not depend on concrete classes.
> Concrete classes ARE allowed (and required) to know themselves.**

---

## Who depends on what?

### ✅ Correct dependencies

```
Client  ──depends on──▶ Shape (interface)
Circle  ──depends on──▶ Circle (itself)
Rectangle ──depends on──▶ Rectangle (itself)
```

### ❌ Incorrect dependencies

```
Client ──depends on──▶ Circle
Client ──depends on──▶ Rectangle
```

---

## Why `clone()` MUST depend on concrete class

Look at your code:

```java
class Circle implements Shape {
    public Shape clone() {
        return new Circle(radius);
    }
}
```

This is **exactly correct**.

Why?

* Only `Circle` knows how to copy a `Circle`
* Only `Rectangle` knows how to copy a `Rectangle`

If `clone()` didn’t depend on concrete class, **who would copy it?**
The client — which is exactly what we’re trying to avoid.

---

## What must NOT depend on concrete class

### ❌ BAD client (no Prototype)

```java
if (shape instanceof Circle) {
    Circle c = (Circle) shape;
    return new Circle(c.radius);
}
```

Client knows concrete classes → bad.

---

### ✅ GOOD client (Prototype)

```java
Shape copy = shape.clone();
```

Client knows:

* `Shape`
* Nothing else

---

## One perfect mental sentence (memorize this)

> **In Prototype, the knowledge of how to copy an object is pushed into the concrete class itself, so that the client remains independent of concrete implementations.**

---

## Simple analogy (last time, promise 😄)

* ❌ Client says: *“If you’re a Circle, do this”*
* ✅ Client says: *“Clone yourself”*

The object handles the rest.

---

## TL;DR (read this carefully)

* ❌ Client must NOT depend on concrete class
* ✅ `clone()` MUST depend on concrete class
* That’s the entire point of Prototype

---

