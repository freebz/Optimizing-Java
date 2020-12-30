for (int i = 0; i < 100_000_000; i++) {
    Object mightEscape = new Object(i);

    if (condition) {
	result += inlineableMethod(mightEscape);
    } else {
	result += tooBigToInline(mightEscape);
    }
}


for (int i = 0; i < 100_000_000; i++) {

    if (condition) {
	Object mightEscape = new Object(i);
	result += inlineableMethod(mightEscape);
    } else {
	Object mightEscape = new Object(i);
	result += tooBigToInline(mightEscape);
    }
}
