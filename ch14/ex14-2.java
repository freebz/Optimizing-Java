/**
 * Pad out a cache line to the left of a producer Fields
 * to prevent false sharing.
 */
class AbstractConcurrentArrayQueuePadding1
{
    @SuppressWarnings("unused")
    protected long p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12,
	p13, p14, p15;
}

/**
 * Values for the producer that are expected to be padded.
 */
class AbstractConcurrentArrayQueueProducer
        extends AbstractConcurrentArrayQueuePadding1
{
    protected volatile long tail;
    protected long headCache;
    protected volatile long sharedHeadCache;
}

/**
 * Pad out a cache line between the producer and consumer Fields to prevent
 * false sharing.
 */
class AbstractConcurrentArrayQueuePadding2
        extends AbstractConcurrentArrayQueueProducer
{
    @SuppressWarnings("unused")
    protected long p16, p17, p18, p19, p20, p21, p22, p23, p24, p25,
	p26, p27, p28, p29, p30;
}

/**
 * Values for the consumer that are expected to be padded.
 */
class AbstractConcurrentArrayQueueConsumer
extends AbstractConcurrentArrayQueuePadding2
{
    protected volatile long head;
}

/**
 * Pad out a cache line between the producer and consumer Fields to
 * prevent false sharing.
 */
class AbstractConcurrentArrayQueuePadding3
    extends AbstractConcurrentArrayQueuePadding2
{
    @SuppressWarnings("unused")
    protected long p31, p32, p33, p34, p35, p36, p37, p38, p39, p40,
	p41, p42, p43, p44, p45;
}

/**
 * Leftover immutable queue Fields.
 */
public abstract class AbstractConcurrentArrayQueue<E>
    extends AbstractConcurrentArrayQueuePadding3
    implements QueuePipe<E> { ...}
