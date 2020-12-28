public int tlr = (int) System.nanoTime();

/**
 * Consume object. This call provides a side effect preventing JIT to eliminate
 * dependent computations.
 *
 * @param obj object to consume.
 */
public final void consume(Object obj) {
    int tlr = (this.tlr = (this.tlr * 1664525 + 1013904223));
    if ((tlr & tlrMask) == 0) {
	// SHOULD ALMOST NEVER HAPPEN IN MEASUREMENT
	this.obj1 = obj;
	this.tlrMask = (this.tlrMask << 1) + 1;
    }
}
