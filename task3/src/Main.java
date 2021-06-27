package com.company;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {

        Object[][] matrix = {
                {"Nice", 942208},
                {"Abu Dhabi", 1482816},
                {"Naples", 2186853},
                {"Vatican City", 572},
                {"Manila", 13923452},
                {"Kuala Lumpur", 7996830},
                {"Jakarta", 10770487}
        };
        System.out.println("Задание 1: " + first(matrix));
        System.out.println("Задание 2: " + String.format(second(3)));
        System.out.println("Задание 3: " + third("scissors", "scissors"));
        int[] mass1 = new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        System.out.println("Задание 4: " + fourth(mass1));
        System.out.println("Задание 5: " + fifth("sPoNtAnEoUs"));
        System.out.println("Задание 6: " + sixth("EvilClone"));
        System.out.println("Задание 7: " + seventh(3, 2, 7, 6, 6));
        System.out.println("Задание 8: " + eighth(36.1, 8.6, 3, true));
        double[] mass2 = {3, 3, 3, 3, 3};
        System.out.println("Задание 9: " + String.format("%.2f",ninth(mass2)));
        System.out.println("Задание 10: " + tenth(243));
    }

    private static String first(Object[][] obj ) {
        for (int i = 0; i < obj.length;i++) {
            if ((int) obj[i][1]/1000000 > 0) {
                if ((int)obj[i][1]%1000000 >= 500000)
                    obj[i][1] = ((int)obj[i][1]/1000000+1)*1000000;
                else
                obj[i][1] = ((int)obj[i][1]/1000000)*1000000;
            }
            else if((int) obj[i][1]/100000 >= 5)
                obj[i][1] = 1000000;
            else
                obj[i][1] = 0;
        }
        return Arrays.deepToString(obj);
    }

    private static String second(double a) {
        double[] othersides = new double[2];
        othersides[0] = a * 2;
        othersides[1] = Math.floor(Math.sqrt(Math.pow(othersides[0], 2)-Math.pow(a,2))*100)/100;
        return Arrays.toString(othersides);
    }

    private static String third(String p1, String p2) {
        p1.toLowerCase(Locale.ROOT);
        p2.toLowerCase(Locale.ROOT);
        if (p1.equals(p2))
            return "TIE";
        int c1;
        int c2;
        switch (p1){
            case "rock":
                c1 = 1;
                break;
            case "scissors":
                c1 = 2;
                break;
            case "paper":
                c1 = 3;
                break;
            default:
                return "ERROR";
        }
        switch (p2){
            case "rock":
                c2 = 151;
                break;
            case "scissors":
                c2 = 162;
                break;
            case "paper":
                c2 = 173;
                break;
            default:
                return "ERROR";
        }
        switch (c1+c2){
            case 153:
                p1 = "P2 wins";
                break;
            case 154:
                p1 = "P1 wins";
                break;
            case 163:
                p1 = "P1 wins";
                break;
            case 165:
                p1 = "P2 wins";
                break;
            case 174:
                p1 = "P2 wins";
                break;
            case 175:
                p1 = "P1 wins";
                break;
            default:
                return "ERROR";
        }

        return p1;
    }

    private static int fourth(int[] c1) {
        int[] even = new int[c1.length];
        int[] odd = new int[c1.length];
        int s_eve, s_odd,max,min,j,k;
        j = k = 0;
        for (int value : c1) {
            if (value % 2 == 0) {
                even[j] = value;
                j++;
            } else {
                odd[k] = value;
                k++;
            }
        }
        s_eve = IntStream.of(even).sum();
        s_odd = IntStream.of(odd).sum();

        if (s_eve > s_odd){
            max = s_eve;
            min = s_odd;
        } else if (s_eve == s_odd) {
            max = s_eve;
            min = s_odd;
        } else{
            max = s_odd;
            min = s_eve;
        }
        return max - min;
    }

    private static String fifth(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length();i++){
            if((int)s.charAt(i)>=65 && (int)s.charAt(i)<=90){
               sb.setCharAt(i,Character.toLowerCase(s.charAt(i)));
            } else if((int)s.charAt(i)>=97 && (int)s.charAt(i)<=122){
                sb.setCharAt(i,Character.toUpperCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }

    private static String sixth(String s) {
        String snew = "";
        char last = s.charAt(s.length()-1);
        switch (last) {
            case 'a':
                snew = s + "-inator " + s.length() + "000";
                return snew;
            case 'e':
                snew = s + "-inator " + s.length() + "000";
                return snew;
            case 'i':
                snew = s + "-inator " + s.length() + "000";
                return snew;
            case 'o':
                snew = s + "-inator " + s.length() + "000";
                return snew;
            case 'u':
                snew = s + "-inator " + s.length() + "000";
                return snew;
            default:
                snew = s + "inator " + s.length() + "000";
                return snew;
        }
    }

    private static boolean seventh(int a, int b, int c, int w, int h) {
        return a*b <= w*h || a*c <= w*h || b*c <= w*h;
    }

    private static double eighth(double fuel,double cons,int count,boolean ac ) {
        double ac_d, ret;
        if (ac) {
            ret = fuel / (cons +  (count * cons * 5 / 100));
            ret = ret - (ret * 0.1);
        }
        else
            ret = fuel/(cons+count*(cons*5/100));
        return ret*100;
    }

    private static double ninth(double[] mass) {
        return Arrays.stream(mass).sum()/mass.length;
    }

    private static boolean tenth(int n1) {
        String str = Integer.toString(n1);
        int sum = 0;
        for (int i = 0; i < str.length();i++){
            switch (str.charAt(i)){
                case '1':
                    sum = sum + 1;
                    break;
                case '2':
                    sum = sum + 2;
                    break;
                case '3':
                    sum = sum + 3;
                    break;
                case '4':
                    sum = sum + 4;
                    break;
                case '5':
                    sum = sum + 5;
                    break;
                case '6':
                    sum = sum + 6;
                    break;
                case '7':
                    sum = sum + 7;
                    break;
                case '8':
                    sum = sum + 8;
                    break;
                case '9':
                    sum = sum + 9;
                    break;
                case '0':
                    sum = sum + 0;
                    break;
                default:
                    System.exit(228);
            }
        }
        return sum%2 == n1%2;
    }
}
