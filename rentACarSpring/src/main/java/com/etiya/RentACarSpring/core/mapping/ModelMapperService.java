package com.etiya.RentACarSpring.core.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
ModelMapper forDto();
ModelMapper forRequest();
}
