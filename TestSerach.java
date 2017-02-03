package org.ephermer.test;

import org.ephermer.search.*;

public class TestSerach {
	static String sBuffer = "addfaccddbsadghtyhvxbcvXZcwecvsfdgtrjghmijlktdhdfberktjqrgikjiocxbjsaijnfgabricefeabricecececerytyjbmnjkyrufgzdsdfcabcbsdafsdfasdfabrcefbcfabsdfsdfsdfsdfsdfasdvxcvaabcsdfwerdfdceeeeeeaaaaafabricedd";
	static String sPattern = "fabrice";
	static int offset = -1;
	static int times = 10000;
	static long startTime;
	static long endTime;

	public static void main(String[] args) {
		try{
			long sumTime = 0;			
			for(int i=0;i<times;i++){
				startTime = System.nanoTime();
				offset = sBuffer.indexOf(sPattern);
				endTime = System.nanoTime();			
				sumTime += endTime - startTime;
			}
			System.out.println("average time spend " + sumTime/times);
			if(offset!=-1){
				System.out.println(sBuffer.substring(offset, offset+sPattern.length()));			
			}else{
				System.out.println("String not found");
			}	
	
			sumTime = 0;
			offset = -1;	
			for(int i=0;i<times;i++){
				startTime = System.nanoTime();
				offset = BMAlgo.searchPattern(sBuffer,sPattern);
				endTime = System.nanoTime();			
				sumTime += endTime - startTime;			
			}

			System.out.println("average time spend of BM Algo " + sumTime/times);
			if(offset!=-1){
				System.out.println(sBuffer.substring(offset, offset+sPattern.length()));			
			}else{
				System.out.println("String not found");
			}	
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
