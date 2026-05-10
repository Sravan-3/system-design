# Consistent Hashing

A deep dive into Consistent Hashing, Virtual Nodes, Replication, Rebalancing, and Distributed System Partitioning concepts.

## Topics Covered

* Consistent Hashing
* Virtual Nodes
* Replication Strategies
* Node Failure Handling
* Data Rebalancing
* Hot Spot Problems
* Quorum Reads/Writes
* Partitioning vs Sharding
* Real-World Distributed Systems
* Trade-offs

## Why Consistent Hashing?

Traditional modulo-based partitioning creates massive data movement whenever a node is added or removed.

Example:

```text
server = hash(key) % number_of_servers
```

If the number of servers changes from 4 to 5:

* Almost every key gets remapped.
* Large-scale migration occurs.
* Cache hit ratio drops.
* Distributed systems become unstable.

Consistent Hashing minimizes remapping.

---
