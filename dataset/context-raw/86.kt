/*
*
*
*
*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
Accepted
5,872,105
Submissions
12,180,827
*
*
*
*
*
*
*
* */



/**
*
Solution
*
 Summary : Given the array and the target we find the complement of each integer in the
 array and add it to a key value pair data structure. We will be using a map in this tutorial.
 We store the complement as a key and it's index as the value. As we iterate through the loop
 we check through the list of keys to see if our current number exists. If it exits then we can return
 the required indexes.
 *
 *
 1. Corner Case - if @param[nums] we return an integer array of 00
 2. Create a key-value pair to hold the complement, and it's index
 3. As we Iterate, we calculate the current complement
 4. Check if the current value @param[nums[i]] exists in the complements(keys)
 5. Return the value of the complement (index) and the current index if "step 4" is true
 6. We then add if "Step 4" is false
 7. Return an intArrayOf (0,0) if we did not find the target indexes.

*
* */

fun main(){

    println(twoSum(intArrayOf(2,7,11,15),9).asList())

    
}

fun twoSum(nums: IntArray, target: Int): IntArray {



    /**
     * Corner Case
     * if  @param[nums] we return intArrayOf(0,0)
     * */
    //1
    if (nums.isEmpty()) return intArrayOf(0,0)

    //2
    val complements = mutableMapOf<Int,Int>()
    for(i in nums.indices){
        //3
        var complement = target.minus(nums[i])

        //4
        if(nums[i] in complements.keys ){
            //5
            return intArrayOf(complements.get(nums[i])!!,i)
        }

        //6
        complements.put(complement,i)

    }
    //7
    return intArrayOf(0,0)

}


