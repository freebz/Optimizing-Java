// ArrayList

@Benchmark
public List<String> properlySizedArrayList() {
    List<String> list = new ArrayList<>(1_000_000);
    for(int i=0; i < 1_000_000; i++) {
	list.add(item);
    }
    return list;
}

@Benchmark
public List<String> resizingArrayList() {
    List<String> list = new ArrayList<>();
    for(int i=0; i< 1_000_000; i++) {
	list.add(item);
    }
    return list;
}
