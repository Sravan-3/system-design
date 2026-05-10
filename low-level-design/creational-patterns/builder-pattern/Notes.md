# The Builder pattern is used to construct complex objects step by step. The client configures the builder and calls build(), which internally creates the product, keeping construction logic encapsulated.

- Abstract Factory returns the product immediately, whereas Builder lets you run some additional construction steps before fetching the product.

---

## Short answer

```java
House house = new HouseBuilder() ...
```

👉 **This is NOT creating a House**

This is calling the **constructor of `HouseBuilder`**, not `House`.

The **House constructor is called later**, inside:

```java
.build()
```

---

## Let’s walk it line by line (slow & precise)

### Your code

```java
House house = new HouseBuilder()
        .windows(2)
        .doors(5)
        .build();
```

---

### Step 1️⃣

```java
new HouseBuilder()
```

✔️ Calls:

```java
public HouseBuilder() { }
```

So right now:

* You only have a **builder object**
* ❌ No `House` yet

---

### Step 2️⃣

```java
.windows(2).doors(5)
```

These just **mutate the builder’s fields**:

```java
this.windows = 2;
this.doors = 5;
```

Still:

* ❌ No `House`
* ✔️ Just configuration

---

### Step 3️⃣ (THE IMPORTANT PART)

```java
.build()
```

Inside `HouseBuilder`:

```java
public House build() {
    return new House(this);
}
```

⚠️ This is where the magic happens.

---

## Where is the `House` constructor called?

Right here 👇

```java
return new House(this);
```

That calls this constructor in `House`:

```java
House(HouseBuilder builder) {
    this.windows = builder.getWindows();
    this.doors = builder.getDoors();
    ...
}
```

✅ **House is created ONLY here**

---

## Visual execution flow (burn this into memory)

```text
new HouseBuilder()        → Builder constructor
.windows(2)              → set field
.doors(5)                → set field
.build()                 → calls new House(builder)
                          → House constructor runs
```

---

## Why you NEVER do `new House(...)` in client code

Because Builder’s purpose is:

> **Hide object construction logic from the client**

So this is illegal by design:

```java
❌ House house = new House(...);
```

And this is correct:

```java
✔️ House house = new HouseBuilder().build();
```

---

## Why `House` constructor is NOT public

```java
House(HouseBuilder builder) { ... }
```

* Package-private or private
* Forces **controlled construction**
* Prevents half-built objects

This is a **feature**, not a limitation.

---

## Interview-grade explanation 🔥

> In the Builder pattern, the client creates a Builder object, configures it step by step, and finally calls `build()`, which internally invokes the product’s constructor. The client never directly calls the product constructor.

---

## Final mental model (simple)

* `new HouseBuilder()` → *“I want to configure a house”*
* `.build()` → *“Now actually create it”*

---

## TL;DR

✔️ `new HouseBuilder()` → Builder constructor
✔️ `build()` → calls `new House(...)`
✔️ `House` constructor is **hidden**
✔️ Client never sees `new House`

---
