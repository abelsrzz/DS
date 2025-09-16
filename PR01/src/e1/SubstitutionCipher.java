package e1;

public final class SubstitutionCipher {

    static final String dict1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String dict2 = "abcdefghijklmnopqrstuvwxyz";

    private static char swap(char c, int key){
        String usedDict = null;
        char returnedChar = c;

        if (dict1.contains(String.valueOf(c)))
            usedDict = dict1;

        if (dict2.contains(String.valueOf(c)))
            usedDict = dict2;

        if (usedDict != null)
            for (int i = 0; i < usedDict.length(); i++){
                if(c == usedDict.toCharArray()[i])
                    returnedChar = usedDict.toCharArray()[i + key];
            }

        return returnedChar;
    }

    public static String encode(int key, String text){
        String encodedText = "";

        for (int i = 0; i < text.length(); i++){
            encodedText += swap(text.charAt(i), key);
        }
        return encodedText;
    }

    public static String decode(int key, String text) {
        String decodedText = "";

        for (int i = 0; i < text.length(); i++){
            decodedText += swap(text.charAt(i), -key);
        }
        return decodedText;
    }

    public static void main(String[] args) {
        int encodeKey = 3;
        String originalText = "CESAR";
        System.out.println("Texto original: " + originalText);

        String encodedText = encode(encodeKey,  originalText);
        System.out.println("Texto encodeado: " + encodedText);

        String reDecodedText = decode(encodeKey,   encodedText);
        System.out.println("Texto decodado de nuevo: " + reDecodedText);
    }
}
