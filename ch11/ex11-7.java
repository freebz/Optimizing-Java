// 왜 종료화로 문제를 해결하지 않을까?

/* VM이 실행한다 */
static void register(Object Finalizee) {
    new Finalizer(Finalizee);
}
