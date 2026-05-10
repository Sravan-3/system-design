
---

# What the Memento pattern wants (core idea)

> Capture an object’s internal state without exposing its implementation details, so it can be restored later.

Your code achieves this separation.

---

# Mapping your code to Memento roles

---

## 1️⃣ Originator

```java
public class TextEditor {
```

✔ Correct
This is the **Originator** — the object whose state we save and restore.

It:

* Creates the memento (`save()`)
* Restores from memento (`restore()`)

---

## 2️⃣ Memento

```java
public class EditMemento {
    private final String content;
}
```

✔ Correct
This is the **Memento** — snapshot object.

Important detail:

```java
private final String content;
```

Immutability is correct design for snapshots.

---

## 3️⃣ Caretaker

```java
public class History {
    Stack<EditMemento> history = new Stack<>();
}
```

✔ Correct
This is the **Caretaker**.

It:

* Stores mementos
* Returns them on undo
* Does NOT inspect internal state

That’s exactly how it should work.

---

# Visual mental model (Memento structure)

## 🔹 Pattern Structure

![Image](https://www.tutorialspoint.com/design_pattern/images/memento_pattern_uml_diagram.jpg)

![Image](https://reactiveprogramming.io/_next/image?q=75\&url=%2Fbooks%2Fpatterns%2Fimg%2Fpatterns-articles%2Fmemento-diagram.png\&w=3840)

![Image](https://miro.medium.com/0%2AE7oks6n3-hfzbiK0.png)

Your mapping:

```
Originator → TextEditor
Memento → EditMemento
Caretaker → History
```

Almost textbook.

---

# What’s GOOD in your implementation

---

## ✅ Proper Encapsulation

`History` does NOT call:

```java
getSavedContent()
```

Only `TextEditor` does.

That preserves internal state secrecy.

This is the most important rule of Memento.

---

## ✅ Immutable Snapshot

```java
private final String content;
```

Very important for correctness.

Prevents accidental state mutation.

---

## ✅ Clean Separation of Responsibilities

| Class       | Responsibility |
| ----------- | -------------- |
| TextEditor  | Business logic |
| EditMemento | Snapshot only  |
| History     | State tracking |

Clear and clean.

---

# What’s NOT ideal (important interview improvements)

---

## ❌ 1. Null Safety Problem

```java
textEditor.restore(snapshots.undo());
```

If stack is empty → `undo()` returns null → NPE.

Better:

```java
EditMemento m = snapshots.undo();
if (m != null) {
    textEditor.restore(m);
}
```

Interviewers may point this out.

---

## ❌ 2. Saving After Write (Undo Semantics)

You currently:

```
write()
save()
```

This works.

But real editors usually:

```
save()
write()
```

So undo returns the previous version cleanly.

Not wrong — just behavioral detail.

---

## ❌ 3. Stack is Legacy

```java
Stack<EditMemento>
```

Modern Java prefers:

```java
Deque<EditMemento> history = new ArrayDeque<>();
```

Better API design.

---

## ❌ 4. Memento Visibility (Advanced Concept)

In stricter Memento:

* Memento constructor is often private
* Only Originator can create it

You could make:

```java
public static class EditMemento
```

inside `TextEditor` to fully hide it.

That makes it “interview-polished”.

---

# Is this acceptable in interviews?

### ✅ For SDE-1 → Absolutely YES

This is clean and correct.

### ⭐ For Mid-level → Mention improvements

Say:

> “This is Memento. For better encapsulation I’d hide the Memento class inside the Originator and handle null safety.”

That answer shows depth.

---

# Real-world usage examples

### 📝 Document editors

Undo/Redo in Microsoft Word

### 💻 IDEs

Undo refactoring in IntelliJ IDEA

### 🎮 Games

Checkpoint saves in Minecraft

### 🗄 Databases

Transaction rollback mechanism

---

# Final Verdict

| Aspect                   | Verdict            |
| ------------------------ | ------------------ |
| Is it Memento?           | ✅ YES              |
| Proper role separation?  | ✅ YES              |
| Encapsulation respected? | ✅ YES              |
| Interview-ready?         | ⭐⭐⭐⭐☆              |
| Needs refinement?        | Minor improvements |

---

