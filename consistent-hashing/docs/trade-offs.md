# Trade-Offs

## Advantages

### Scalability

Nodes can be added easily.

### Fault Tolerance

Replication improves reliability.

### Minimal Rebalancing

Only partial data moves.

### High Availability

Systems remain operational during failures.

---

## Disadvantages

### Operational Complexity

Distributed systems are difficult to manage.

### Consistency Challenges

Replication introduces synchronization issues.

### Debugging Difficulty

Failures are harder to diagnose.

### Network Overhead

Replication and rebalancing consume bandwidth.

---

## CAP Theorem Trade-Off

Distributed systems often balance:

* Consistency
* Availability
* Partition Tolerance

Most large-scale systems prefer:

```text
Availability + Partition Tolerance
```

with eventual consistency.
