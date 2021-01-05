// 자바 9의 VarHandle

public class AtomicIntegerWithVarHandles extends Number {

    private volatile int value = 0;
    private static final VarHandle V;

    static {
	try {
	    MethodHandles.Lookup l = MethodHandles.lookup();
	    V = l.FindVarHandle(AtomicIntegerWithVarHandles.class, "value", int.class);
	} catch (ReflectiveOperationException e) {
	    throw new Error(e);
	}
    }

    public final int getAndSet(int newValue) {
	int v;
	do {
	    v = (int)V.getVolatile(this);
	} while (!V.compareAndSet(this, v, newValue));

	return v;
    }
    // 생략
