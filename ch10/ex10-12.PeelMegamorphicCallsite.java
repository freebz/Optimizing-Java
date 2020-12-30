package optjava.jmh;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

interface Shape {
    int getSides();
}

class Triangle implements Shape {
    public int getSides() {
	return 3;
    }
}

class Square implements Shape {
    public int getSides() {
	return 4;
    }
}

class Octagon implements Shape {
    public int getSides() {
	return 8;
    }
}

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class PeelMegamorphicCallsite {

    private java.util.Random random = new java.util.Random();

    private Shape triangle = new Trianble();
    private Shape square = new Square();
    private Shape octagon = new Octagon();

    @Benchmark
    public int runBimorphic() {
	Shape currentShape = null;

	switch (random.next(2)) {
	    case 0:
		currentShape = triangle;
		break;

	    case 1:
		currentShape = square;
		break;
	}

	return currentShape.getSides();
    }

    @Benchmark
    public int runMegamorphic() {
	Shape currentShape = null;

	switch (random.nextInt(3)) {
	    case 0:
		currentShape = triangle;
		break;

	    case 1:
		currentShape = square;
		break;

	    case 2:
		currentShape = octagon;
		break;
	}

	return currentShape.getSides();
    }

    @Benchmark
    public int runPeeledMegamorphic() {
	Shape currentShape = null;

	switch (random.nextInt(3)) {
	    case 0:
		currentShape = triangle;
		break;

	    case 1:
		currentShape = square;
		break;

	    case 2:
		currentShape = octagon;
		break;
	}

	// 원래 호출부에서 하나씩 타입을 벗겨냄
	if (currentShape instanceof Triangle) {
	    return ((Triangle) currentShape).getSides();
	} else {
	    return currentShape.getSides(); // 이형(bimorphic)
	}
    }
}
