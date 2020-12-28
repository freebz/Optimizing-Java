public volatile int i1 = 1, i2 = 2;

/**
 * This call provides a side effect preventing JIT to eliminate
 * dependent computations.
 *
 * @param i int to consume.
 */
public final void consume(int i) {
    if (i == i1 & i == i2) {
	// SHOULD NEVER HAPPEN
	nullBait.i1 = i; // implicit null pointer exception
    }
}
