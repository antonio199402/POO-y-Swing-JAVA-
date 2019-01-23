
public class metodos {
	 
     
    public static void validarDNI(String DNI) throws DNIException {

        
        if (!(DNI.length() >= 8 && DNI.length() <= 9)) {
            throw new DNIException(DNIException.LONGITUD_NO_CORRECTA);
        }

       
        String parte_numerica = DNI.substring(0, DNI.length() - 1);

        
        int numeroDNI = 0;

        try {
          
            numeroDNI = Integer.parseInt(parte_numerica);
        } catch (NumberFormatException e) {
            throw new DNIException(DNIException.PARTE_NUMERICA_NO_CORRECTA);
        }

        //
        char letra = DNI.substring(DNI.length() - 1, DNI.length()).toUpperCase().charAt(0);

        if (!(letra >= 'A' && letra <= 'Z')) {
            throw new DNIException(DNIException.PARTE_LETRA_NO_CORRECTA);
        }

       
        final int DIVISOR = 23;

        char letrasNIF[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int resto = numeroDNI % DIVISOR;

        String nuevoDNI = numeroDNI + "" + letrasNIF[resto];

        if (DNI.startsWith("0")) {
            nuevoDNI = "0" + nuevoDNI;
        }

        if (!(nuevoDNI.equals(DNI))) {
            throw new DNIException(DNIException.FORMATO_NO_CORRECTO);
        }

    }


}
