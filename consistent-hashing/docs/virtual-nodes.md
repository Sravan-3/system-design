# Virtual Nodes

## What are Virtual Nodes?

Virtual Nodes (vnodes) are multiple logical positions assigned to a single physical server in the hash ring.

Instead of:

```text
1 server = 1 position
```

We use:

```text
1 server = many virtual positions
```

---

## Why Virtual Nodes?

Without virtual nodes:

* Some servers may receive too much data.
* Some servers may remain underutilized.

This creates uneven distribution.

---

## Example

Without virtual nodes:

```text
Node A -> 50%
Node B -> 10%
Node C -> 40%
```

With virtual nodes:

```text
Node A -> 33%
Node B -> 34%
Node C -> 33%
```

---

## How it Works

Each physical node gets multiple hashes.

Example:

```text
Node A:
- A#1
- A#2
- A#3
```

These positions are distributed around the ring.

---

## Benefits

* Better load balancing
* Faster recovery
* Improved scalability
* Reduced hot spots
* Smoother rebalancing

---

## Drawbacks

* Metadata overhead
* More complex routing
* Increased management complexity

---
