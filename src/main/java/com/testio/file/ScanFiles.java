package com.testio.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
/*
 * 打印文件夹下所有文件，以及文件夹（树状）
 */
public class ScanFiles {
	 int dirDeep;//文件夹深度
	 String filePath;
	 String destPath;
	 String temp;
	 char[] tempchar;
	 FileWriter writer;
	 
	 public ScanFiles(String filePath,String destPath){
		 this.filePath=filePath;
		 this.destPath=destPath;
		 try {
			this.writer=new FileWriter(destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	
	@Test
	public void scanFilesInDir() throws IOException{
//		String dirPath="E:\\weixin";
//		String dirPath="E:\\资料\\Java学习资料";
		String dirPath=this.filePath;
		writer.write(dirPath+"\r\n");
		writer.flush();
		System.out.println(dirPath);
		File file=new File(dirPath);
		File[] files=file.listFiles();
		if(files==null||files.length==0){
			return;
		} 
		this.dirDeep=0;
		long start=System.currentTimeMillis();
		for(File f:files){
			this.readFiles(f);
		}
		long end =System.currentTimeMillis();
		System.out.println("扫描完成，扫描路径："+this.filePath+"\n"+"耗时"+(long)((end-start)/1000)+"秒"+"\n"+"扫描结果路径："+this.destPath);
	}
	private void readFiles(File file) throws IOException{
		if(file.isDirectory()){
			this.temp="    "+this.formate(dirDeep)+"   |---"+file.toString()+"\r\n";
			writer.write(temp);
			writer.flush();
			System.out.println("    "+this.formate(dirDeep)+"   |---"+file.toString());
			this.dirDeep+=1;
			File[] files=file.listFiles();
			if(files==null||files.length==0){
				return;
			}
			for(File f:files){
				this.readFiles(f);
			}
			this.dirDeep-=1;
		}else{
			this.temp="    "+this.formate(dirDeep)+"   |---"+file.getName()+"\r\n";
			writer.write(temp);
			writer.flush();
			System.out.println("    "+this.formate(dirDeep)+"   |---"+file.getName());
		}
	}
	private String formate(int deep){
		StringBuffer tag=new StringBuffer();
		for(int i=0;i<deep;i++){
			tag.append("  ");
		}
		return tag.toString();
	}
	
}
