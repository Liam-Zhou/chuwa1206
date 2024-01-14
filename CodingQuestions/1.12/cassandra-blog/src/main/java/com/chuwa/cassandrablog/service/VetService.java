package com.chuwa.cassandrablog.service;

import com.chuwa.cassandrablog.payload.VetDto;

import java.util.List;
import java.util.UUID;

public interface VetService {
    VetDto createVet(VetDto vetDto);

    List<VetDto> getAllVets();

    VetDto getVetById(UUID id);

    VetDto updateVet(VetDto vetDto, UUID id);

    void deleteVetById(UUID id);
}
