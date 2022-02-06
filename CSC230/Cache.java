
public class Cache {
	String name;
	int addressSize, wordSize, blockSize, numLines, offsetBits, blockNumBits, index, tagSize, wordSizeBytes, numWords,
			blockSizeBytes, totalCacheSize, blockAddress, offset, offsetSize, tag, indexSize;
	long totalBytes;

	boolean[] valid;
	int[] tags;
	private int totalRequests;
	private int totalHits;

	Cache(String name, int addressSize, int wordSize, int blockSize, int numLines) {
		this.name = name;
		this.addressSize = addressSize;
		this.wordSize = wordSize;
		this.blockSize = blockSize;
		this.numLines = numLines;

		valid = new boolean[numLines];
		for (int i = 0; i < numLines; i++) {
			valid[i] = false;
		}
		tags = new int[numLines];

		blockSizeBytes = blockSize * (wordSize / 8);

		totalBytes = (long) Math.pow(2, addressSize);
		wordSizeBytes = wordSize / 8;
		numWords = (int) (totalBytes / wordSizeBytes);
		tagSize = (int) (addressSize - (Math.log(numLines) / Math.log(2)) - (Math.log(blockSizeBytes) / Math.log(2)));
		totalCacheSize = numLines * (1 + (tagSize + (blockSize * wordSize)));
		offsetSize = (int) (Math.log(blockSizeBytes) / Math.log(2));
		indexSize = (int) (Math.log(numLines) / Math.log(2));

	}

	public void readLocation(int address) {

		blockAddress = address / blockSizeBytes;
		offset = address % blockSizeBytes;
		tag = address >> (offsetSize + indexSize);
		String result = "Miss";
		totalRequests++;
		index = ((address / blockSizeBytes) % numLines);

		if (valid[index] == true && tags[index] == tag) {
			result = " ** Hit **";
			totalHits++;
		}

		valid[index] = true;
		tags[index] = tag;

		System.out.printf(" Read Mem    : %d (%s)\n", address, binary(address, addressSize));
		System.out.printf("  Block Addr : %d (%s)\n", blockAddress, binary(blockAddress, (addressSize - offsetSize)));
		System.out.printf("  Offset     : %d (%s)\n", offset, binary(offset, offsetSize));
		System.out.printf("  Tag        : %d (%s)\n", tag, binary(tag, tagSize));
		System.out.printf("  Result: %s\n", result);

	}

	public void print() {

		System.out.printf("********** %s Cache Size Report **********\n", name);
		System.out.printf("   Memory  : %d words of %d bits (%d bytes)\n", numWords, wordSize, totalBytes);
		System.out.printf(
				"   Cache   : %d lines with %d bits of tag, 1 bit for the valid flag and %d words of data each (%d bits)\n\n",
				numLines, tagSize, blockSize, totalCacheSize);
	}

	public void stats() {
		int totalMiss = totalRequests - totalHits;
		double hitRatio = (100 * (double) totalHits) / (double) totalRequests;
		double missRatio = (100 * (double) totalMiss) / (double) totalRequests;
		System.out.println("**********");
		System.out.printf("********** %s Cache Stats Report\n", name);
		System.out.println("********** Fall 2021");
		System.out.println("**********");
		System.out.printf("Requests: %d\n", totalRequests);
		System.out.printf("Hits    : %d (%.02f%%)\n", totalHits, hitRatio);
		System.out.printf("Misses  : %d (%.02f%%)\n", totalMiss, missRatio);

	}

	private String binary(int x, int size) {
		return String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0").substring(32 - size);
	}

}
