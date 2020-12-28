@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
public class SortBenchmark {

    private static final int N = 1_000;
    private static final List<Integer> testData = new ArrayList<>();

    @Setup
    public static final void setup() {
	Random randomGenerator = new Random();
	for(int i = 0; i < N; i++) {
	    testData.add(randomGenerator.nextInt(Integer.MAX_VALUE));
	}
	System.out.println("Setup Complete");
    }

    @Benchmark
    public List<Integer> classicSort() {
	List<Integer> copy = new ArrayList<Integer>(testData);
	Collections.sort(copy);
	return copy;
    }

    @Benchmark
    public List<Integer> standardSort() {
	return testData.stream().sorted().collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> parallelSort() {
	return testData.parallelStream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) throws RunnerException {
	Options opt = new OptionsBuilder()
	    .include(SortBenchmark.class.getSimpleName())
	    .warmupIterations(100)
	    .measurementIterations(5).forks(1)
	    .jvmArgs("-server", "-Xms2048m", "-Xmx2048m")
	    .addProfiler(GCProfiler.class)
	    .addProfiler(StackProfiler.class)
	    .build();

	new Runner(opt).run();
    }
}
