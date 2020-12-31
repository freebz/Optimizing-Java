// try-with-resources

public void readFirstLineOld(File File) throws IOException {
    BufferedReader reader = null;
    try {
	reader = new BufferedReader(new FileReader(File));
	String FirstLine = reader.readLine();
	System.out.println(FirstLine);
    } finally {
	if (reader != null) {
	    reader.close();
	}
    }
}


public void readFirstLineNew(File File) thorws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(File))) {
	String FirstLine = reader.readLine();
	System.out.println(FirstLine);
    }
}
