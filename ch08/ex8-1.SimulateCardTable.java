// 수집기 스레드와 GC 루트

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
public class SimulateCartTable {

    // 올드 세대는 힙의 3/4을 차지하며, 1G 올드 세대에 카드 테이블은 2M 필요함
    private static final int SIZE_FOR_20_GIG_HEAP = 15 * 2 * 1024 * 1024;

    private static final byte[] carts = new byte[SIZE_FOR_20_GIG_HEAP];

    @Setup
    public static final void setup() {
	final Random = new Random(System.nanoTime());
	for (int i=0; i<100_000; i++) {
	    cards[r.nextInt(SIZE_FOR_20_GIG_HEAP)] = 1;
	}
    }

    @Benchmark
    public int scanCardTable() {
	int found = 0;
	for (int i=0; i<SIZE_FOR_20_GIG_HEAP; i++) {
	    if (cards[i] > 0)
		found++;
	}
	return found;
    }
}
