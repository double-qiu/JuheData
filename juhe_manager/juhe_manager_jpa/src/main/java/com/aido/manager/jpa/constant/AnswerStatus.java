package com.aido.manager.jpa.constant;


public class  AnswerStatus {
	
	public String Strkey ;
	public String value ;
	
	public static String getValue(String Strkey) {
		String value = "" ;
		int key = Integer.parseInt(Strkey);
		switch (key) {
		case 1:
			value = "A" ;
			break;
		case 2:
			value = "B" ;
			break;
		case 3:
			value ="C" ;
			break;
		case 4:
			value = "D" ;
			break;
		case 7:
			value = "AB" ;
			break;
		case 8:
			value = "AC" ;
			break;
		case 9:
			value = "AD" ;
			break;
		case 10:
			value = "BC" ;
			break;
		case 11:
			value = "BD" ;
			break;
		case 12:
			value = "CD" ;
			break;
		case 13:
			value = "ABC" ;
			break;
		case 14:
			value = "ABD" ;
			break;
		case 15:
			value = "ACD" ;
			break;
		case 16:
			value = "BCD" ;
			break;
		case 17:
			value = "ABCD" ;
			break;
		default:
			break;
		}
		return value ;
	}
}
