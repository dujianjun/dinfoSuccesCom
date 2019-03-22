package com.dscexpen.basic;

public class SortFa {

	//选择排序
	public static void test11(int[]arr){
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]>arr[i]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		print(arr); 
	}
	//冒泡排序法
	public static void test22(int[]arr){
		int temp=0 ;
		for(int i=0;i<arr.length-1;i++){
			for (int j =0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}		
		print(arr); 
	}
	//冒泡排序法
	public static void test2(int[]arr){
		int temp=0;
		for (int i = arr.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		print(arr); 
	}
	//折半查找
	    public static int test3(int[]arr,int key){
	    	
	    int	min=0;
	    int max=arr.length-1;
	    int  mid=(min+max)/2;
	    
	    	while(key!=arr[mid]){
	    		if(key>arr[mid]){
	    			min=mid+1;
	    		}else if(key<arr[mid]){
	    			max=mid-1;
	    		}
	    		if(max<min){
	    			return -1;
	    		}
	    		
	    		mid=(min+max)/2;
	    	}
	    	return mid;
	    }
	   //折半查找发
	    public static int test33(int[]arr,int key){
	    	
		    int	min=0;
		    int max=arr.length-1;
		    int  mid=(min+max)/2;
		    
		    	while(min<=max){
		    		mid=(max+min)>>1;
		    	
		    		if(key>arr[mid]){
		    			min=mid+1;
		    		}else if(key<arr[mid]){
		    			max=mid-1;
		    		}
		    		else{
		    			return mid;
		    		}
		    	
		    	}
		    	return -1;
		    }
		
	
	
	
	
	
	public static void print(int[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}	
	}



	public static void main(String[] args) {
		int [] arr={1,2,3,4,5,6,7,8};
		System.out.println(test33(arr,5));
		
//		int [] arr={45,23,3,100,2,67,56,9};
//		test2(arr);
		

	}

}
