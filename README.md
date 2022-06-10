
# REST API MOTORCYCLESTAR



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->


## Variables

| Key | Value | Type |
| --- | ------|-------------|
| url | http://localhost:8081 | string |



## Endpoints

* [Customer](#customer)
    1. [Find All Customer](#1-find-all-customer)
    1. [Find Customer By Id](#2-find-customer-by-id)
    1. [Insert Customer](#3-insert-customer)
    1. [Update Customer By Id](#4-update-customer-by-id)
    1. [Delete Customer By Id](#5-delete-customer-by-id)
* [Brand](#brand)
    1. [Find All Brand](#1-find-all-brand)
    1. [Find Brand By Id](#2-find-brand-by-id)
    1. [Update Brand By Id](#3-update-brand-by-id)
    1. [Insert Brand](#4-insert-brand)
    1. [Delete Brand By Id](#5-delete-brand-by-id)
* [Product](#product)
    1. [Find All Product](#1-find-all-product)
    1. [Find Product By Id](#2-find-product-by-id)
    1. [Update Product](#3-update-product)
    1. [Insert Product](#4-insert-product)
    1. [Delete Product](#5-delete-product)
* [Transaction](#transaction)
    1. [Find All Transcation](#1-find-all-transcation)
    1. [Find Transcation By Id](#2-find-transcation-by-id)
    1. [Find Transcation By Customer Name](#3-find-transcation-by-customer-name)
    1. [Insert Transcation](#4-insert-transcation)
    1. [Update Transcation](#5-update-transcation)
    1. [Delete Transcation](#6-delete-transcation)

--------



## Customer



### 1. Find All Customer



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/customers
```



### 2. Find Customer By Id



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/customers/1
```



### 3. Insert Customer



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: localhost:8081/api/customers
```



***Body:***

```js        
{
    "firstName": "Desi",
    "lastName" :"Rahma",
    "address": "Bekasi",
    "gender": "Female",
    "phone": "0823822626"
}
```



### 4. Update Customer By Id



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: localhost:8081/api/customers/6
```



***Body:***

```js        
{
"lastName":"Rahmaa"
}
```



### 5. Delete Customer By Id



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: localhost:8081/api/customers/2
```



## Brand



### 1. Find All Brand



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/brand
```



### 2. Find Brand By Id



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/brand/YMH
```



### 3. Update Brand By Id



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/brand/HD
```



***Body:***

```js        
{
    "company" : "Honda",
    "country" : "Japan"
}
```



### 4. Insert Brand



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/brand
```



***Body:***

```js        
{
    "id" : "KWS",
    "company" : "Kawasaki",
    "country" : "Japan"
}
```



### 5. Delete Brand By Id



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/brand/YMH
```



## Product



### 1. Find All Product



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/product
```



### 2. Find Product By Id



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/product/HR01
```



### 3. Update Product



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/product/KWS01
```



***Body:***

```js        
{
   "unitPrice" : 27500000
}
```



### 4. Insert Product



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/product
```



***Body:***

```js        
{
    "id" : "KWS01",
    "brandID" : "KWS",
    "vehicleModel" : "Ninja",
    "vehicleType" : "Sport",
    "productionYear" : "2021",
    "engine" : "250 CC",
    "unitPrice" : 27500000

}
```



### 5. Delete Product



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/product/HR02
```



## Transaction



### 1. Find All Transcation



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/transcation
```



### 2. Find Transcation By Id



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/transcation/find/1
```



### 3. Find Transcation By Customer Name



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/transcation/aos
```



### 4. Insert Transcation



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/transcation
```



***Body:***

```js        
{
    "customerID" : 5,
    "productID" : "KWS01",
    "quantitiy" : 2
}
```



### 5. Update Transcation



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/transcation/update/14
```



***Body:***

```js        
{
    "quantitiy" : 2
}
```



### 6. Delete Transcation



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/transcation/14
```



---
[Back to top](#rest-api-motorcyclestar)
