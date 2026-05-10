# Node Failure Handling

## What Happens During Failure?

If a node crashes:

* Requests must continue.
* Data should remain available.
* Replicas serve traffic.

---

## Failure Detection

Distributed systems use:

* Heartbeats
* Gossip protocols
* Health checks

Example:

```text
Node A -> ping Node B
```

If no response:

```text
Node marked unhealthy
```

---

## Replica Takeover

If primary node fails:

* Replica becomes active.

This minimizes downtime.

---

## Hinted Handoff

Temporary writes are stored elsewhere when a node is unavailable.

Later:

* Data is replayed.

---

## Anti-Entropy Repair

Background synchronization repairs inconsistent replicas.

---
