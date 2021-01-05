// 할당 프로파일링

public class AllocAgent {

    public static void premain(String args, Instrumentation instrumentation) {
	AllocRewriter transformer = new AllocRewriter();
	instrumentation.addTransformer(transformer);
    }
}
