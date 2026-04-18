---

# FLYWEIGHT PATTERN — CLEAR & FINAL

---

## 1️⃣ First principles: what problem does Flyweight actually solve?

Forget “memory optimization” for a second.
That’s a **consequence**, not the **reason**.

### 🔴 The real problem

You have:

* **Huge number of objects**
* Most of their data is **identical**
* Creating a new object every time is:

  * memory expensive
  * slow
  * wasteful

> The system is wasting memory by repeatedly storing the **same data** in many objects.

Flyweight removes **that duplication**.

---

## 2️⃣ The key insight (THIS is the unlock)

> **Split object state into two parts**

### 1. Intrinsic state

* Shared
* Immutable
* Same for many objects

### 2. Extrinsic state

* Unique per usage
* Passed from outside
* Not stored inside the object

Flyweight stores **only intrinsic state**.

---

## 3️⃣ Real-world analogy (simple & exact)

### Text editor characters

In a document:

```
H E L L O
```

* Letter **'L'** appears twice
* Font, size, color are same

❌ Naive approach:

* Create 5 separate objects
* Store `'L'` twice

✅ Flyweight approach:

* One object for `'L'`
* Reused at multiple positions
* Position is passed externally

---

## 4️⃣ What Flyweight is NOT (important)

Flyweight ❌ is NOT:

* Singleton (one global object)
* Facade (simplification)
* Decorator (adding behavior)
* Cache for business logic

Flyweight ✅ is:

> **Sharing fine-grained objects to reduce memory usage**

---

## 5️⃣ Canonical structure (interview-ready)

Flyweight has **4 roles**:

1. **Flyweight interface**
2. **Concrete Flyweight** (shared object)
3. **Flyweight Factory** (controls reuse)
4. **Client** (provides extrinsic state)

---

## 6️⃣ Simple & correct code example (Java)

### 🎯 Use case: Drawing circles in a game

Thousands of circles, but only **few colors**.

---

### 1️⃣ Flyweight interface

```java
interface Shape {
    void draw(int x, int y);
}
```

---

### 2️⃣ Concrete Flyweight (intrinsic state)

```java
class Circle implements Shape {
    private final String color; // intrinsic (shared)

    public Circle(String color) {
        this.color = color;
        System.out.println("Creating circle of color: " + color);
    }

    @Override
    public void draw(int x, int y) { // extrinsic
        System.out.println("Drawing " + color + " circle at (" + x + ", " + y + ")");
    }
}
```

🔑 `color` is stored
🔑 `x, y` are passed in

---

### 3️⃣ Flyweight Factory (MOST IMPORTANT PART)

```java
import java.util.HashMap;
import java.util.Map;

class ShapeFactory {

    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {

        Shape circle = circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
        }

        return circle;
    }
}
```

This ensures:

* Only **one Circle per color**
* Objects are reused

---

### 4️⃣ Client code

```java
public class Demo {
    public static void main(String[] args) {

        String[] colors = {"Red", "Green", "Blue"};

        for (int i = 0; i < 6; i++) {
            Shape circle = ShapeFactory.getCircle(colors[i % 3]);
            circle.draw(i * 10, i * 10);
        }
    }
}
```

---

## 7️⃣ Output (observe carefully)

```
Creating circle of color: Red
Creating circle of color: Green
Creating circle of color: Blue
Drawing Red circle at (0, 0)
Drawing Green circle at (10, 10)
Drawing Blue circle at (20, 20)
Drawing Red circle at (30, 30)
Drawing Green circle at (40, 40)
Drawing Blue circle at (50, 50)
```

🚨 **Only 3 objects created**, not 6.

That is Flyweight.

---

## 8️⃣ One-line interview definition (memorize)

> **Flyweight Pattern reduces memory usage by sharing common object state among multiple objects instead of storing it separately.**

---

## 9️⃣ Interview-ready explanation (expanded)

> Flyweight is used when a system creates a large number of similar objects.
> It separates intrinsic state, which is shared and immutable, from extrinsic state, which is provided by the client.
> A factory manages object reuse, ensuring memory efficiency.

---

## 🔟 How this helps in real systems

Concrete uses:

* Text editors (characters, fonts)
* Game engines (trees, bullets, particles)
* UI frameworks (icons)
* JVM String Pool (`String` literals)

---

## 1️⃣1️⃣ Common traps candidates fall into 🚨

### ❌ Trap 1: “Flyweight is caching”

Wrong.

Caching:

* improves performance
* may evict objects

Flyweight:

* reduces memory footprint
* objects live long

---

### ❌ Trap 2: Storing extrinsic state inside flyweight

```java
class Circle {
    int x, y; // ❌ wrong
}
```

Breaks sharing.

---

### ❌ Trap 3: Using Flyweight prematurely

Flyweight adds:

* indirection
* complexity

Use it **only when object count is huge**.

---

## 1️⃣2️⃣ When should you NOT use Flyweight?

* Object count is small
* Objects differ heavily
* State is mostly unique
* Memory is not a concern

Overusing Flyweight = unreadable code.

---

## 1️⃣3️⃣ Final mental model (lock this in)

> **Flyweight answers: “Why are we storing the same data again and again?”**

Or simpler:

> **Many objects, little difference → Flyweight**

---

## 🔚 TL;DR (pin this)

* Flyweight = memory optimization
* Share intrinsic state
* Pass extrinsic state
* Factory controls reuse
* Not Singleton, not Cache

---

