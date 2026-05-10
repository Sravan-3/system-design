# Consistent Hashing

## What is Consistent Hashing?

Consistent Hashing is a distributed partitioning technique used to distribute data across multiple nodes while minimizing data movement when nodes are added or removed.

It is heavily used in:

* Distributed caches
* NoSQL databases
* Load balancers
* Distributed storage systems

Examples:

* Amazon DynamoDB
* Cassandra
* Redis Cluster
* Akamai CDN

---

## Traditional Hashing Problem

Traditional partitioning:

```text
server = hash(key) % N
```

Where:

* key = data key
* N = number of servers

Problem:

When N changes:

```text
hash(key) % 4
hash(key) % 5
```

Almost all keys move.

This causes:

* Large-scale migration
* Cache invalidation
* Network congestion
* High downtime risk

---

## Hash Ring Concept

Consistent hashing organizes nodes in a circular ring.

Hash range:

```text
0 -> 2^32 - 1
```

Both:

* servers
* keys

are hashed into this ring.

---

## Data Placement

Steps:

1. Hash the key.
2. Move clockwise on the ring.
3. First server encountered stores the data.

---

## Node Addition

When a new node is added:

* Only nearby keys move.
* Most data remains untouched.

This is the main advantage.

---

## Node Removal

When a node fails:

* Its neighboring node takes ownership.
* Minimal redistribution occurs.

---

## Benefits

* Minimal rebalancing
* Horizontal scalability
* Better fault tolerance
* Efficient partitioning
* Reduced migration cost

---

## Drawbacks

* Uneven distribution possible
* Complex implementation
* Requires virtual nodes
* Replication management needed

---
