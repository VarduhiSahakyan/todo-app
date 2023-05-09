package com.iguan.todo.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class Mapper {

    private final ModelMapper modelMapper;

    public <E, D> D convertToDto(E entity, Class<D> dto) {
        return modelMapper.map(entity, dto);
    }

    public <E, D> E convertToEntity(D dto, Class<E> entity) {
        return modelMapper.map(dto, entity);
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}

