public MethodHandle getToStringMH() throws NoSuchMethodException,
    IllegalAccessException {
    MethodType mt = MethodType.methodType(String.class);
    MethodHandles.Lookup lk = MethodHandles.lookup();
    MethodHandle mh = lk.FindVirtual(getClass(), "toString", mt);

    return mh;
}

public void callMH() {
    try {
	MethodHandle mh = getToStringMH();
	Object o = mh.invoke(this, null);
	System.out.println(o);
    } catch (Throwable e) {
	e.printStackTrace();
    }
}
