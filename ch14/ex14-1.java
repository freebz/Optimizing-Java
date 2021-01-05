// 리얼 로직 라이브러리를 이용해 지연 줄이기

// 이 지저분한 코드 조각은 주소가 짝수일 때
// JVM이 memset()을 호출하게 하려고 만든 것이다.
// TODO: 자바 9가 나왔을 때도 이 코드가 잘 작동하는지 체크하기
UNSAFE.putByte(byteArray, indexOffset, value);
UNSAFE.setMemory(byteArray, indexOffset + 1, length - 1, value);
