// Map 최적화

public Object get(Object key) {
    // 편의상 널 키는 지원하지 않음
    if (key == null) return null;

    int hash = key.hashCode();
    int i = indexFor(hash, table.length);
    for (Entity e = table[i]; e != null; e = e.next) {
	Object k;
	if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
	    return e.value;
    }

    return null;
}

private int indexFor(int h, int length) {
    return h & (length-1);
}

// 연결 리스트 노드
static class Node implements Map.Entry {
    final int hash;
    final Object key;
    Object value;
    Node next;

    Node(int h, Object k, Object v, Entry n) {
	hash = h;
	key = k;
	value = v;
	next = n;
    }
}
