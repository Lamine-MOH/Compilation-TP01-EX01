
public class TP01_EX01 {

    TP01_EX01() {
    }

    public static String splitToWords(String code) {

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
        boolean test = true;
        while (test == true) {
            test = false;
            int oldLength = code.length();

            code = code.replace("##", "#");
            if (code.length() < oldLength) {
                test = true;
            }
        }
        // //

        // //
        char[] codeList = code.toCharArray();
        code = "";
        boolean numberBeforeDoit = true;

        if (codeList[0] == '#') {
            codeList[0] = ' ';
        }

        for (int i = 0; i < codeList.length; i++) {
            int j = i;
            if ((codeList[i] == '+' || codeList[i] == '-')
                    && (i < 2 || codeList[i - 2] == '+' || codeList[i - 2] == '-' || codeList[i - 2] == '*'
                            || codeList[i - 2] == '/' || codeList[i - 2] == '(')
                    && (i + 1 < codeList.length && "0123456789".contains("" + codeList[i + 2]))) {
                // get the signs //
                j++;

            } else if (numberBeforeDoit == false && !"0123456789".contains("" + codeList[i])) {
                if (i < codeList.length - 1) {
                    if (codeList[i] != '.') {
                        numberBeforeDoit = true;
                    }

                    if (codeList[i] != '#') {
                        code += "#";
                    }
                }
            } else if (codeList[i] == '.') {
                numberBeforeDoit = false;
            }

            code += codeList[i];
            i = j;
        }
        // //

        return code;
    }

}
