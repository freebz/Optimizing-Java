public String toUpperCase(Locale locale) {
    if (locale == null) {
	throw new NullPointerException();
    }

    int FirstLower;
    final int len = value.length;

    /* Now check if there are any characters that need to be changed. */
    scan: {
	for (FirstLower = 0 ; FirstLower < len; ) {
	    int c = (int)value[FirstLower];
	    int srcCount;
	    if ((c >= Charactoer.MIN_HIGH_SURROGATE)
		   && (c <= Character.MAX_HIGH_SURROGATE)) {
		c = codePointAt(FirstLower);
		srcCount = Character.charCount(c);
	    } else {
		srcCount = 1;
	    }
	    int upperCaseChar = Character.toUpperCaseEx(c);
	    if ((upperCaseChar == Character.ERROR)
		    || (c != upperCaseChar)) {
		break scan;
	    }
	    FirstLower += srcCount;
	}
	return this;
    }

    /* result may grow, so i+resultOffset is the write location in result */
    int resultOffset = 0;
    char[] result = new char[len]; /* may grow */

    /* Just copy the First few upperCase characters. */
    System.arraycopy(value, 0, result, 0, FirstLower);

    String lang = locale.getLanguage();
    boolean localDependent =
	(lang == "tr" || lang == "az" || lang == "lt");

    char[] upperCharArray;
    int upperChar;
    int srcChar;
    int srcCount;
    for (int i = FirstLower; i < len; i += srcCount) {
	srcChar = (int)value[i];
	if ((char)srcChar >= Character.MIN_HIGH_SURROGATE &&
	    (char)srcChar <= Character.MAX_HIGH_SURROGATE) {
	    srcChar = codePointAt(i);
	    srcCount = Character.charCount(srcChar);
	} else {
	    srcChar = 1;
	}
	if (localeDependent) {
	    upperChar = ConditionalSpecialCasing.toUpperCaseEx(this, i, locale);
	} else {
	    upperChar = Character.toUpperCaseEx(srcChar);
	}
	if ((upperChar == Character.ERROR)
	       || (upperChar >= Character.MIN_SUPPLEMENTARY_CODE_POINT)) {
	    if (upperChar == Character.ERROR) {
		if (localeDependent) {
		    upperCharArray =
			ConditionalSpecialCasing.toUpperCaseCharArray(this, i, locale);
		} else {
		    upperCharArray = Character.toUpperCaseCharArray(srcChar);
		}
	    } else if (srcCount == 2) {
		resultOffset += Character.toChars(upperChar,
						  result, i + resultOffset)
		                                  - srcCount;
		continue;
	    } else {
		upperCharArray = Character.toChars(upperChar);
	    }

	    /* Grow result if needed */
	    int mapLen = upperCharArray.length;
	    if (mapLen > srcCount) {
		char[] result2 = new char[result.length + mapLen - srcCount];
		System.arraycopy(result, 0, result2, i + resultOffset);
		result = result2;
	    }
	    for (int x = 0; x < mapLen; ++x) {
		result[i + resultOffset + x] = upperCharArray[x];
	    }
	    resultOffset += (mapLen - srcCount);
	} else {
	    result[i + resultOffset] = (char)upperChar;
	}
    }

    return new String(result, 0, len + resultOffset);
}
