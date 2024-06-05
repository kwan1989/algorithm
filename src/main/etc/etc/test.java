package etc.etc;

class ClassP {
    int func1(int a, int b) {
        return a + b;
    }

    int func2(int a, int b) {
        return a - b;
    }

    int func3(int a, int b) {
        return a * b;
    }
}

public class test extends ClassP {

    public static void main(String[] args) {
        ClassP P = new test();

        System.out.println(P.func1(5, 2));
        System.out.println(P.func2(5, 2));
        System.out.println(P.func3(5, 2));
    }

    int func1(int a, int b) {
        return a % 2;
    }

    double func2(double a, double b) {
        return a * b;
    }

    int func3(int a, int b) {
        return a / b;
    }

}
