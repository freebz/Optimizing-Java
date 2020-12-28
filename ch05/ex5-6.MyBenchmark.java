public class MyBenchmark {

    public static void main(String[] args) throws RunnerException {
	Options opt = new OptionsBuilder()
	    .include(SortBenchmark.class.getSimpleName())
	    .warmupIterations(100)
	    .measurementIterations(5).forks(1)
	    .jvmArgs("-server", "-Xms2048m", "-Xmx2048m").build();

	new Runner(opt).run();
    }
}
