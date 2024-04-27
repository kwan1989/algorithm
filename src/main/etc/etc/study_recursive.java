package etc.etc;

public class study_recursive {

    public static void main(String[] args) {
//        System.out.println(recursive(5));
        System.out.println(recursive1(4));
        System.out.println(recursive1(3));
        System.out.println(recursive1(2));
        System.out.println(recursive1(1));
    }

    public static int recursive(int n){
        int sum = 0;
        if (n>2){
            sum = recursive(n-1) + recursive( n-2);
            System.out.println(sum);
        } else {
            sum = n;
        }

        return sum;
    }

    public static int recursive1(int n){
        int sum = 0;
        if (n>2){
            sum = recursive1(n-1);
        } else {
            sum = n;
        }

        return sum;
    }


    /*
    5
    - 4/3



    3
     */
}
