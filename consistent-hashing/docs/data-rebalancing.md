# Data Rebalancing

## What is Rebalancing?

Rebalancing redistributes data when:

* nodes are added
* nodes are removed
* capacity changes

---

## Traditional Hashing Problem

Adding one node may move nearly all data.

---

## Consistent Hashing Advantage

Only nearby partitions move.

Example:

```text
5% to 15% data movement
```

instead of:

```text
90%+
```

---

## Rebalancing Process

1. Add node
2. Assign tokens/vnodes
3. Transfer ownership
4. Stream data
5. Update metadata

---

## Challenges

* Network bandwidth
* Temporary latency increase
* Disk pressure
* Consistency during migration

---
