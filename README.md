# Algorithm
 Algorithm tutorials
# Find Missing Number - Complexity Analysis

## Method 1: `findMissingSorted`

### Code:
```java
public static int findMissingSorted(ArrayList<Integer> numbers) {
    if(numbers.get(0) > 0)
        return 0;
    
    for(int i = 1; i < numbers.size(); i++) {
        if(numbers.get(i) - numbers.get(i - 1) > 1) // gap found
            return numbers.get(i - 1) + 1;
    }
    
    // No gap found, return the next number
    return numbers.get(numbers.size() - 1) + 1;
}
```

### Complexity Analysis:
- **Best Case (First Element Missing):** `O(1)`
- **Worst Case (Last Element Missing, Full Traversal):** `O(N)`
- **Space Complexity:** `O(1)`

### Explanation:
- The loop runs at most `N` times in the worst case.
- Each iteration performs an `O(1)` check, leading to an overall time complexity of **O(N)**.
- The space complexity remains **O(1)** since no additional data structures are used.

---

## Method 2: `findMissing`

### Code:
```java
public static int findMissing(ArrayList<Integer> numbers) {
    for(int i = 0; i < numbers.size(); i++) {
        if(!numbers.contains(i))
            return i;
    }
    return -1;  // Dummy value
}
```

### Complexity Analysis:
- **Best Case (First Element Missing):** `O(1)`
- **Worst Case (Last Element Missing, Full Traversal):** `O(N^2)`
- **Space Complexity:** `O(1)`

### Explanation:
- The loop runs **O(N)** times in the worst case.
- The `numbers.contains(i)` method performs a **linear search**, which takes **O(N)** time.
- Thus, the worst-case complexity is **O(N × N) = O(N²)**.
- The space complexity remains **O(1)** since no extra data structures are used.

### Optimization Suggestion:
For improved efficiency, consider using a **HashSet** (for O(1) lookups) or the **sum formula approach** to find the missing number in **O(N) time**.

---

## Summary Table:
| Method                 | Best Case | Worst Case | Space Complexity |
|------------------------|-----------|------------|------------------|
| `findMissingSorted`    | `O(1)`    | `O(N)`     | `O(1)`           |
| `findMissing`          | `O(1)`    | `O(N²)`    | `O(1)`           |

For large datasets, **Method 1 (`findMissingSorted`) is significantly better** in terms of performance compared to **Method 2 (`findMissing`)**. 🚀

