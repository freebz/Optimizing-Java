// 온-스택 치환

package optjava;

public class OnStackReplacement {

    // 이 메서드는 한번만 호출됨
    public static void main(String[] args) {
	java.util.Random r = new java.util.Random();

	long sum = 0;

	// 첫 번째 긴 루프
	for (int i = 0; i < 1_000_000; i++) {
	    sum += r.nextInt(100);
	}

	// 두 번째 긴 루프
	for (int i = 0; i < 1_000_000; i++) {
	    sum += r.nextInt(100);
	}

	System.out.println(sum);
    }
}
