/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int sum = 0;
        do{
            sum = 0;
            for (int i = 0; i < 10; i++)
                sum += rand7();
        }while(sum == 70);
        return sum % 10 + 1;
    }
}
