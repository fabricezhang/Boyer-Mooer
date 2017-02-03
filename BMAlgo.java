package org.ephermer.search;

public class BMAlgo {	
	
	public static int searchPattern(String sBuffer, String sPattern){				
		int lPattern = sPattern.length();
		int lBuffer = sBuffer.length();
		// Set Anchor sPoint
		int anchor = lPattern-1;
		boolean flag;		
		
		if(null == sBuffer || null == sBuffer || lPattern>lBuffer){
			return -1;			
		}
		
		while(anchor<=lBuffer){
			flag = true;
			// compare each character from distance 0->length-1			
			for(int d= 0;flag==true && d<lPattern;d++){
				if(sBuffer.charAt(anchor-d)!=sPattern.charAt(lPattern-1-d)){
					// move anchor 
					// TODO add example to explain
					int tmp =sPattern.lastIndexOf(sBuffer.charAt(anchor-d),lPattern-d-1);
					anchor += (lPattern - 1 - tmp);
					flag = false;
					break;
				}				
			}
			if(true==flag){
				anchor -= (lPattern-1);
				return anchor;					
			}
		}
		return -1;
	}
}
