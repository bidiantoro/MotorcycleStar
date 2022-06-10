package com.Motorcycle.MotorcycleStar.repositories;

import com.Motorcycle.MotorcycleStar.models.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TranscationRepository extends JpaRepository<Transcation, Integer> {
    @Query(value = """
            SELECT
            t.TransactionID ,
            CONCAT (c.FirstName , ' ' , c.LastName) as FullName, 
            c.Address , c.Phone , 
            CONCAT(mb.Company , ' ' , p.VehicleModel) as Vehicle, 
            t.Quantitiy , 
            SUM(t.Quantitiy * p.UnitPrice) as TotalPrice,
            t.PurchaseDate
                        
            FROM Transcation as t
            JOIN Customer as c on t.CustomerID = c.CustomerID
            JOIN Product as p on t.ProductID = p.ProductID
            JOIN MotorcycleBrand as mb on p.BrandID = mb.BrandID
            WHERE CONCAT(c.FirstName , ' ' ,  c.LastName) like %:name%
            GROUP BY t.TransactionID ,  CONCAT (c.FirstName , ' ' , c.LastName)  , c.Address , c.Phone , CONCAT(mb.Company , ' ' , p.VehicleModel)  , t.Quantitiy , t.PurchaseDate
            """, nativeQuery = true)
    List<Object[]> findTranscationByCustomerName(String name);

    @Query(value = """
                     SELECT
                     t.TransactionID ,
                     CONCAT (c.FirstName , ' ' , c.LastName) as FullName, 
                     c.Address , c.Phone , 
                     CONCAT(mb.Company , ' ' , p.VehicleModel) as Vehicle, 
                     t.Quantitiy , 
                     SUM(t.Quantitiy * p.UnitPrice) as TotalPrice,
                     t.PurchaseDate
                     
                     FROM Transcation as t
                     JOIN Customer as c on t.CustomerID = c.CustomerID
                     JOIN Product as p on t.ProductID = p.ProductID
                     JOIN MotorcycleBrand as mb on p.BrandID = mb.BrandID

            GROUP BY t.TransactionID , CONCAT  (c.FirstName , ' ' , c.LastName)  , c.Address , c.Phone , CONCAT(mb.Company , ' ' , p.VehicleModel)  , t.Quantitiy , t.PurchaseDate
            """, nativeQuery = true)
    List<Object[]> findAllTranscation();


    @Query(value = """
            SELECT
            t.TransactionID ,
            CONCAT (c.FirstName , ' ' , c.LastName) as FullName,
            c.Address , c.Phone ,
            CONCAT(mb.Company , ' ' , p.VehicleModel) as Vehicle,
            t.Quantitiy ,
            SUM(t.Quantitiy * p.UnitPrice) as TotalPrice,
            t.PurchaseDate
                                 
            FROM Transcation as t
            JOIN Customer as c on t.CustomerID = c.CustomerID
            JOIN Product as p on t.ProductID = p.ProductID
            JOIN MotorcycleBrand as mb on p.BrandID = mb.BrandID
            WHERE t.TransactionID = :id
            GROUP BY t.TransactionID , CONCAT (c.FirstName , ' ' , c.LastName)  , c.Address , c.Phone , CONCAT(mb.Company , ' ' , p.VehicleModel)  , t.Quantitiy , t.PurchaseDate
             """, nativeQuery = true)
    List<Object[]> findTranscationById(Integer id);

}