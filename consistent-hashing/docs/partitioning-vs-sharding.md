# Partitioning vs Sharding

## Partitioning

Partitioning divides data into smaller pieces.

Can exist:

* inside one database
* across multiple machines

---

## Sharding

Sharding is horizontal partitioning across multiple servers.

Example:

```text
Shard 1 -> Users A-F
Shard 2 -> Users G-M
Shard 3 -> Users N-Z
```

---

## Consistent Hashing vs Range Sharding

### Range Sharding

Pros:

* Simple
* Range queries easy

Cons:

* Hot spots common

---

### Consistent Hashing

Pros:

* Better balancing
* Easier scaling

Cons:

* Range queries difficult

---
