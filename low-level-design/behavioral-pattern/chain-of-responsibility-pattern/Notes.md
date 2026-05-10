
---

# Chain of Responsibility Pattern is useful when a request must pass through multiple sequential checks, and each check can decide whether to process, pass, or stop the request. Instead of hard-coding all checks in one place, we decouple them into independent handlers linked as a chain.

![Image](https://upload.wikimedia.org/wikipedia/commons/6/6a/W3sDesign_Chain_of_Responsibility_Design_Pattern_UML.jpg)

![Image](https://refactoring.guru/images/patterns/diagrams/chain-of-responsibility/solution1-en.png?id=dccad3e628bd2b8f1856c99369ca6e5b)

![Image](https://online.visual-paradigm.com/repository/images/f9f270d4-14f0-4558-808c-b0c033a91536.png)



---

## 1️⃣ What you got RIGHT ✅

✔️ You correctly identified the **sequential nature of checks**

* Authentication must happen first
* Authorization depends on authentication
* Validation, rate-limiting, caching come later

Perfect CoR use case 👍

✔️ You recognized **early exit behavior**

* If authentication fails → stop
* If request is brute-forced → stop
* If cache hit → stop further processing

This is **exactly** what CoR is designed for.

✔️ You noticed the pain points

* Code kept growing
* Checks affected each other
* Reuse was difficult
* Maintenance became expensive

These are classic symptoms of **missing Chain of Responsibility**.

---

## 2️⃣ Where the original design was broken ❌

🚨 Core issue

All checks were implemented in **one bloated flow** (or tightly coupled logic):

```java
if (authenticate()) {
    if (authorize()) {
        if (validate()) {
            if (!rateLimited()) {
                if (!cacheHit()) {
                    processOrder();
                }
            }
        }
    }
}
```

⚠️ Why this is bad:

* Checks are **not isolated**
* Adding a new check means **modifying existing code**
* You can’t reuse a subset of checks easily
* Violates **Single Responsibility** and **Open/Closed Principle**

---

## 3️⃣ What Chain of Responsibility REALLY means

> **Each check becomes a standalone handler.
> Handlers are linked together.
> Each handler decides whether to pass the request forward.**

So:

* Ordering system sends request to **first handler**
* Handler processes → forwards → or stops
* Client doesn’t know *who* handled the request

---

## 4️⃣ Correct Chain of Responsibility (clean & canonical)

### Step 1: Handler interface (contract)

```java
public interface Handler {
    void setNext(Handler next);
    boolean handle(Request request);
}
```

All handlers look the same. This is **critical**.

---

### Step 2: Base handler (optional but common)

```java
public abstract class BaseHandler implements Handler {

    protected Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    protected boolean handleNext(Request request) {
        return next == null || next.handle(request);
    }
}
```

Avoids repeating chain-forwarding logic.

---

### Step 3: Concrete handlers (single responsibility)

#### Authentication

```java
public class AuthenticationHandler extends BaseHandler {

    @Override
    public boolean handle(Request request) {
        if (!request.isAuthenticated()) {
            return false; // STOP chain
        }
        return handleNext(request);
    }
}
```

#### Authorization

```java
public class AuthorizationHandler extends BaseHandler {

    @Override
    public boolean handle(Request request) {
        if (request.requiresAdmin() && !request.isAdmin()) {
            return false;
        }
        return handleNext(request);
    }
}
```

#### Validation

```java
public class ValidationHandler extends BaseHandler {

    @Override
    public boolean handle(Request request) {
        request.sanitize();
        return handleNext(request);
    }
}
```

#### Rate limiting

```java
public class RateLimitHandler extends BaseHandler {

    @Override
    public boolean handle(Request request) {
        if (isBruteForce(request.getIp())) {
            return false;
        }
        return handleNext(request);
    }
}
```

#### Cache

```java
public class CacheHandler extends BaseHandler {

    @Override
    public boolean handle(Request request) {
        if (cacheHit(request)) {
            return false; // response already served
        }
        return handleNext(request);
    }
}
```

✅ One handler = one check
✅ No handler knows about others
✅ Easy to add/remove/reorder

---

### Step 4: Chain assembly (runtime composition)

```java
Handler auth = new AuthenticationHandler();
Handler authz = new AuthorizationHandler();
Handler validation = new ValidationHandler();
Handler rateLimit = new RateLimitHandler();
Handler cache = new CacheHandler();

auth.setNext(authz);
authz.setNext(validation);
validation.setNext(rateLimit);
rateLimit.setNext(cache);

// entry point
auth.handle(request);
```

💡 You can now:

* Reuse `AuthenticationHandler` elsewhere
* Skip `CacheHandler` for write APIs
* Add new checks without touching existing ones

---

## 5️⃣ Why your original version is *almost* Chain of Responsibility

| Aspect                | Original code | Proper CoR |
| --------------------- | ------------- | ---------- |
| Sequential checks     | ✅             | ✅          |
| Early exit            | ✅             | ✅          |
| Single responsibility | ❌             | ✅          |
| Decoupled handlers    | ❌             | ✅          |
| Reusability           | ❌             | ✅          |
| Runtime composition   | ❌             | ✅          |

---

## 6️⃣ Key sentence (lock this in 🔥)

> **In Chain of Responsibility, each handler processes a request and decides whether to pass it to the next handler, allowing request processing logic to remain decoupled and flexible.**

---

## 7️⃣ One-line interview answer

> **Chain of Responsibility passes a request through a chain of handlers where each handler can process or stop the request, decoupling the sender from the processing logic.**

---

## ✅ Final verdict

* ❌ Original approach: logically correct, structurally messy
* ✅ Refactored with handlers: **textbook Chain of Responsibility**

