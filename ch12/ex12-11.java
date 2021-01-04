// 세마포어

// 퍼밋은 2개, 공정 모드로 설정된 세마포어 생성
private Semaphore poolPermits = new Semaphore(2, true);
