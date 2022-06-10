package com.Motorcycle.MotorcycleStar.dtos.Transcation;

import com.Motorcycle.MotorcycleStar.models.Transcation;
import lombok.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TranscationGridDTO {
    private Integer id;
    private String fullName;
    private String address;
    private String phone;
    private String vehicle;
    private Integer quantity;
    private String totalPrice;
    private String purchaseDate;


    public static List<TranscationGridDTO> convert(List<Object[]> transcationHeaderDtos) {
        NumberFormat formatMoney = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        List<TranscationGridDTO> transcationHeaderDtoList = new ArrayList<>();
        for (Object[] transcationHeaderDto : transcationHeaderDtos) {

            transcationHeaderDtoList.add(new TranscationGridDTO(
                    (Integer) transcationHeaderDto[0],
                    (String) transcationHeaderDto[1],
                    (String) transcationHeaderDto[2],
                    (String) transcationHeaderDto[3],
                    (String) transcationHeaderDto[4],
                    (Integer) transcationHeaderDto[5],
                    formatMoney.format(transcationHeaderDto[6]),
                    dateToString((Date) transcationHeaderDto[7])
            ));

        }
        return transcationHeaderDtoList;
    }

    private static String dateToString(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String dateString = date.toString();
        LocalDate newLocalDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        return newLocalDate.format(formatter);
    }

    public static TranscationGridDTO set(Transcation transcation) {
        NumberFormat formatMoney = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String totalPrice = formatMoney.format(transcation.getProductID().getUnitPrice().multiply(BigDecimal.valueOf(transcation.getQuantitiy())));
        return new TranscationGridDTO(
                transcation.getId(),
                transcation.getCustomerID().getFirstName() + " " + transcation.getCustomerID().getLastName(),
                transcation.getCustomerID().getAddress(),
                transcation.getCustomerID().getPhone(),
                transcation.getProductID().getVehicleModel(),
                transcation.getQuantitiy(),
                totalPrice,
                transcation.getPurchaseDate().format(formatter)
        );
    }

}

