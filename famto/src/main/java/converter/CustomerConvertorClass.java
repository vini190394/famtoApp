package converter;
import javax.persistence.AttributeConverter;
import com.example.famto.entity.CustomerData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerConvertorClass  implements AttributeConverter<CustomerData, String> {
	
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();

	}

	@Override
	public String convertToDatabaseColumn(CustomerData attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public CustomerData convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData,new TypeReference<CustomerData>() {});
		} catch (Exception e) {
			return null;
		}
	}
	
}