# 🧪 Monolithic Scaling Experiment (Spring Boot + Docker)

## 🎯 Goal

Simulate how a monolithic application behaves under load:

* Slow down instead of crashing
* Observe thread contention, backpressure, and failures

---

# 📁 Project Structure

```
mono-micro-arch/
├── mono-app/          # Spring Boot app
├── load-generator/    # Load script / simulation
```

---

# 🧱 STEP 1: Build Spring Boot App

```bash
cd mono-app
mvn clean package
```

---

# 🐳 STEP 2: Build Docker Image

```bash
docker build -t mono-spring-app .
```

---

# 🌐 STEP 3: Create Network

```bash
docker network create mono-net
```

---

# 🚀 STEP 4: Run Container

```bash
docker run -d \
  --name app \
  --network mono-net \
  -p 8080:8080 \
  -m 256m \
  --cpus="0.3" \
  mono-spring-app
```

---

# ✅ STEP 5: Verify App

```bash
curl "http://localhost:8080/order?productId=1&qty=1"
```

Expected:

```
OK
```

---

# ⚙️ STEP 6: Add Realistic Load (IMPORTANT)

## Add delay in Service

```java
Thread.sleep(50);
```

---

## Limit Tomcat Threads

`application.properties`

```properties
server.tomcat.threads.max=10
server.tomcat.accept-count=10
```

---

# 📊 STEP 7: Add Logging

```java
if (count % 100 == 0) {
    System.out.println("🔥 Requests processed: " + count);
}
```

---

# 🧪 STEP 8: Load Script

Create `script.sh`:

```bash
#!/bin/bash

URL="http://localhost:8080/order"

while true; do
  seq 1 500 | xargs -P 200 -I{} bash -c '
    curl -s "'"$URL"'?productId=$((RANDOM%3+1))&qty=1" > /dev/null
  '
done
```

Make executable:

```bash
chmod +x script.sh
```

Run:

```bash
./script.sh
```

---

# 📈 STEP 9: Monitor System

### Logs

```bash
docker logs -f app
```

### Resource usage

```bash
docker stats
```

---

# 🔥 Observations

## Phase 1: Normal

* Fast responses
* Low latency

---

## Phase 2: Load increases

* Slower responses
* CPU rises

---

## Phase 3: Overload

* Queue builds
* Latency increases

---

## Phase 4: Failure

* Connection reset
* Timeout
* Request drops

---

# 🧠 Key Learnings

### 1. System doesn’t crash immediately

```
Slow → Queue → Fail → Crash (optional)
```

---

### 2. CPU is NOT always bottleneck

* Locks (`synchronized`)
* Thread pool limits
* I/O delays

---

### 3. Backpressure exists

* Requests are queued
* Not infinite scaling

---

### 4. Blocking reduces CPU usage

```
Waiting threads ≠ CPU usage
```

---

# 💥 Experiments

## 🔹 Experiment 1: Remove `synchronized`

* Faster
* Incorrect results (race condition)

---

## 🔹 Experiment 2: Increase delay

```java
Thread.sleep(100);
```

* More latency
* Faster failure

---

## 🔹 Experiment 3: Reduce threads

```properties
server.tomcat.threads.max=5
```

---

## 🔹 Experiment 4: Increase load

```bash
-P 300
```

---

# 🧠 Final Takeaway

```
Systems don’t fail instantly.
They degrade under pressure.
```

---

