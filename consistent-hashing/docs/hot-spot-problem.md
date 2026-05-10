# Hot Spot Problem

## What is a Hot Spot?

A hot spot occurs when:

* one partition receives excessive traffic
* one node becomes overloaded

---

## Causes

* Poor hash distribution
* Popular keys
* Uneven traffic patterns
* Insufficient virtual nodes

---

## Problems Created

* Increased latency
* Node overload
* Uneven CPU usage
* Reduced throughput

---

## Solutions

### Virtual Nodes

Distribute ownership evenly.

### Better Hash Functions

Improve key distribution.

### Key Salting

Spread hot keys across partitions.

### Replication

Serve reads from replicas.

---
