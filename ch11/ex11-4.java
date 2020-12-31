// Set 최적화

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Serializable {
    private transient HashMap<E,Object> map;

    // 기반 Map에서 Object에 연관시킬 더미 값
    private static final Object PRESENT = new Object();

    public HashSet() {
	map = new HashMap<>();
    }

    HashSet(int initialCapacity, float loadFactor, boolean dummy) {
	map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }

    public boolean add(E e) {
	return map.put(e, PRESENT)==null;
    }
}
