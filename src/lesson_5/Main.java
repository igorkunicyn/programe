package lesson_5;



public class Main {

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120, 50};

        int wt[] = new int[]{10, 5, 30, 6};

        int W = 50;

        int n = val.length;

        System.out.println(knapSack(W, wt, val, n));

//        System.out.println(fact(5));
//        System.out.println(recFact(5));

//        System.out.println(fibo(47));
//        System.out.println(recFibo(10));

//        System.out.println(triangleNum(5));
//        System.out.println(recTriangleNum(5));

//        System.out.println(recMultiply(3,8));
//        System.out.println(recOperand(3,0));
    }
    public static int fact(int n) {
    int f = 1;
    for (int i = 2; i <= n; i++) {
        f *= i;
    }
    return f;
}

    public static int recFact(int n) {
        if (n == 1) {
            return 1;
        }
        return recFact(n - 1) * n;
    }

    public static long fibo(long n) {
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    public static long recFibo(long n) {
        System.out.print(n + " ");
        if (n < 3) {
            return 1;
        }

        return recFibo(n - 1) + recFibo(n - 2);
    }

    public static long triangleNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long recTriangleNum(int n) {
        if (n == 1) {
            return 1;
        }
        return recTriangleNum(n - 1) + n;
    }

    public static int multiply(int a, int b) {
        int value = 0;
        for (int i = 0; i < b; i++) {
            value += a;
        }
        return value;
    }

    public static int recMultiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return recMultiply(a, b - 1) + a;
    }

//    домашнее задание
    public static double recOperand(double a, double b) {
        if (b > 0) {
            if (b == 1) {
                return a;
            }
            return recOperand(a, (b - 1)) * a;
        } else if (b < 0) {
            if (b == -1) {
                return 1 / a;
            }
            return recOperand(a, (b + 1)) * 1 / a;
        }
        return 1;
    }


    static int max(int a, int b) { return (a > b) ? a : b; }

    static int knapSack(int W, int wt[], int val[], int n){
        if (n == 0 || W == 0)
            return 0;
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        else
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }
}
