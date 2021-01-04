public final int getAndSetInt(Object o, long offset, int newValue) {
    int v;
    do {
	v = getIntVolatile(o, offset);
    } while (!compareAndSwapInt(o, offset, v, newValue));

    return v;
}

public native int getIntVolatile(Object o, long offset);

public final native boolean compareAndSwapInt(Object o, long offset,
			       int expected, int x);
