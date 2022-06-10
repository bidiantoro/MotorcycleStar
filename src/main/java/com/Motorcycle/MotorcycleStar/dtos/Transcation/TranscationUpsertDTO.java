package com.Motorcycle.MotorcycleStar.dtos.Transcation;

import com.Motorcycle.MotorcycleStar.models.Customer;
import com.Motorcycle.MotorcycleStar.models.Product;
import com.Motorcycle.MotorcycleStar.models.Transcation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Optional;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TranscationUpsertDTO {
    private Integer id;
    private Integer customerID;
    private String productID;
    private Integer quantitiy;
    private String purchaseDate;


    public Transcation toEntity(Optional<Customer> customer, Optional<Product> product) {
        return new Transcation(
                customer.get(),
                product.get(),
                quantitiy,
                LocalDate.now()
        );
    }

}
