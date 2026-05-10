# Quorum-Based Reads and Writes

## What is a Quorum?

Quorum defines:

```text
minimum successful replicas needed
```

---

## Read Quorum

```text
R = required read acknowledgements
```

---

## Write Quorum

```text
W = required write acknowledgements
```

---

## Replication Factor

```text
N = total replicas
```

---

## Strong Consistency Rule

If:

```text
R + W > N
```

Then:

* latest write is guaranteed visible.

---

## Example

```text
N = 3
R = 2
W = 2
```

Then:

```text
R + W = 4 > 3
```

Strong consistency achieved.

---

## Trade-Offs

Higher quorum:

* better consistency
* lower availability
* higher latency

---
