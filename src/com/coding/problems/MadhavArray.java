package com.coding.problems;


/// <summary>
/// A Madhav array has the following property.
/// a[0] = a[1] + a[2] = a[3] + a[4] + a[5] = a[6] + a[7] + a[8] + a[9] = …
/// The length of a Madhav array must be n*(n+1)/2 for some n.
/// Write a method named isMadhavArray that returns 1 if its array argument is a Madhav array, otherwise it returns 0. If you are programming in Java or C# the function signature is
/// int isMadhavArray(int[] a)
/// If you are programming in C or C++, the function signature is
/// int isMadhavArray(int a[ ], int len) where len is the number of elements in a.
/// </summary>
/// <param name="a">the array under invstegation</param>
/// <example>
/// if a is                                         return    reason
///    {2, 1, 1}                                        1     2 = 1 + 1
///    {2, 1, 1, 4, -1, -1}                             1     2 = 1 + 1, 2 = 4 + -1 + -1
///    {6, 2, 4, 2, 2, 2, 1, 5, 0, 0}                   1     6 = 2 + 4, 6 = 2 + 2 + 2, 6 = 1 + 5 + 0 + 0
///    {18, 9, 10, 6, 6, 6}                             0     18 != 9 + 10
///    {-6, -3, -3, 8, -5, -4}                          0    -6 != 8 + -5 + -4
///    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, -2, -1}  1     0 = 0 + 0,
///                                                           0 = 0 + 0 + 0,
///                                                           0 = 0 + 0 + 0 + 0,
///                                                           0 = 1 + 1 + 1 + -2 + -1
///    {3, 1, 2, 3, 0}                                  0     The length of the array is 5,
///                                                           but 5 does not equal n*(n+1)/2 for any value of n.
/// </example>
/// <returns></returns>


public class MadhavArray {
    public int isMadhavArray(int[] a) {
        int length = a.length;

        // n*(n+1)/2 = l solve using quadratic formula x = -b + (b2 - 4ac)/2a
        int n = (int) ((-1 + Math.sqrt(1 + 8 * length)) / 2);

        int index = 0;
        int leftValue = 0;

        for (int i = 1; i <= n; i++) {
            int rightValue = 0;

            for (int j = 0; j < i; j++) {
                rightValue = rightValue + a[index];
                index++;
            }

            if (i != 1) {
                if (leftValue != rightValue) {
                    return 0;
                }
            }
            leftValue = rightValue;
        }
        return 1;
    }
}
