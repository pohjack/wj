package com.testio.file;

import java.io.IOException;

public class TestFileScanner {

	public static void main(String[] args) throws IOException {
		ScanFiles scanner=new ScanFiles("e:\\资料","e:\\ScanResult.txt");
		scanner.scanFilesInDir();
	}

}
