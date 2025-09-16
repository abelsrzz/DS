package e1;

public final class SubstitutionCipher {

    /*Declaración de diccionarios*/
    static final String dict1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String dict2 = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Intercambia un carácter por el correspondiente en el diccionario en orden del @param key
     * @param c Carácter a intercambiar
     * @param key valor de desplazamiento
     * */
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
        StringBuilder encodedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            encodedText.append(swap(text.charAt(i), key));
        }
        return encodedText.toString();
    }

    public static String decode(int key, String text) {
        StringBuilder decodedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            decodedText.append(swap(text.charAt(i), -key));
        }
        return decodedText.toString();
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
