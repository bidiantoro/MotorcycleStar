package com.Motorcycle.MotorcycleStar.controller;

import com.Motorcycle.MotorcycleStar.dtos.RestResponse;
import com.Motorcycle.MotorcycleStar.dtos.Transcation.TranscationGridDTO;
import com.Motorcycle.MotorcycleStar.dtos.Transcation.TranscationUpsertDTO;
import com.Motorcycle.MotorcycleStar.services.TranscationService;
import com.Motorcycle.MotorcycleStar.services.TranscationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transcation")
public class TranscationController {

    @Autowired
    private TranscationService transcationService;

    //find all transcation
    @GetMapping
    public ResponseEntity<RestResponse<List<TranscationGridDTO>>> findAllTranscation() {
        return new ResponseEntity<>(
                new RestResponse<>(transcationService.findAllTranscation(),
                        "Transcation berhasil ditampilkan",
                        200),
                HttpStatus.OK);
    }

    //find all transcation by customer name
    @GetMapping("{customerName}")
    public ResponseEntity<RestResponse<List<TranscationGridDTO>>> findAllTranscationByCustomerName(@PathVariable String customerName) {
        return new ResponseEntity<>(
                new RestResponse<>(transcationService.findTranscationByCustomerName(customerName),
                        "Transcation berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    //insert transcation
    @PostMapping
    public ResponseEntity<RestResponse<TranscationGridDTO>> insertTranscation(@RequestBody TranscationUpsertDTO insertTranscation) {
        return new ResponseEntity<>(
                new RestResponse<>(transcationService.insertTranscation(insertTranscation),
                        "Transcation berhasil ditambahkan",
                        201),
                HttpStatus.CREATED);
    }

    //find by id
    @GetMapping("find/{id}")
    public ResponseEntity<RestResponse<List<TranscationGridDTO>>> findAllTranscationByCustomerName(@PathVariable Integer id) {
        return new ResponseEntity<>(
                new RestResponse<>(transcationService.findTranscationById(id),
                        "Transcation berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    //update by id
    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<TranscationGridDTO>> updateTranscation(@PathVariable Integer id, @RequestBody TranscationUpsertDTO updateTranscation) {
        return new ResponseEntity<>(
                new RestResponse<>(transcationService.updateTranscation(id, updateTranscation),
                        "Transcation berhasil diupdate",
                        200),
                HttpStatus.OK);
    }

    //delete by id
    @DeleteMapping("{id}")
    public ResponseEntity<RestResponse<Boolean>> deleteTranscation(@PathVariable Integer id) {
        return new ResponseEntity<>(
                new RestResponse<>(transcationService.deleteTranscation(id),
                        "Transcation berhasil dihapus",
                        200),
                HttpStatus.OK);
    }

}
