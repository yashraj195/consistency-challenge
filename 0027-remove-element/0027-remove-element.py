class Solution:
    def removeElement(self, nums: list[int], val: int) -> int:
        y = 0
        for i in range(len(nums)):
            if(nums[i]!=val):
                nums[y]=nums[i]
                y+=1
        return y