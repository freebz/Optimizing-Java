// 핫스팟에 특정한 내용

public class A {
    public final void fMethod() {
	// 작업 수행...
    }
}

public class CallA {
    public void otherMethod(A obj) {
	obj.fMethod();
    }
}
