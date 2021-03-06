
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		sc.close();
		
		if(s.length() != t.length())
			System.out.println("Error: The two strings do not have the same length.");
		else
		{
			//We make a matrix of possible changes that need to be made for each letter.
			//If we can fix two issues with one swap (i.e., character X needs to change
			//to character Y, and vice versa), then we do so.
			//Otherwise, we try to fix just one issue with a swap.

			int length = s.length();
			int distance = 0;
			int[][] changes = new int[26][26];
			for(int i = 0; i < 26; i++)
			{
				for(int j = 0; j < 26; j++)
					changes[i][j] = -1;
			}
			
			for(int i = 0; i < length; i++)
			{
				if(s.charAt(i) != t.charAt(i))
				{
					distance++;
					int ind1 = (int)s.charAt(i) - (int)'a';
					int ind2 = (int)t.charAt(i) - (int)'a';
					changes[ind1][ind2] = i + 1; //Change to 1-based index.
				}
			}
			
			//Check for a way to fix two errors
			for(int i = 0; i < 26; i++)
			{
				for(int j = i + 1; j < 26; j++)
				{
					if(changes[i][j] > 0 && changes[j][i] > 0)
					{
						System.out.println(distance - 2);
						System.out.println(Integer.toString(changes[i][j]) + " " + Integer.toString(changes[j][i]));
						System.exit(0);
					}
				}
			}
			
			//Check for a way to fix one error
			for(int i = 0; i < 26; i++)
			{
				for(int j = 0; j < 26; j++)
				{
					for(int k = 0; k < 26; k++)
					{
						if(changes[i][j] > 0 && changes[j][k] > 0)
						{
							System.out.println(distance - 1);
							System.out.println(Integer.toString(changes[i][j]) + " " + Integer.toString(changes[j][k]));
							System.exit(0);
						}
					}
				}
			}
			
			System.out.println(distance);
			System.out.println("-1 -1");
		}
	}

}
