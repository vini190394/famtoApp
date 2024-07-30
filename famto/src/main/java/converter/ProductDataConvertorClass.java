package converter;

import java.util.List;

import javax.persistence.AttributeConverter;

import com.example.famto.entity.ProductsData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductDataConvertorClass implements AttributeConverter<List<ProductsData>, String> {
	
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();

	}

	@Override
	public String convertToDatabaseColumn(List<ProductsData> attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public List<ProductsData> convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData,new TypeReference<List<ProductsData>>() {});
		} catch (Exception e) {
			return null;
		}
	}
	
}