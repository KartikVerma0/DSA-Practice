import java.util.ArrayList;

class FindAllTargetOccurances{
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {1,2,3,4,4,5};
		int target =4;
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(sol.findAllTarget(arr,0,target,list).toString());
		System.out.println(sol.findAllTarget2(arr,0,target).toString());
		System.out.println(sol.findAllTarget3(arr,0,target).toString());
		System.out.println(sol.findAllTarget4(arr,0,target).toString());
		}
	
	
}

class Solution{
	//Solution 1
	// Here ArrayList is passed as argument in function.
	ArrayList<Integer> findAllTarget(int[] arr,int index, int target,ArrayList<Integer> list) {
		if(index==arr.length) return list;
		if(arr[index]==target) {
			list.add(index);
		}
		return findAllTarget(arr,index+1,target,list);
	}

	//Solution 2
	// Here ArrayList is not passed as argument in function, rather the list is being made static
	// and the elements are appended in list in function.
	static ArrayList<Integer> list2 = new ArrayList<>();
	ArrayList<Integer> findAllTarget2(int[] arr, int index, int target){
		if(index==arr.length) return list2;
		if(arr[index]==target) {
			list2.add(index);
		}
		return findAllTarget2(arr,index+1,target);
	}

	//Solution 3
	// Here ArrayList is not passed as argument in function, rather the list is being made inside each function call
	// and list from furthur recusrion is combined with the list in current function call,
	// and then combined and returned above.
	static ArrayList<Integer> combineList(ArrayList<Integer> list1,ArrayList<Integer> list2){
		for(int i = 0;i<list2.size();i++){
			list1.add(list2.get(i));
		}
		return list1;
	}
	ArrayList<Integer> findAllTarget3(int[] arr,int index, int target) {
		ArrayList<Integer> list1 = new ArrayList<>();
		if(index==arr.length) return list1;
		if(arr[index]==target) {
			list1.add(index);
		}
		ArrayList<Integer> list2=findAllTarget3(arr,index+1,target);
		return combineList(list1, list2);
	}

	//Solution 4
	// Here ArrayList is not passed as argument in function, rather the list is being made inside each function call
	// and list from furthur recusrion is combined with the list in current function call,
	// and then combined (using built in function) and returned above.
	ArrayList<Integer> findAllTarget4(int[] arr,int index, int target) {
		ArrayList<Integer> list1 = new ArrayList<>();
		if(index==arr.length) return list1;
		if(arr[index]==target) {
			list1.add(index);
		}
		ArrayList<Integer> list2=findAllTarget4(arr,index+1,target);
		list1.addAll(list2);
		return list1;
	}
}