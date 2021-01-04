// 아토믹스와 CAS

public class AtomicIntegerExample extends Number {

    private volatile int value;

    // Unsafe.compareAndSwapInt로 업데이트하기 위해 설정
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
	try {
	    valueOffset = unsafe.objectFieldOffset(
		AtomicIntegerExample.class.getDeclaredField("value"));
	} catch (Exception ex) {
	    throw new Error(ex);
	}
    }

    public final int get() {
	return value;
    }

    public final void set(int newValue) {
	value = newValue;
    }

    public final int getAndSet(int newValue) {
	return unsafe.getAndSetInt(this, valueOffset, newValue);
    }
    // 생략
