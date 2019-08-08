
import java.util.Hashtable;

/*
 * Function Description

Complete the checkMagazine function in the editor below. It must print  if the note can be formed using the magazine, or .

checkMagazine has the following parameters:

magazine: an array of strings, each a word in the magazine
note: an array of strings, each a word in the ransom note
Input Format

The first line contains two space-separated integers,  and , the numbers of words in the  and the .. 
The second line contains  space-separated strings, each . 
The third line contains  space-separated strings, each .

Constraints

.
Each word consists of English alphabetic letters (i.e.,  to  and  to ).
Output Format

Print Yes if he can use the magazine to create an untraceable replica of his ransom note. Otherwise, print No.

Sample Input 0

6 4
give me one grand today night
give one grand today
Sample Output 0

Yes
Sample Input 1

6 5
two times three is not four
two times two is four
Sample Output 1

No
Explanation 1

'two' only occurs once in the magazine.

Sample Input 2

7 4
ive got a lovely bunch of coconuts
ive got some coconuts
Sample Output 2

No
Explanation 2

Harold's magazine is missing the word some.
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    static void checkMagazine(String[] magazine, String[] note) {

        Hashtable<String,Integer> magTable = new Hashtable<String,Integer>();

        for (String magazine1 : magazine) {
            if (magTable.containsKey(magazine1)) {
                magTable.put(magazine1, magTable.get(magazine1) + 1);
            } else {
                magTable.put(magazine1, 1);
            }
        }

        int i=0;

        boolean found=false;

        while(i<note.length && !found)
        {
            if(!magTable.containsKey(note[i]))
            {
                found=true;
            }
            else
            {
                int counter = magTable.get(note[i]);

                counter--;

                if(counter==0)
                {
                    magTable.remove(note[i]);
                }
                else
                {
                    magTable.put(note[i],counter);
                }

            }
            i++;
        }

        if(!found)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

    }
    
    
}
