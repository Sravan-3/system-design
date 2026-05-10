
---

# 📝 STATE PATTERN — REVISION NOTES

## 1️⃣ Definition

State Pattern is a **behavioral design pattern** that allows an object to alter its behavior when its internal state changes.

👉 The object appears to change its class.

---

## 2️⃣ Core Idea

Instead of:

```java
if(state == NO_COIN) { ... }
else if(state == HAS_COIN) { ... }
else if(state == DISPENSING) { ... }
```

We do:

* Create separate classes for each state
* Delegate behavior to current state object
* Let states decide transitions

---

## 3️⃣ Components

### ✅ 1. Context

* Holds reference to current state
* Delegates behavior to state
* Does NOT contain conditional logic

Example: `VendingMachine`

---

### ✅ 2. State Interface

* Common behavior for all states

Example:

```java
public interface State {
    void insertCoin();
    void ejectCoin();
    void dispenseItem();
}
```

---

### ✅ 3. Concrete States

* Implement behavior
* Decide when to transition

Example:

* `NoCoinState`
* `HasCoinState`
* `DispensingState`

---

## 4️⃣ Flow in Proper State Pattern

```
Client → Context → Current State
                      ↓
                State may change Context state
```

⚠️ Client never changes state manually.

---

# 🎯 Interview Important Points

* Removes large if-else blocks
* Follows Open/Closed Principle
* State transitions are encapsulated
* Context delegates behavior
* State objects can be reused

---

# 🆚 State vs Strategy (Important)

| State                                | Strategy                    |
| ------------------------------------ | --------------------------- |
| State changes internally             | Strategy set externally     |
| Represents lifecycle                 | Represents algorithm choice |
| Object behavior varies automatically | Behavior chosen by client   |

---

# ❌ Mistakes in Your Implementation

Now let’s carefully analyze your code.

---

## ❌ Mistake 1 — Client Controlling State

You wrote:

```java
vm.setState(new HasCoinState());
vm.setState(new DepensingState());
```

🔴 Problem:

In real State pattern:

* Client should NOT control transitions
* States must decide next state

Why?

Because State pattern models **automatic behavior change**, not manual switching.

Your version behaves more like **Strategy Pattern**.

---

## ❌ Mistake 2 — States Don't Have Context Reference

Your state classes:

```java
public class HasCoinState implements StateInterface {
```

They don't store:

```java
private VendingMachine machine;
```

So they cannot change state internally.

That breaks the core idea of the pattern.

---

## ❌ Mistake 3 — No State Transition Logic

Example:

```java
@Override
public void insertCoin() {
    System.out.println("Already has a coin");
}
```

But after `dispenseItem()`, what happens?

Nothing changes.

The machine stays in same state unless client manually changes it.

That is not real state behavior.

---

## ❌ Mistake 4 — setState() Publicly Used by Client

You exposed:

```java
public void setState(StateInterface state)
```

And client uses it.

Better approach:

* Keep `setState()` package-private or protected
* Only states should use it

---

## ❌ Mistake 5 — Object Creation Every Time (Design Concern)

You wrote:

```java
vm.setState(new HasCoinState());
```

That creates new objects repeatedly.

Better:

* Create state objects once
* Reuse them

---

# 📌 What You Did Correct

Very important — you actually did many things right:

✔ Created State interface
✔ Created multiple concrete states
✔ Context delegates to state
✔ Used polymorphism correctly
✔ Avoided if-else in context

This shows strong understanding.

You were just missing the **state transition control concept**.

---

# 🧠 Interview Answer You Should Give

If interviewer asks:

> “What was wrong in your first implementation?”

You should say:

1. State transitions were controlled by client.
2. States did not have reference to context.
3. No automatic behavior switching.
4. It resembled Strategy more than State.

That answer will impress.

---

# 🏁 Final Understanding Check

A proper State pattern must satisfy:

✅ Context delegates behavior
✅ State objects encapsulate logic
✅ States control transitions
✅ Client is unaware of state switching

---

If you want next:

* I can give you an interview question based on this
* Or a more realistic example like Order lifecycle
* Or convert this into a real production-style LLD question

Let me know what you'd like to practice next.
