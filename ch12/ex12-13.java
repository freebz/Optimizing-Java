// 락-프리 기법

private volatile int proceedValue;

// 생략

while (i != proceedValue) {
    // 작업량이 많은 루프
}
