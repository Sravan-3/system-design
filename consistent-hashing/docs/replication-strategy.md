# Replication Strategy

## Why Replication?

Replication ensures:

* High availability
* Fault tolerance
* Durability
* Better read scalability

Without replication:

* Losing one node may lose data.

---

## Replication Factor

Replication factor defines:

```text
How many copies of data exist
```

Example:

```text
RF = 3
```

Means:

* Primary node
* Replica 1
* Replica 2

---

## Successor Replication

After locating the primary node:

* Data is copied to the next clockwise nodes.

Example:

```text
Primary -> Node A
Replica -> Node B
Replica -> Node C
```

---

## Benefits

* Better reliability
* Node failure recovery
* Increased read throughput

---

## Challenges

* Replica synchronization
* Consistency handling
* Write latency
* Conflict resolution

---
