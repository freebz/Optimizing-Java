// 에어론

final MediaDriver driver = MediaDriver.launch();

final Aeron.Context ctx = new Aeron.Context();

try (Publication publication = aeron.addPublication(CHANNEL, STREAM_ID))
{...}

final long result = publication.offer(BUFFER, 0, messageBytes.length);


// 구독자

final FragmentHandler fragmentHandler =
    SamplesUtil.printStringMessage(STREAM_ID);

try (Aeron aeron = Aeron.connect(ctx);
     Subscription subscription = aeron.addSubscription(CHANNEL, STREAM_ID))
{
    SamplesUtil.subscriberLoop(fragmentHandler,
        FRAGMENT_COUNT_LIMIT, running).accept(subscription);
}
