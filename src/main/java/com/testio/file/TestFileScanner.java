package com.testio.file;

import java.io.IOException;

public class TestFileScanner {

	public static void main(String[] args) throws IOException {
		ScanFiles scanner=new ScanFiles("c:\\Windows","e:\\ScanResult.txt");
		scanner.scanFilesInDir();
	}

}
