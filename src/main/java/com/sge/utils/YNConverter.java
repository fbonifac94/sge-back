package com.sge.utils;

import javax.persistence.AttributeConverter;

public class YNConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute == null) {
			return null;
		} else {
			return (attribute) ? "Y" : "N";
		}
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		} else {
			return (dbData.equals("Y")) ? Boolean.TRUE : Boolean.FALSE;
		}
	}

}
