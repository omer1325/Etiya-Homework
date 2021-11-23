package com.etiya.rentACarSpring.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMappingService {
	ModelMapper forDto();

	ModelMapper forRequest();
}
