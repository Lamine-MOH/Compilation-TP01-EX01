
public class TP01_EX01 {

    TP01_EX01() {
    }

    public static String typeOf(String word) {
        int[][] mat = { { 1, 2, 3, 7, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, -1, 4, -1 },
                { -1, -1, -1, 4, 5 }, { -1, -1, -1, 6, -1 }, { -1, -1, -1, 6, -1 }, { -1, -1, -1, 7, 8 },
                { -1, -1, -1, 9, -1 }, { -1, -1, -1, 9, -1 }

        };
        String etatFin = "1234679";

        int Ec = 0;
        char Tc = word.charAt(0);

        int index = 0;

        while ((Ec != -1) && (Tc != '#')) {
            int n = 0;
            if ("()".contains(Tc + "")) {
                n = 0;
            } else if ("*/".contains(Tc + "")) {
                n = 1;
            } else if ("+-".contains(Tc + "")) {
                n = 2;
            } else if ("0123456789".contains(Tc + "")) {
                n = 3;
            } else if (".".contains(Tc + "")) {
                n = 4;
            } else {
                Ec = -1;
                break;
            }

            Ec = mat[Ec][n];

            index++;
            Tc = word.charAt(index);
        }

        if (Ec == -1) {
            return "Mot incorrect";
        } else if (!etatFin.contains(Ec + "")) {
            return "Mot incorrect";
        }
        if (Ec == 1) {
            return "Parenthese";
        }
        if (Ec == 2) {
            return "Operation";
        }
        if (Ec == 3) {
            return "Operation";
        }
        if (Ec == 4) {
            if (word.length() - 1 <= 7) {
                return "Entier signé";
            } else {
                return "Entier signé (Maximum de 7 caracteres)";
            }
        }
        if (Ec == 6) {
            if (word.length() - 1 <= 9) {
                return "Reel signé";
            } else {
                return "Reel signé (Maximum de 9 caracteres)";
            }
        }
        if (Ec == 7) {
            if (word.length() - 1 <= 7) {
                return "Entier";
            } else {
                return "Entier (Maximum de 7 caracteres)";
            }
        }
        if (Ec == 9) {
            if (word.length() - 1 <= 9) {
                return "Reel";
            } else {
                return "Reel (Maximum de 9 caracteres)";
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(typeOf("#"));
        System.out.println();

    }

    public static String removeExtraSharp(String code) {
        boolean test = true;
        while (test == true) {
            test = false;
            int oldLength = code.length();

            code = code.replace("##", "#");
            if (code.length() < oldLength) {
                test = true;
            }
        }

        return code;
    }

    public static String splitToWords_01(String code) {

        code = code.replace(" ", "#");
        code = code.replace("\n", "#");
        code = code.replace("(", "#(#");
        code = code.replace(")", "#)#");
        code = code.replace("+", "#+#");
        code = code.replace("-", "#-#");
        code = code.replace("*", "#*#");
        code = code.replace("/", "#/#");

        code = code + "#";

        // remove extra # //
        code = removeExtraSharp(code);
        // //

        // //
        char[] codeList = code.toCharArray();
        code = "";
        // boolean numberBeforeDoit = true;

        int startIndex = 0;
        if (codeList[0] == '#') {
            startIndex = 1;
        }

        for (int i = startIndex; i < codeList.length; i++) {
            int j = i;
            if ((codeList[i] == '+' || codeList[i] == '-')
                    && (i < 2 || codeList[i - 2] == '+' || codeList[i - 2] == '-' || codeList[i - 2] == '*'
                            || codeList[i - 2] == '/' || codeList[i - 2] == '(')
                    && (i + 1 < codeList.length && "0123456789#".contains("" + codeList[i + 2]))) {
                // get the signs //
                j++;

            } else if (i > 0 && codeList[i] == '.' && !("0123456789".contains("" + codeList[i - 1]))) {
                code += "#";
            }

            code += codeList[i];

            if (i < codeList.length && codeList[i] == '.' && !("0123456789#".contains("" + codeList[i + 1]))) {
                code += "#";
            }

            i = j;
        }
        // //

        // remove extra # //
        code = removeExtraSharp(code);
        // //

        return code;
    }

    public static String splitToWords_02(String code) {

        String str = "-/()";
        String sign = "+-";
        String dot = ".";
        String space = " \n";
        String numbers = "0123456789";
        String op = "+-*/(";

        String result = "";

        for (int i = 0; i < code.length(); i++) {
            if (str.contains(code.charAt(i) + "")) {
                if (result.length() > 0 &&result.charAt(result.length() - 1) != '#') {
                    result += "#";
                }

                result += code.charAt(i);

                result += "#";
            } else if (sign.contains(code.charAt(i) + "")) {
                if (result.length() > 0 && result.charAt(result.length() - 1) != '#') {
                    result += "#";
                }

                result += code.charAt(i);

                if (!(i == 0 || op.contains(code.charAt(i - 1) + ""))
                        || !(i == code.length() - 1 || numbers.contains(code.charAt(i + 1) + ""))) {
                    result += "#";
                }
            } else if (dot.contains(code.charAt(i) + "")) {
                if (i > 0 && !numbers.contains(code.charAt(i - 1) + "") && result.charAt(result.length() - 1) != '#') {
                    result += "#";
                }

                result += code.charAt(i);

                if (i == code.length() - 1 || !numbers.contains(code.charAt(i + 1) + "")) {
                    result += "#";
                }
            } else if (space.contains(code.charAt(i) + "")) {
                if (i > 0 && result.charAt(result.length() - 1) != '#') {
                    result += "#";
                }
            } else {
                result += code.charAt(i);
            }
        }

        if (result.charAt(result.length() - 1) != '#') {
            result += "#";
        }

        return result;
    }
}
