// 컴파일하기 적합한 메서드 크기 상한

private java.util.Random r = new java.util.Random();

@Benchmark
public long lessThan8000() {
    return r.nextInt() +
	   r.nextInt() +
    ... // 총 메서드 바이트코드 크기가 8,000바이트 이하
}

@Benchmark
public long moreThan8000() {
    return r.nextInt() +
	   r.nextInt() +
    ... // 총 메서드 바이트코드 크기가 8,000바이트 이상
}
