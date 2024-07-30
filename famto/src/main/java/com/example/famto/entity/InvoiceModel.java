package com.example.famto.entity;

import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Embedded;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class InvoiceModel 
implements 
AttributeConverter<InvoiceModel, String>  
{
	@Embedded
	protected List<ProductPriceData> productsPriceData;
	protected Double subtotal;
	protected Double salesTax;
	protected Double gst;
	protected Double total;

	
	public List<ProductPriceData> getProductsPriceData() {
		return productsPriceData;
	}

	public void setProductsPriceData(List<ProductPriceData> productsPriceData) {
		this.productsPriceData = productsPriceData;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static void setMapper(ObjectMapper mapper) {
		InvoiceModel.mapper = mapper;
	}

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();

	}

	@Override
	public String convertToDatabaseColumn(InvoiceModel attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public InvoiceModel convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData,new TypeReference<InvoiceModel>() {});
		} catch (Exception e) {
			return null;
		}
	}
	

}