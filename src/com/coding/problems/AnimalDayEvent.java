package com.coding.problems;

/**
 * During an Animal Day event, N people (numbered from 0 to N−1) showed up. Each of them had either a dog or a cat. The organizers decided to give them a wonderful gift: a toy for each animal.
 * <p>
 * After the event, it turned out that some people who owned a dog had received a cat-toy, and some people who owned a cat received a dog-toy. People may exchange toys, but only if they know each other (otherwise they have no way to contact the other person). The pair of people can exchange toys multiple times.
 * <p>
 * Knowing who knows who, who owns which animal, and what kind of toy he or she received, can you determine whether it is possible for people to exchange toys in such a way that every dog ends up with a dog-toy and every cat gets a cat-toy?
 * <p>
 * Write a function:
 * <p>
 * class Solution { public boolean solution(int[] P, int[] T, int[] A, int[] B); }
 * <p>
 * that returns true if it is possible to exchange toys in such a way that every animal receives an appropriate toy, or false otherwise. First two arrays describe the pets (array P) and toys (array T) that every person owns. The J-th person owns pet P[J] and toy T[J] (1 means dog or dog-toy and 2 means cat or cat-toy). The next two arrays, A and B, both of length M, describe the relationships between people. For each integer K from 0 to M−1, person A[K] knows person B[K].
 * <p>
 * Examples:
 * 1. Given:
 * P = [1, 1, 2]
 * T = [2, 1, 1]
 * A = [0, 2]
 * B = [1, 1]
 * <p>
 * the function should return true. Person 0 can exchange toys with person 1 to obtain a dog-toy, and then person 1 can exchange toys with person 2.
 * <p>
 * 2. Given:
 * P = [2, 2, 1, 1, 1]
 * T = [1, 1, 1, 2, 2]
 * A = [0, 1, 2, 3]
 * B = [1, 2, 0, 4]
 * <p>
 * the function should return false. There is no way for persons 3 and 4 to exchange toys with others.
 * <p>
 * 3. Given:
 * P = [1, 1, 2, 2, 1, 1, 2, 2]
 * T = [1, 1, 1, 1, 2, 2, 2, 2]
 * A = [0, 2, 4, 6]
 * B = [1, 3, 5, 7]
 * <p>
 * the function should return false. There is no way for persons 2 and 3 and for persons 4 and 5 to exchange toys with others.
 * <p>
 * 4. Given:
 * P = [2, 2, 2, 2, 1, 1, 1, 1]
 * T = [1, 1, 1, 1, 2, 2, 2, 2]
 * A = [0, 1, 2, 3, 4, 5, 6]
 * B = [1, 2, 3, 4, 5, 6, 7]
 * <p>
 * the function should return true.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [0..200,000];
 * each element of array ('P', 'T') is an integer that can have one of the following values: 1, 2;
 * each element of arrays A, B is an integer within the range [0..N−1];
 * for each integer K from 0 to M−1, elements A[K] and B[K] are different;
 * there are no redundant elements in arrays A, B; more formally every unordered pair of persons a, b will appear as A[K], B[K] for at most one K.
 */
public class AnimalDayEvent {

    /**
     * @param P pets array
     * @param T toys array
     * @param A
     * @param B
     * @return 1 = dog or dog-toy
     * 2 = cat or cat-toy
     * <p>
     * he J-th person owns pet P[J] and toy T[J
     * person A[K] knows person B[K].
     */
    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
        int numberOfPersons = P.length;
        int numberOfRelationship = A.length;

// Make swap on toy only
        for (int i = 0; i < numberOfPersons; i++) {
            if (P[i] != T[i]) {
                for (int j = 0; j < numberOfRelationship; j++) {

                    // Relationship exists
                    if (A[j] == i) {
                        // Make the swap
                        if (T[B[j]] != T[i]) {
                            int temp = T[i];
                            T[i] = T[B[j]];
                            T[B[j]] = temp;
                        }

                    }
                }
            }

        }


        for (int i = 0; i < numberOfPersons; i++) {
            if (P[i] != T[i]) {
                return false;
            }
        }
        return true;
    }
}
