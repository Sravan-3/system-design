
---

![Image](https://www.tutorialspoint.com/design_pattern/images/iterator_pattern_uml_diagram.jpg)

![Image](https://www.educative.io/api/edpresso/shot/6544860234383360/image/5538262238101504)

## Iterator Pattern (Simple)

**Iterator Pattern** provides a way to **access elements of a collection sequentially without exposing its internal structure**.

---

## 1️⃣ Problem (Why Iterator?)

You have a collection (like a list), and you want to:

* Traverse it
* Without exposing how it’s stored
* Without writing traversal logic in client code

---

## 2️⃣ Core Idea

> **Separate traversal logic from the collection itself**

So:

* Collection → stores data
* Iterator → knows how to traverse

---

## 3️⃣ Structure (Very small)

* **Iterator** → traversal interface
* **ConcreteIterator** → actual traversal logic
* **Collection** → data container

---

## 4️⃣ Simple Java Example

### Step 1: Iterator interface

```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

---

### Step 2: Collection interface

```java
public interface Container<T> {
    Iterator<T> getIterator();
}
```

---

### Step 3: Concrete collection

```java
public class NameCollection implements Container<String> {

    private String[] names = {"Alice", "Bob", "Charlie"};

    @Override
    public Iterator<String> getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            return names[index++];
        }
    }
}
```

---

### Step 4: Client (clean & decoupled)

```java
public class Demo {
    public static void main(String[] args) {

        NameCollection collection = new NameCollection();
        Iterator<String> iterator = collection.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

---

## 5️⃣ Why this is Iterator Pattern

✔️ Client **does not know** how data is stored
✔️ Traversal logic is **encapsulated**
✔️ Same collection can expose **multiple iterators**
✔️ Clean separation of concerns

---

## 6️⃣ What NOT to confuse it with ❌

❌ Exposing array and looping directly
❌ Writing traversal logic inside client
❌ Using index-based access everywhere

---

## 7️⃣ One-line interview answer 🔥

> **Iterator pattern provides a uniform way to traverse a collection without exposing its internal representation.**

---

## 8️⃣ Real-world Java example (bonus)

```java
Iterator<Integer> it = list.iterator();
```

`java.util.Iterator` is the **exact same pattern**.

---

