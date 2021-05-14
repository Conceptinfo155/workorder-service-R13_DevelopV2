package com.comcast.orion.workorder.utils;

import java.util.Iterator;
import java.util.LinkedHashSet;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.codemodel.JAnnotationArrayMember;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JEnumConstant;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomAnnonator
 *
 */
public class CustomAnnonator implements org.jsonschema2pojo.Annotator {
	
	
	
	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(CustomAnnonator.class);

	/**
	 * JSON_REQUIRED
	 */
	private static final String JSON_REQUIRED = "required";

	/**
	 * JSON_DATATYPE
	 */
	private static final String JSON_DATATYPE = "type";

	/**
	 * JSON_SEQUENCE
	 */
	private static final String JSON_SEQUENCE = "position";

	/**
	 * JSON_ELEMENT_DESCRIPTION
	 */
	private static final String JSON_ELEMENT_DESCRIPTION = "description";

	/**
	 * JSON_ELEMENT_EXAMPLE
	 */
	private static final String JSON_ELEMENT_EXAMPLE = "example";

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#propertyOrder(com.sun.codemodel.JDefinedClass, com.fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
		JAnnotationArrayMember annotationValue = clazz.annotate(JsonPropertyOrder.class).paramArray("value");
		for (Iterator<String> properties = propertiesNode.fieldNames(); properties.hasNext();) {
			annotationValue.param(properties.next());
		}

	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#propertyInclusion(com.sun.codemodel.JDefinedClass, com.fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {		  
		 clazz.annotate(JsonInclude.class).param("value", JsonInclude.Include.NON_EMPTY);
	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#propertyField(com.sun.codemodel.JFieldVar, com.sun.codemodel.JDefinedClass, java.lang.String, com.fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
		boolean required = false;
		if (propertyNode.get(JSON_REQUIRED) != null) {
			required = propertyNode.get(JSON_REQUIRED).asBoolean();
		}

		String dataType = "";
		if (propertyNode.get(JSON_DATATYPE) != null) {
			dataType = propertyNode.get(JSON_DATATYPE).asText();
		}

		int position = 0;
		if (propertyNode.get(JSON_SEQUENCE) != null) {
			position = propertyNode.get(JSON_SEQUENCE).asInt();
		}

		String description = "";
		if (propertyNode.get(JSON_ELEMENT_DESCRIPTION) != null) {
			description = propertyNode.get(JSON_ELEMENT_DESCRIPTION).asText();
		}
		
		String example = "";
		if (propertyNode.get(JSON_ELEMENT_EXAMPLE) != null) {
			example = propertyNode.get(JSON_ELEMENT_EXAMPLE).asText();
		}

		try {
		

			field.annotate(JsonProperty.class).param("value", propertyName);
			field.annotate(JsonPropertyDescription.class).param("value", description);
			
			
			field.annotate(ApiModelProperty.class).param(JSON_REQUIRED, required).param("dataType", dataType)
					.param(JSON_SEQUENCE, position).param("value", description).param("example", example);

			if (field.type().erasure().equals(field.type().owner().ref(Set.class))) {
				field.annotate(JsonDeserialize.class).param("as", LinkedHashSet.class);
			}

		} catch (Exception e) {
			log.error("Exception Occurred in CustomAnnonator#propertyField --- Exception - Message: "
					+ e);
		}

	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#propertyGetter(com.sun.codemodel.JMethod, java.lang.String)
	 */
	@Override
	public void propertyGetter(JMethod getter, String propertyName) {
		getter.annotate(JsonProperty.class).param("value", propertyName);

	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#propertySetter(com.sun.codemodel.JMethod, java.lang.String)
	 */
	@Override
	public void propertySetter(JMethod setter, String propertyName) {
		setter.annotate(JsonProperty.class).param("value", propertyName);

	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#anyGetter(com.sun.codemodel.JMethod)
	 */
	@Override
	public void anyGetter(JMethod getter) {
		getter.annotate(JsonAnyGetter.class);

	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#anySetter(com.sun.codemodel.JMethod)
	 */
	@Override
	public void anySetter(JMethod setter) {
		setter.annotate(JsonAnySetter.class);
	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#enumCreatorMethod(com.sun.codemodel.JMethod)
	 */
	@Override
	public void enumCreatorMethod(JMethod creatorMethod) {
		creatorMethod.annotate(JsonCreator.class);
	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#enumValueMethod(com.sun.codemodel.JMethod)
	 */
	@Override
	public void enumValueMethod(JMethod valueMethod) {
		valueMethod.annotate(JsonValue.class);
	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#enumConstant(com.sun.codemodel.JEnumConstant, java.lang.String)
	 */
	@Override
	public void enumConstant(JEnumConstant constant, String value) {
		//This method is intentionally left blank
		
	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#isAdditionalPropertiesSupported()
	 */
	@Override
	public boolean isAdditionalPropertiesSupported() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.jsonschema2pojo.Annotator#additionalPropertiesField(com.sun.codemodel.JFieldVar, com.sun.codemodel.JDefinedClass, java.lang.String)
	 */
	@Override
	public void additionalPropertiesField(JFieldVar field, JDefinedClass clazz, String propertyName) {
		field.annotate(JsonIgnore.class);
	}
	//Added for future use
	@Override
	public void dateTimeField(JFieldVar field, JsonNode propertyNode) {
		//This method is intentionally left blank
		
	}

	//Added for future use
	@Override
	public void dateField(JFieldVar field, JsonNode propertyNode) {
		//This method is intentionally left blank
	}

}