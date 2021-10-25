
public class TP01_EX01 {

    TP01_EX01() {
    }

    public static String splitToWords(String code) {
        code = code.replace(" ", "#");
        code = code.replace("\n", "#");
        code = code.replace("(", "#(#");
        code = code.replace("+", "#+#");
        code = code.replace("-", "#-#");
        code = code.replace("*", "#*#");
        code = code.replace("/", "#/#");

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
        for (int i = 0; i < codeList.length; i++) {
            code += codeList[i];
            if ((codeList[i] == '+' || codeList[i] == '-') && (i < 2 || codeList[i - 2] == '+' || codeList[i - 2] == '-'
                    || codeList[i - 2] == '*' || codeList[i - 2] == '/' || codeList[i - 2] == '(')) {
                i++;
            }
        }
        // //

        return code;
    }

}
