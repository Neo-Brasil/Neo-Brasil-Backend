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
        c.add(Calendar.MONTH, dias);
        String data = sdf.format(c.getTime()); 
        return data;
	}
	
	public static List<String> CriarDatas(String dataInicio) throws ParseException {
		List<String> listaDatas = new ArrayList<>();
		listaDatas.add(DataManipulacao.AdicionarDias(dataInicio, 1));
		for (int i = 0; i < 11; i++) {
			listaDatas.add(DataManipulacao.AdicionarDias(dataInicio, i+1));
		}
		return listaDatas;
	}
	
	public static int stringDataPraInt(String data) {
		return Integer.parseInt(data.replace("-", ""));
	}
	
}
