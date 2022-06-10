package com.Motorcycle.MotorcycleStar.services;

import com.Motorcycle.MotorcycleStar.dtos.Transcation.TranscationGridDTO;
import com.Motorcycle.MotorcycleStar.dtos.Transcation.TranscationUpsertDTO;

import java.util.List;

public interface TranscationService {

    public List<TranscationGridDTO> findAllTranscation();

    public List<TranscationGridDTO> findTranscationById(Integer id);

    public List<TranscationGridDTO> findTranscationByCustomerName(String customerName);

    public TranscationGridDTO insertTranscation(TranscationUpsertDTO insertTranscation);

    public TranscationGridDTO updateTranscation(Integer id, TranscationUpsertDTO updateTranscationDTO);

    public Boolean deleteTranscation(Integer id);


}
