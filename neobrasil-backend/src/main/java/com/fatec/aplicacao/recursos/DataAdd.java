package com.fatec.aplicacao.recursos;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataAdd {
	
	public static String AdicionarDias(String dataStr, int dias) throws ParseException {
		Date dataDate= new SimpleDateFormat("yyyy-mm-dd").parse(dataStr); 
		Calendar c = Calendar.getInstance();
        c.setTime(dataDate);
        c.add(Calendar.DATE, dias);
        Date dataAtualizada = c.getTime();
        System.out.print(dataDate);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String data = dateFormat.format(dataAtualizada);
        System.out.print(data);
        return data;
		
	}
}
