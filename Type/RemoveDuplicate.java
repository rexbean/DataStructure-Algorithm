

class RemoveDuplicate{
    public static void remove(int[] nums){
      if(nums == null || nums.length == 0){
        return;
      }

      int left = 0;
      int right1 = 0;
      int right2 = 1;

      while(right1 < nums.length){
        if(nums[left] != nums[right1]){

          if(right2 < nums.length && nums[right1] != nums[right2]){

            left++;
                        nums[left] = nums[right1];

          } else {
            right1++;
            right2++;
          }
        }
        right1++;
        right2++;
      }
      for(int i = 0; i < left + 1; i++){
         System.out.print(nums[i]);
      }
      System.out.println();

    }

    public static void main(String[] args){
      System.out.println("test case 1");
      int[] test1 = new int[]{1,2,3,4,5,6};
      remove(test1);

      System.out.println("test case 2");
      int[] test2 = new int[]{1,1,2,2,3,3,4,4};
      remove(test2);

      System.out.println("test case 3");
      int[] test3 = new int[]{1};
      remove(test3);

      System.out.println("test case 4");
      int[] test4 = new int[]{1,1,1,2,2,3,4,5,5,5,6};
      remove(test4);

      System.out.println("test case 5");
      int[] test5 = new int[]{1,2,2,3,3,4,5,5,5};
      remove(test5);


    }
}
