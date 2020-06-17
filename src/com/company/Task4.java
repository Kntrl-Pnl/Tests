package com.company;

import static java.lang.System.out;

public class Task4 {
    public static void main(String[] msi) {
        out.println(textEdit(10,7, "hello my name is Bessie and this is my essay"));
        out.println(split("() () ()"));
        out.println(toCamelCase("hello_ed"));
        out.println(toSnakeCase("helloEd"));
        out.println(overTime(9,17,30,1.5));
        out.println(BMI("205 pounds", "73 inches"));
        out.println(bugger(39));
        out.println(toStarShorthand("abbccc"));
        out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        out.println(trouble(451999277, 722899));
        out.println(countUniqueBooks("AZKJHVBSKJDHCVB", 'A'));

    }

    //Test1
    static String textEdit(int n, int k, String s) {
        StringBuilder resultText = new StringBuilder();
        int lenght = 0;
        while (s.indexOf(" ") == 0)
            s = s.substring(1);
        while (s.indexOf("  ") != -1)
            s = s.substring(0, s.indexOf("  ")) + s.substring(s.indexOf("  ") + 1);

        String[] text = s.split(" ");
        if (text.length == n) {
            for (String word : text)
                if (word.length() > k) {
                    return "can't split";
                } else if (lenght + word.length() <= k) {
                    lenght += word.length();
                    resultText.append(word).append(" ");
                } else {
                    lenght = word.length();
                    resultText.append("\n").append(word).append(" ");
                }
        } else
            return "can't split";
        return resultText.toString();
    }

    //Test2
    static String split(String s) {
        int l = 0;
        String result = "\"";
        for (char c : s.toCharArray()) {
            l += c == '(' ? 1 : -1;
            result += l == 0 ? c + "\" \"" : c;
        }
        return result.substring(0, result.length() - 2);
    }

    //Test3
    static String toCamelCase(String snake) {
        while (snake.contains("_"))
            snake = snake.substring(0, snake.indexOf("_")) +
                    Character.toUpperCase(snake.charAt(snake.indexOf("_") + 1)) +
                    snake.substring(snake.indexOf("_") + 2);
        return snake;
    }

    static String toSnakeCase(String camel) {
        String result = "";
        for (char c : camel.toCharArray())
            result += Character.isUpperCase(c) ? "_" + Character.toLowerCase(c) : c;
        return result;
    }

    //Test4
    static String overTime(int start, int end, double pay, double overtime) {
        return String.format("$" + "%.2f", end <= 17 ? (end - start) * pay : (end - start) * pay + (end - 17) * overtime);
    }

    //Test5
    static String BMI(String weight, String height) {
        double h = Double.parseDouble(height.substring(0, height.indexOf(" ")));
        double w = Double.parseDouble(weight.substring(0, weight.indexOf(" ")));

        h = height.contains("inches") ? 0.0254 * h : (height.contains("meters") ? h : 0);
        w = weight.contains("pounds") ? 0.453592 * w : (weight.contains("kilos") ? w : 0);

        double bmi = h != 0 ? Math.round(10 * w / (h * h)) / 10.0 : 0;
        return bmi == 0 ? "Incorrect line" : (bmi <= 18.4 ? bmi + " Недостаточный вес" : (bmi >= 25 ? bmi + " Избыточный вес" : bmi + " Нормальный вес"));
    }

    //Test6
    static int bugger(int a) {
        if (a < 10) return 0;
        int ch = 1;
        while (a != 0) {
            ch *= (a % 10);
            a /= 10;
        }
        return 1 + bugger(ch);
    }

    //Test7
    static String toStarShorthand(String s) {
        s += " ";
        int count = 1;
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) count++;
            else {
                result += count == 1 ? s.charAt(i) : s.charAt(i) + "*" + count;
                count = 1;
            }
        }
        return result;
    }

    //Test8
    static boolean doesRhyme(String a, String b) {
        String la = a.split(" ")[a.split(" ").length - 1].replaceAll("[!.?]", "");
        System.out.println(la);
        String lb = b.split(" ")[b.split(" ").length - 1].replaceAll("[!.?]", "");
        return lb.toLowerCase().endsWith(la.toLowerCase());
    }

    //Test9
    static boolean trouble(long a, long b) {
        int count = 1;
        String first = String.valueOf(a);
        String second = String.valueOf(b);
        for (int i = 0; i < first.length() - 1; i++) {
            count += first.charAt(i) == first.charAt(i + 1) ? 1 : -count + 1;
            if (count == 3 & second.contains(first.charAt(i) + "" + first.charAt(i)))
                return true;
        }
        return false;
    }

    //Test10
    static int countUniqueBooks(String stringSequence, char bookEnd) {
        int i = 0;
        int k = 0;
        String res = "";
        for (String s : stringSequence.split(Character.toString(bookEnd)))
            if (i++ % 2 == 1)
                for (char c : s.toCharArray())
                    if (res.indexOf(c) == -1) res += c;
        return res.length();
    }
}
