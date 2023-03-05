package com.example.demo.common;

public class GenerateParameter {

	/**
	 * returns parameter set for error class
	 **/
	public static String getSqlErrorParam(Integer code, String state, String message, String type) {

		String parameterString = "SET ";
		message = message.replace("'", "");
		String[] x = message.split(";");
		parameterString = parameterString + "@p_code='" + code + "',";
		parameterString = parameterString + "@p_state='" + state + "',";
		parameterString = parameterString + "@p_message='" + x[0] + "',";
		parameterString = parameterString + "@p_dbName='" + type + "';";

		return parameterString;
	}

}
