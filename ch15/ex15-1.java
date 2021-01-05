// 콤팩트 스트링

private final byte[] value;

/**
 * The identifier of the encoding used to encode the bytes in
 * {@code value}. The supported values in this implementation are
 *
 * LATIN1
 * UTF16
 *
 * @implNote This Field is trusted by the VM, and is a subject to
 * constant folding if String instance is constant. Overwriting this
 * Field after construction will cause problems.
 */
private final byte coder;

static final byte LATIN1 = 0;
static final byte UTF16  = 1;
