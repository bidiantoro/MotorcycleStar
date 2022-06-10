package com.Motorcycle.MotorcycleStar.services;

import com.Motorcycle.MotorcycleStar.dtos.Transcation.TranscationGridDTO;
import com.Motorcycle.MotorcycleStar.dtos.Transcation.TranscationUpsertDTO;
import com.Motorcycle.MotorcycleStar.models.Customer;
import com.Motorcycle.MotorcycleStar.models.Product;
import com.Motorcycle.MotorcycleStar.models.Transcation;
import com.Motorcycle.MotorcycleStar.repositories.CustomerRepository;
import com.Motorcycle.MotorcycleStar.repositories.ProductRepository;
import com.Motorcycle.MotorcycleStar.repositories.TranscationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TranscationServiceImplementation implements TranscationService {


    private TranscationRepository transcationRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    @Autowired
    public TranscationServiceImplementation(TranscationRepository transcationRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.transcationRepository = transcationRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    //find all transcation
    @Override
    public List<TranscationGridDTO> findAllTranscation() {
        List<Object[]> transcationHeaderDtos = transcationRepository.findAllTranscation();
        List<TranscationGridDTO> transcationGridDTOList = TranscationGridDTO.convert(transcationHeaderDtos);
        return transcationGridDTOList;

    }

    //find transcation by id
    @Override
    public List<TranscationGridDTO> findTranscationById(Integer id) {
        List<Object[]> transcation = transcationRepository.findTranscationById(id);
        if (transcation.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transcation ID tidak ditemukan");
        }
        List<TranscationGridDTO> transcationGridDTO = TranscationGridDTO.convert(transcation);
        return transcationGridDTO;
    }

    //find transaction by customer name
    @Override
    public List<TranscationGridDTO> findTranscationByCustomerName(String customerName) {
        List<Object[]> transcationHeaderDtos = transcationRepository.findTranscationByCustomerName(customerName);
        if (transcationHeaderDtos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer name tidak ditemukan");
        }
        List<TranscationGridDTO> transcationGridDTOList = TranscationGridDTO.convert(transcationHeaderDtos);
        return transcationGridDTOList;
    }

    //insert transcation
    @Override
    public TranscationGridDTO insertTranscation(TranscationUpsertDTO insertTranscation) {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findById(insertTranscation.getCustomerID())
                .orElseThrow((() -> new RuntimeException("Customer id not found"))));
        Optional<Product> product = Optional.ofNullable(productRepository.findById(insertTranscation.getProductID())
                .orElseThrow((() -> new RuntimeException("Product id not found"))));
        Transcation transcation = insertTranscation.toEntity(customer, product);

        transcationRepository.save(transcation);
        return TranscationGridDTO.set(transcation);

    }


    //update transcation by id
    @Override
    public TranscationGridDTO updateTranscation(Integer id, TranscationUpsertDTO updateTranscationDTO) {
        Transcation oldTranscation = transcationRepository.findById(id).orElseThrow((() -> new RuntimeException("Transcation id tidak ditemukan")));
        if (updateTranscationDTO.getCustomerID() != null) {
            Customer customer = customerRepository.findById(updateTranscationDTO.getCustomerID())
                    .orElseThrow((() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer id tidak ditemukan")));
            oldTranscation.setCustomerID(customer);
        } else {
            oldTranscation.setCustomerID(oldTranscation.getCustomerID());
        }

        if (updateTranscationDTO.getProductID() != null) {
            Product product = productRepository.findById(updateTranscationDTO.getProductID())
                    .orElseThrow((() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product id not found")));
            oldTranscation.setProductID(product);
        } else {
            oldTranscation.setProductID(oldTranscation.getProductID());
        }

        oldTranscation.setQuantitiy(updateTranscationDTO.getQuantitiy() == null ? oldTranscation.getQuantitiy() : updateTranscationDTO.getQuantitiy());
        transcationRepository.save(oldTranscation);
        return TranscationGridDTO.set(oldTranscation);
    }

    //delete transcation by id
    @Override
    public Boolean deleteTranscation(Integer id) {
        Optional<Transcation> transcation = Optional.ofNullable(transcationRepository.findById(id)
                .orElseThrow((() -> new RuntimeException("Transcation id not found"))));
        transcationRepository.delete(transcation.get());

        return true;
    }


}




