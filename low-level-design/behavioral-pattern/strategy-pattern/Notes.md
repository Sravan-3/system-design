
---

# 📌 Strategy Pattern – Complete Notes (SDE-1 Level)

---

# 1️⃣ Definition

> Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime.

It allows behavior to be selected dynamically without modifying existing code.

---

# 2️⃣ Problem It Solves

Without Strategy pattern:

```java
if (paymentType == CREDIT_CARD) {
    // logic
} else if (paymentType == NET_BANKING) {
    // logic
}
```

Problems:

* Large if-else chains
* Violates Open/Closed Principle
* Hard to extend
* Tight coupling

---

# 3️⃣ Structure (Clean Version)

```
            PaymentStrategy (interface)
                      ↑
        --------------------------------
        |                              |
CreditCardPayment              NetBankingPayment
                      ↑
                PaymentContext
                      ↑
                    Client
```

---

# 4️⃣ Roles in Our Implementation

## 🔹 1. Strategy Interface

```java
public interface PaymentStrategy {
    boolean pay(User user, int amount);
}
```

Defines the common behavior.

---

## 🔹 2. Concrete Strategies

* `CreditCardPayment`
* `NetBankingPayment`

Each class:

* Implements `PaymentStrategy`
* Contains its own payment algorithm
* Does not contain UI logic

---

## 🔹 3. Context

```java
public class PaymentContext {
    private PaymentStrategy paymentStrategy;
}
```

Responsibilities:

* Holds a reference to strategy
* Delegates execution
* Does not know implementation details

---

## 🔹 4. Client (Demo)

* Selects strategy at runtime
* Sets strategy in context
* Provides input
* Calls execution

---

# 5️⃣ Design Principles Followed

## ✅ 1. Open/Closed Principle (OCP)

To add UPI:

```java
class UpiPayment implements PaymentStrategy
```

No modification needed in existing strategies.

---

## ✅ 2. Single Responsibility Principle (SRP)

We separated:

| Class             | Responsibility     |
| ----------------- | ------------------ |
| PaymentStrategy   | Algorithm contract |
| CreditCardPayment | Credit card logic  |
| NetBankingPayment | Net banking logic  |
| PaymentDatabase   | Data storage       |
| PaymentContext    | Delegation         |
| Demo              | UI                 |

---

## ✅ 3. Dependency Inversion Principle (DIP)

Context depends on abstraction:

```java
private PaymentStrategy paymentStrategy;
```

Not on concrete classes.

---

# 6️⃣ Important Design Corrections (From Your Original Code)

### ❌ Strategy should NOT:

* Use Scanner
* Print UI messages
* Handle input
* Store database directly

### ✔ Strategy SHOULD:

* Only contain algorithm
* Work with already provided data
* Be stateless if possible

---

# 7️⃣ When To Use Strategy Pattern

Use it when:

✔ Multiple ways to perform a task
✔ Runtime algorithm selection required
✔ Avoiding large if-else chains
✔ Behavior changes frequently
✔ You want to follow OCP

---

# 8️⃣ Real-World Examples

* Payment gateways (Card, UPI, Wallet)
* Sorting algorithms
* Compression algorithms
* Authentication methods
* Discount calculation engines
* Logging strategies

---

# 9️⃣ Advantages

✔ Removes conditional complexity
✔ Easy to extend
✔ Clean separation of concerns
✔ Improves maintainability
✔ Encourages composition over inheritance

---

# 🔟 Disadvantages

❌ Increases number of classes
❌ Client must know which strategy to choose
❌ Slightly more complex structure

---

# 1️⃣1️⃣ Strategy vs State Pattern (Important Interview Question)

| Strategy                   | State                        |
| -------------------------- | ---------------------------- |
| Behavior chosen by client  | Behavior changes internally  |
| Client sets strategy       | Object changes its own state |
| Algorithms are independent | States are related           |

---

# 1️⃣2️⃣ Interview Explanation Template (Memorize This)

If interviewer asks:

**"Explain Strategy Pattern."**

You can say:

> Strategy Pattern is used when we have multiple algorithms for the same task and want to choose one at runtime.
> We define a common interface, implement different strategies, and use a context class to delegate execution.
> This removes conditional logic and follows Open/Closed Principle.

Clean. Crisp. Professional.

---

# 1️⃣3️⃣ How Your Code Scores Now

| Area              | Status |
| ----------------- | ------ |
| Proper Interface  | ✅      |
| Runtime Selection | ✅      |
| SRP               | ✅      |
| OCP               | ✅      |
| Clean Context     | ✅      |
| Interview Ready   | 9/10   |

---

# 🔥 Final Understanding Check

If tomorrow you add:

```java
class UpiPayment implements PaymentStrategy
```

Do you modify:

* PaymentContext? ❌
* Existing strategies? ❌
* Demo logic? Only minimal strategy selection

That is the power of Strategy.

---