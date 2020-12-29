// 할당의 역할

public class ModelAllocator implements Runnable {
    private volatile boolean shutdown = false;

    private double chanceOfLongLived = 0.02;
    private int multiplierForLongLived = 20;
    private int x = 1024;
    private int y = 1024;
    private int mbPerSec = 50;
    private int shortLivedMs = 100;
    private int nThreads = 8;
    private Executor exec = Executors.newFixedThreadPool(nThreads);

    public void run() {
	final int mainSleep = (int) (1000.0 / mbPerSec);

	while (!shutdown) {
	    for (int i = 0; i < mbPerSec; i++) {
		ModelObjectAllocation to =
		    new ModelObjectAllocation(x, y, lifetime());
		exec.execute(to);
		try {
		    Thread.sleep(mainSleep);
		} catch (InterruptedException ex) {
		    shutdown = true;
		}
	    }
	}
    }

    // 약한 세대별 가설을 간단히 모형화한 함수
    // 객체의 기대 수명을 반환함.
    // 보통 객체 수명은 아주 짧지만, 드물게 "장수하는" 객체도 있음.
    public int lifetime() {
	if (Math.random() < chanceOfLongLived) {
	    return multiplierForLongLived * shortLivedMs;
	}

	return shortLivedMs;
    }
}

public class ModelObjectAllocation implements Runnable {
    private final int[][] allocated;
    private final int lifeTime;

    public ModelObjectAllocation(final int x, final int y, final int liveFor) {
	allocated = new int[x][y];
	lifeTime = liveFor;
    }

    @Override
    public void run() {
	try {
	    Thread.sleep(lifeTime);
	    System.err.println(System.currentTimeMillis() +": "+ allocated.length);
	} catch (InterruptedException ex) {
	}
    }
}
