
public class TP01_EX01 {

    TP01_EX01() {
    }

    public static String removeExtraSharp(String code){
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

}
