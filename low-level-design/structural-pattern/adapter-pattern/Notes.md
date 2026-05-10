# Adapter Pattern is useful when existing or third-party classes have incompatible interfaces. Instead of changing client code or rewriting classes, we wrap the incompatible class in an adapter that exposes the interface the client expects.
---

## 1️⃣ What you got RIGHT ✅

### ✔️ You identified the mismatch

* `RoundHole` works with `RoundPeg`
* `SquarePeg` is incompatible
* You need an **adapter**

Perfect Adapter use case 👍

---

### ✔️ You computed the correct adaptation logic

```java
radius = width * sqrt(2) / 2
```

This is exactly how the square peg fits into a round hole.

---

## 2️⃣ Where the Adapter pattern is *broken* ❌

### 🚨 Core issue

```java
SquarePegAdapter squarePegAdapter = new SquarePegAdapter(sqaurePeg);
RoundPeg roundPeg2 = new RoundPeg(squarePegAdapter.getRadius());
```

⚠️ This line is the giveaway:

> **You are adapting the data, not the interface**

The client is still manually creating a `RoundPeg`.

In Adapter pattern:

* **Client should not do the conversion**
* **Adapter should pretend to be the target**

---

## 3️⃣ What Adapter Pattern REALLY means

> **Adapter makes an incompatible class look like a compatible one**

So:

* `RoundHole` expects → `RoundPeg`
* Adapter should **BE a `RoundPeg`**

---

## 4️⃣ Correct Adapter Pattern (clean & canonical)

### Step 1: Target interface (or class)

```java
public interface Peg {
    int getRadius();
}
```

---

### Step 2: Existing compatible class

```java
public class RoundPeg implements Peg {

    private int radius;

    public RoundPeg(int radius) {
        this.radius = radius;
    }

    @Override
    public int getRadius() {
        return radius;
    }
}
```

---

### Step 3: Incompatible class (unchanged)

```java
public class SquarePeg {

    private int width;

    public SquarePeg(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}
```

---

### Step 4: Adapter (THIS is the key)

```java
public class SquarePegAdapter implements Peg {

    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public int getRadius() {
        return (int) (squarePeg.getWidth() * Math.sqrt(2) / 2);
    }
}
```

✅ Adapter **implements the expected interface**
✅ Wraps the incompatible object
✅ Converts behavior

---

### Step 5: Client (clean!)

```java
public class RoundHole {

    private int radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public boolean fits(Peg peg) {
        return peg.getRadius() <= radius;
    }
}
```

---

### Demo (THIS is Adapter beauty ✨)

```java
public class Demo {

    public static void main(String[] args) {

        RoundHole hole = new RoundHole(5);

        Peg roundPeg = new RoundPeg(3);
        Peg squarePeg = new SquarePegAdapter(new SquarePeg(6));

        System.out.println(hole.fits(roundPeg));   // true
        System.out.println(hole.fits(squarePeg));  // false
    }
}
```

---

## 5️⃣ Why your original version is *almost* Adapter

| Aspect                    | Your code | Correct Adapter |
| ------------------------- | --------- | --------------- |
| Math logic                | ✅         | ✅               |
| Wrapper object            | ✅         | ✅               |
| Adapter implements target | ❌         | ✅               |
| Client knows adaptation   | ❌         | ❌               |
| Polymorphism              | ❌         | ✅               |

---

## 6️⃣ Key sentence (lock this in 🔥)

> **An Adapter must implement the interface expected by the client so that the client remains unaware of the adaptation.**

---

## 7️⃣ One-line interview answer

> Adapter converts the interface of an incompatible class into one that the client expects, allowing otherwise incompatible objects to work together.

---

## Final verdict

* ❌ **As written:** conceptually right, structurally not pure Adapter
* ✅ **With interface-based adapter:** textbook Adapter Pattern

