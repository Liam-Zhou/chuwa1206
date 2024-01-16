package com.chuwa.cassandrablog.service.impl;

import com.chuwa.cassandrablog.entity.Vet;
import com.chuwa.cassandrablog.exception.ResourceNotFoundException;
import com.chuwa.cassandrablog.payload.VetDto;
import com.chuwa.cassandrablog.repository.VetRepository;
import com.chuwa.cassandrablog.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class VetServiceImpl implements VetService {

    private VetRepository vetRepository;

    @Autowired
    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public VetDto createVet(VetDto vetDto) {
        Vet tobeSaved = convertDtoToEntity(vetDto);
        tobeSaved.setId(UUID.randomUUID());
        Vet saved = vetRepository.save(tobeSaved);
        return convertEntityToDto(saved);
    }

    @Override
    public List<VetDto> getAllVets() {
        Iterable<Vet> response = vetRepository.findAll();
        return StreamSupport.stream(response.spliterator(), false)
                .map(VetServiceImpl::convertEntityToDto)
                .toList();
    }

    @Override
    public VetDto getVetById(UUID id) {
        Vet response = vetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vet", "UUID", id));
        return convertEntityToDto(response);
    }

    @Override
    public VetDto updateVet(VetDto vetDto, UUID id) {
        Vet tobeUpdated = vetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vet", "UUID", id));
        if (vetDto.getFirstName() != null) {
            tobeUpdated.setFirstName(vetDto.getFirstName());
        }
        if (vetDto.getLastName() != null) {
            tobeUpdated.setLastName(vetDto.getLastName());
        }
        if (vetDto.getSpecialties() != null) {
            tobeUpdated.setSpecialties(vetDto.getSpecialties());
        }
        Vet updated = vetRepository.save(tobeUpdated);
        return convertEntityToDto(updated);

    }

    @Override
    public void deleteVetById(UUID id) {
        vetRepository.deleteById(id);
    }

    private static Vet convertDtoToEntity(VetDto vetDto) {
        Vet vet = new Vet();
        vet.setId(vetDto.getId());
        vet.setFirstName(vetDto.getFirstName());
        vet.setLastName(vetDto.getLastName());
        vet.setSpecialties(vetDto.getSpecialties());
        return vet;
    }

    private static VetDto convertEntityToDto(Vet vet) {
        VetDto vetDto = new VetDto();
        vetDto.setId(vet.getId());
        vetDto.setFirstName(vet.getFirstName());
        vetDto.setLastName(vet.getLastName());
        vetDto.setSpecialties(vet.getSpecialties());
        return vetDto;
    }
}
