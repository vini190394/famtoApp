package com.example.famto.entity;
import java.util.List;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonSubTypes;
//import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import com.fasterxml.jackson.annotation.JsonTypeInfo;

@SuppressWarnings("rawtypes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OftenBoughtTogetherModel
implements 
AttributeConverter<List<OftenBoughtTogetherModel>, String>  
{
	
	
	protected String boughtTogetherProducts;

	public String getBoughtTogetherProducts() {
		return boughtTogetherProducts;
	}

	public void setBoughtTogetherProducts(String boughtTogetherProducts) {
		this.boughtTogetherProducts = boughtTogetherProducts;
	}

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();

	}

	@Override
	public String convertToDatabaseColumn(List<OftenBoughtTogetherModel> attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public List<OftenBoughtTogetherModel> convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData,new TypeReference<List<OftenBoughtTogetherModel>>() {});
		} catch (Exception e) {
			return null;
		}
	}




}