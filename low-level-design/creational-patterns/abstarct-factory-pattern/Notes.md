# Abstract Factory provides an interface for creating families of related or dependent objects without specifying their concrete classes.

> **Factory Method → one product**
> **Abstract Factory → a family of related products**

---

## 1️⃣ Factory Method (single product)

### Problem it solves

> “I don’t know *which* concrete object to create.”

### Example: Buttons only

```java
interface Button {
    void render();
}
```

```java
abstract class Dialog {
    public void render() {
        Button b = createButton();
        b.render();
    }
    protected abstract Button createButton();
}
```

```java
class WindowsDialog extends Dialog {
    protected Button createButton() {
        return new WindowsButton();
    }
}
```

✅ One product hierarchy
✅ Creation deferred to subclasses

---

## 2️⃣ Abstract Factory (family of products)

### Problem it solves

> “I don’t know *which set of related objects* to create, but they must work together.”

Think **UI Toolkit**:

* Button
* Checkbox
* Scrollbar

All must match **Windows** or **Mac**, not mix.

---

## 3️⃣ Abstract Factory structure (step by step)

### Product interfaces

```java
interface Button {
    void render();
}

interface Checkbox {
    void check();
}
```

---

### Abstract Factory

```java
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

⚠️ Notice:

* Multiple factory methods
* Each returns a different product type

---

### Concrete factories

```java
class WindowsUIFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
```

```java
class MacUIFactory implements UIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

---

### Client

```java
class Application {
    private Button button;
    private Checkbox checkbox;

    Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
}
```

🎯 Result:

* Button + Checkbox always belong to the **same family**
* No `new` in client code
* Easy to swap families at runtime

---

## 4️⃣ Key difference (the sentence to remember)

> **Factory Method creates one product.
> Abstract Factory creates multiple related products without specifying their concrete classes.**

---

## 5️⃣ How they relate internally (important LLD insight)

👉 **Abstract Factory is often implemented using Factory Methods**

```java
class WindowsUIFactory {
    Button createButton() { ... }      // factory method
    Checkbox createCheckbox() { ... }   // factory method
}
```

So:

* Factory Method = mechanism
* Abstract Factory = higher-level pattern using many of them

---

## 6️⃣ When to use which (decision table)

| Situation                        | Use              |
| -------------------------------- | ---------------- |
| One product varies               | Factory Method   |
| Multiple related products        | Abstract Factory |
| Need consistency across products | Abstract Factory |
| Want simple extension            | Factory Method   |

---

## 7️⃣ Interview-ready one-liner 🔥

> *Abstract Factory provides an interface for creating families of related or dependent objects without specifying their concrete classes.*

---

## 8️⃣ Final mental picture (very important)

* **Factory Method** → *“Which Button?”*
* **Abstract Factory** → *“Which UI Theme?”*

---

## TL;DR

✔️ Factory Method → single object
✔️ Abstract Factory → family of objects
✔️ Families ensure compatibility
✔️ Abstract Factory = multiple factory methods
