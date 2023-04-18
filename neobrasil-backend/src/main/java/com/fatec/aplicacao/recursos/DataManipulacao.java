package com.fatec.aplicacao.recursos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataManipulacao {
	
	public static String AdicionarDias(String dataStr, int dias) throws ParseException { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dataStr));
        c.add(Calendar.DATE, dias);
        String data = sdf.format(c.getTime()); 
        return data;
	}
	
	public static List<String> CriarDatas(String dataInicio) throws ParseException {
		List<String> listaDatas = new ArrayList<>();
		listaDatas.add(DataManipulacao.AdicionarDias(dataInicio, 30));
		for (int i = 1; i < 12; i++) {
			listaDatas.add(DataManipulacao.AdicionarDias(listaDatas.get(i-1), 30));
		}
		return listaDatas;
	}
	
}
