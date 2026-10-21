class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        if not digits:
            return []
        ph= {
            '2':'abc',
            '3':'def',
            '4':'ghi',
            '5':'jkl',
            '6':'mno',
            '7':'pqrs',
            '8':'tuv',
            '9':'wxyz'
        }

        res= ['']

        for i in digits:
            temp= []

            for c in res:
                for ch in ph[i]:
                    temp.append(c+ch)
            res= temp

        return res
