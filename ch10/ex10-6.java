// 힙 할당 제거

public long noEscape() {
    long sum = 0;

    for (int i = 0; i < 1_000_000; i++) {
	MyObj foo = new MyObj(i); // foo는 메서드를 탈출하지 않음(NoEscape)
	sum += foo.bar();
    }

    return sum;
}


public long argEscape() {
    long sum = 0;
    for (int i = 0; i < 1_000_000; i++) {
	MyObj foo = new MyObj(i);
	sum += extBar(foo); // foo는 extBar() 메서드의 인수로 전달됨(ArgEscape)
    }

    return sum;
}
