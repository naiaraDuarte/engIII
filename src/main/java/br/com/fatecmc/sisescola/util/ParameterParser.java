package br.com.fatecmc.sisescola.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParameterParser {
    
    public static int toInt(String texto){
        return texto == null || texto.equals("") ? 0 : Integer.parseInt(texto);
    }
    
    public static double toDouble(String texto){
        return texto == null || texto.equals("") ? 0.0 : Double.parseDouble(texto);
    }
    
    public static Date toDate(String texto){
        if(texto == null || texto.equals("")) return null;
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(texto);
        } catch (ParseException ex) {
            return null;
        }
    }
    
}
