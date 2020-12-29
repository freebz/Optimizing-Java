// 병렬 수집기의 한계

public static void main(String[] args) {
    int[] anInt = new int[1];
    Runnable r = () -> {
	anInt[0]++;
	System.out.println("Changed: " + anInt[0]);
    };

    new Thread(r).start();
}
