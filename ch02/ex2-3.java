// 스레딩과 자바 메모리 모델(JMM)

Thread t = new Thread(() -> {System.out.println("Hello World!");});
t.start();
