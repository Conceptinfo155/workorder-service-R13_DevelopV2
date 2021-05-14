package com.comcast.orion.workorder.utils;

import java.io.Serializable;

/**
 * Created for #US1732139
 * @author dnagam970
 *
 */
public enum JobTypeMappingConstants  implements Serializable{
	//SOLUTION_TYPE("SOLUTION_TYPE"),
	JOB_TYPE_CODE("JOB_TYPE_CODE"),
	QUOTA_POINTS("QUOTA_POINTS"),
	//ORDER_TYPE("ORDER_TYPE"),
	//TRANSPORT_TYPE("TRANSPORT_TYPE"),
	WEIGHT("WEIGHT"),
	JOB_REASON_CODE("JOB_REASON_CODE");
	
	public static final String SOLUTION_TYPE="SOLUTION_TYPE";
	public static final String ORDER_TYPE="ORDER_TYPE";
	public static final String ORDER_TYPE_TC="TC";
	public static final String TRANSPORT_TYPE="TRANSPORT_TYPE";
	public static final String TRANSPORT_TYPE_NA="NA";
	private String property = null;
	
	JobTypeMappingConstants(String property){
        this.property = property;
    }

    /**
     * @param value
     * @return
     */
    public static JobTypeMappingConstants fromValue(String value){
        return valueOf(value);
    }

    public String getValue(){
        return property;
    }
}
