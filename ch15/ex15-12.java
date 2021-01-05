public void mh() throws Exception {
    MethodType mt = MethodType.methodType(void.class);
    MethodHandle mh = MethodHandles.lookup().FindVirtual
	(BytecodePatterns.class, "mh", mt);
}
