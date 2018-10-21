/**
 * 
 */
package com.fuji.test;

import java.io.File;
import java.io.IOException;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * 测试文件递归
 * @author 860618058
 *
 */
public class TestFile {
	private static int depth=1;
	
	public static void find(String pathName,int depth) throws IOException{
		int fileCount =0;
		//1，获取pathName的File对象
		File dirFile = new File(pathName);
		//2，判断该文件或者目录是否存在，不存在输出提醒
		if(!dirFile.exists()){
			System.out.println("不存在此目录或者文件");
			return;
		}
		//3.判断如果文件不是一个目录，判断是不是一个文件，是文件就输入路径
		if(!dirFile.isDirectory()){
			if(dirFile.isFile()){
				System.out.println(dirFile.getCanonicalFile());
			}
			return;
		}
		for (int i = 0; i < depth; i++) {
			System.out.println(" "+depth);
		}
		System.out.println("|--");
		System.out.println(dirFile.getName());
		//4.获取词目录下的所有文件名和目录名的字符串数组
		String [] fileList = dirFile.list();
		//5.如果是一个目录，搜索深度currentPath+1，输出目录路径后，进行递归
		int currentDepth = depth+1;
		for (int i = 0; i < fileList.length; i++) {
			//遍历文件目录
			String string =fileList[i];
			File file = new File(dirFile.getPath(),string);
			String name = file.getName();
			if(file.isDirectory()){
				find(file.getCanonicalPath(),currentDepth);
			}else {
				for (int j = 0; j < currentDepth; j++) {
					System.out.println("");
				}
				System.out.print("|--");
				System.out.println(name);
			}
		}
		//6.如果是文件，则直接输入文件名

		
	}


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		find("D:/material", depth);
	}

}
