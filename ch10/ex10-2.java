// 루프 펼치기

private static final int MAX = 1_000_000;

private long[] data = new long[MAX];

private void createData() {
    java.util.Random random = new java.util.Random();

    for (int i = 0; i < MAX; i++) {
	data[i] = random.nextLong();
    }
}
