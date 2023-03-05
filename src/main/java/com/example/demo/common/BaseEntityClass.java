package com.example.demo.common;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import com.fasterxml.jackson.databind.ObjectMapper;
@Entity

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "create_userRoutines", procedureName = "create_userRoutines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
	
})
public class BaseEntityClass {
	@Id
	private Integer pKey;

	public BaseEntityClass() {
		super();
	}

	public Integer getpKey() {
		return pKey;
	}

	public void setpKey(Integer pKey) {
		this.pKey = pKey;
	}

	/**
	 * Overrides toString method for converting class to string and back
	 **/
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}
