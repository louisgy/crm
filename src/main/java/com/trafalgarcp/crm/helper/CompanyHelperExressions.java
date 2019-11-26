package com.trafalgarcp.crm.helper;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.trafalgarcp.crm.domain.QCompany;

public class CompanyHelperExressions {
	
	 public static BooleanExpression hasName(String name) {
		 return QCompany.company.name.eq(name);
	 }

}
