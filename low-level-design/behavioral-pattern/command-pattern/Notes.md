
---

# Command Design Pattern — Revision Notes 📝

---

## Intent (1–liner)

> **Command pattern encapsulates a request as an object**, so the sender (invoker) doesn’t know how the request is executed.

---

## Core Idea (plain English)

* Turn **actions** (copy, paste, save, delete) into **objects**
* UI elements (buttons, shortcuts, menu items) **don’t contain business logic**
* Same action can be triggered by **multiple invokers**

---

## Problem It Solves

Without Command pattern:

* UI code directly calls business logic
* Tight coupling between button and action
* Hard to:

  * Add undo/redo
  * Add shortcuts
  * Queue or log actions

---

## Key Participants

### 1️⃣ Command (interface)

```java
interface Command {
    void execute();
}
```

* Declares a common method for all commands

---

### 2️⃣ Concrete Command

```java
class CopyCommand implements Command
class PasteCommand implements Command
```

* Encapsulates the actual action
* May call receiver objects internally

---

### 3️⃣ Invoker

```java
Button
```

* Calls `command.execute()`
* **Does NOT know** what the command does

---

### 4️⃣ Client

```java
Demo / main()
```

* Creates command objects
* Injects them into invokers

---

## Correct Command Pattern Structure

```
Client → sets Command → Invoker → calls execute() → Command
```

---

## Important Design Rule ⚠️

> **Invoker should not create the command**

❌ Bad

```java
Command command = new CopyCommand();
```

✅ Good

```java
Button button = new Button(new CopyCommand());
```

---

## Common Interview Mistake (Very Important)

### ❌ Multiple button classes with same behavior

```java
CopyButton
ShortcutCopyButton
```

* These differ only by **who triggers them**
* This causes unnecessary class explosion

### ✅ Correct approach

* **One generic Button**
* Multiple commands injected

---

## Why Your Original Code Is *Partially Correct*

✔️ Uses:

* Command interface
* Concrete commands
* Invoker calling `execute()`

❌ But:

* Commands are hard-coded inside buttons
* Tight coupling
* Not easily extendable

---

## Benefits (Must Remember)

* Loose coupling between UI and business logic
* Easy to add:

  * Undo / Redo
  * Command history
  * Macro commands
  * Logging / auditing
* Open for extension, closed for modification (OCP)

---

## Real-World Examples 🌍

* GUI buttons & keyboard shortcuts
* Transaction systems
* Job queues
* Remote controls
* Text editors (copy / paste / undo)

---

## Command vs Strategy (Quick Diff)

| Command                  | Strategy                    |
| ------------------------ | --------------------------- |
| Represents an **action** | Represents an **algorithm** |
| Can be queued, undone    | Usually not undoable        |
| Often used with UI       | Used for behavior selection |

---

## Interview One-Liner ⭐

> “Command pattern decouples the sender from the receiver by encapsulating a request as an object, enabling undo, queuing, and flexible command execution.”

---