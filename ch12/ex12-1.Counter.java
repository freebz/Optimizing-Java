// 자바 동시성 기초

public class Counter {
    private int i = 0;

    public int increment() {
	return i = i + 1;
    }
}
