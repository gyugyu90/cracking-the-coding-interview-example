package bigO;


public class Examples {

    // Example 1) O(n)
    private void foo(int[] array) {
        int sum = 0;
        int product = 1;

        for (int item : array) {
            sum += item; // n
        }

        for (int value : array) {
            product *= value; // n
        }

        System.out.println(sum + ", " + product);
    }

    // Example 2) O(n^2)
    private void printPairs(int[] array) {
        for (int item : array) {
            for (int value : array) {
                System.out.println(item + ", " + value); // n^2
            }
        }
    }

    // Example 3) N(N-1)/2 => O(n^2)
    private void printUnorderedPairs(int[] array) {
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }

    // Example 4) O(ab) ... 다른 두 개의 array이기 때문
    private void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int item : arrayA) {
            for (int value : arrayB) {
                if (item < value) {
                    System.out.println(item + "," + value);
                }
            }
        }
    }

    // Example 5) O(ab) ... 100000ab 에서 상수 제거
    private void printUnorderedPairs2(int[] arrayA, int[] arrayB) {
        for (int item : arrayA) {
            for (int value : arrayB) {
                for(int k = 0; k < 100000; k++) {
                    System.out.println(item + "," + value);
                }
            }
        }
    }

    // Example 6) O(n) ... n/2이지만 1/2도 상수니까 제거
    private void reverse(int[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }

    // Example 9) O(n) => 균형 이진 트리의 합.. => O(노드의갯수^깊이)
    private int sum(Node node) {
        if(node == null) {
            return 0;
        }
        return sum(node.getLeft()) + node.getValue() + sum(node.getRight());
    }

    // Example 10) O(√n)
    private boolean isPrime(int n) {
        for(int x = 2; x <= Math.sqrt(n); x++) {
            if(n % x == 0) {
                return false;
            }
        }
        return true;
    }

    // Example 11) O(n)
    private int factorial(int n) {
        if(n < 0)
            return -1;
        else if (n == 0)
            return 1;
        else
            return n * factorial(n -1);
    }

    // Example 12) O(n^2 * n!)
    private void permutation(String str) {
        permutation(str, "");
    }

    private void permutation(String str, String prefix) {
        if(str.length() == 0) {
            System.out.println(prefix);
        } else {
            for(int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Examples examples = new Examples();
        examples.permutation("abcd");
    }

    // Example 13) O(2^n) or O(1.6^n)
    private int fibonacci(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Example 14) => O(2^n) or O(1.6^n)
    private void allFib(int n) {
        for (int i=0; i<n; i++) {
            System.out.println(i + ": " + fibonacci(i));
        }
    }

    // Example 15) => O(n)
    private void allFibWithCache(int n) {
        int[] cache  = new int[n + 1];
        for (int i=0; i<n; i++) {
            System.out.println(i + ": " + fibonacci(i, cache));
        }
    }

    private int fibonacci(int n, int[] cache) {
        if(n <= 0) return 0;
        else if(n == 1) return 1;
        else if(cache[n] > 0) return cache[n];

        cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
        return cache[n];
    }

    // Example 16) O(log n)
    private int powersOf2(int n) {
        if(n < 1) {
            return 0;
        } else if(n == 1){
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

}
