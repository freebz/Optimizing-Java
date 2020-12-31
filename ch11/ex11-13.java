MethodType mt = MethodType.methodType(int.class);
MethocHandles.Lookup l = MethocHandles.lookup();
MethodHandle mh = l.FindVirtual(String.class, "hashCode", mt);

String receiver = "b";
int ret = (int) mh.invoke(receiver);
System.out.println(ret);
