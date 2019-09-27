package com.in28minutes.rest.filtering;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class Filtering {
	
	//field1,field2
	@GetMapping("/Filtering")
	public MappingJacksonValue FilteringBeans() {
		SomeBean somebean=new SomeBean("Value1", "Value2", "Value3");

		MappingJacksonValue jacksonValue=new MappingJacksonValue(somebean);
	
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("somebeanfilter", filter); 
		
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}
	
	@GetMapping("/Filtering-hotel")
	public MappingJacksonValue FilteringHotelBeans() {
		SomeBean somebean=new SomeBean("Value1", "Value2", "Value3");

		MappingJacksonValue jacksonValue=new MappingJacksonValue(somebean);
	
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("somebeanfilter", filter); 
		
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}
	
	@GetMapping("/Filtering-list")
	public List<SomeBean> FilteringListofBeans() {
		return Arrays.asList(new SomeBean("Value1", "Value2", "Value3"),new SomeBean("Value11", "Value22", "Value33"));
			
	}

}
