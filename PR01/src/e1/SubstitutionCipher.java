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

        if (usedDict != null){
            int bottom = 0;
            int top = usedDict.length();

            for (int i = 0; i <= top; i++){
                if(c == usedDict.toCharArray()[i]) {
                    int newI = i + key;

                    // Si el nuevo índice esta fuera del vector, volver al inicio/final
                    if (newI >= top)
                        newI = newI - top;
                    else if (newI < bottom)
                        newI = top + newI;

                    returnedChar = usedDict.toCharArray()[newI];
                    break;
                }
            }
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
        String originalText = "CESAR ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Texto original: " + originalText);

        String encodedText = encode(encodeKey,  originalText);
        System.out.println("Texto encodeado: " + encodedText);

        String reDecodedText = decode(encodeKey,   encodedText);
        System.out.println("Texto decodeado de nuevo: " + reDecodedText);
    }
}
