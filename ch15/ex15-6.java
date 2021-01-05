// 자바 9 Unsafe 그 너머

module jdk.unsupported {
    exports sun.misc;
    exports sun.reflect;
    exports com.sun.nio.File;

    opens sun.misc;
    opens sun.reflect;
}
