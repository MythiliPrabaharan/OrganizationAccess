# OrganizationAccess

A Spring Boot project for creating REST API pertaining to CRUD Operations using H2 database

Base Class : Organization
Derived Classes : Employee and Asset

Endpoint and payload details as below:

//Organization

POST
localhost:8080/organization

{
    "departmentName" : "Software",
    "departmentLocation" : "Pune"
}

{
    "departmentName" : "Infrastructure",
    "departmentLocation" : "Hyderabad"
}

GET
localhost:8080/organization

PUT
localhost:8080/organization 

{
    "departmentId" : "1",
    "departmentName" : "Software",
    "departmentLocation" : "Chennai"
}

DELETE
localhost:8080/organization/2

//Employee

POST
localhost:8080/employee

{
 "departmentName" : "Software",
 "departmentLocation" : "Chennai",
 "empId" : 1001,
 "empName" : "Joe",
 "empBaseLocation" : "Pune",
 "empDesignation" : "Developer"
}

{
 "departmentName" : "Software",
 "departmentLocation" : "Chennai",
 "empId" : 1002,
 "empName" : "Nick",
 "empBaseLocation" : "Pune",
 "empDesignation" : "Engineer"
}

GET
localhost:8080/employees

PUT 
localhost:8080/employee

{
 "departmentId":"6",
 "departmentName" : "Software",
 "departmentLocation" : "Chennai",
 "empId" : 1002,
 "empName" : "Nick",
 "empBaseLocation" : "Pune",
 "empDesignation" : "Senior Engineer"
}

DELETE
localhost:8080/employee/1002


//Asset

POST
localhost:8080/asset

{
"assetId" : 2001,
"departmentName" : "Infrastructure",
"departmentLocation" : "Pune",
"assetmodel" : "Latitude",
"assetVendor" : "Dell"
}


{
"assetId" : 2002,
"departmentName" : "Infrastructure",
"departmentLocation" : "Pune",
"assetmodel" : "Mac",
"assetVendor" : "Apple"
}

GET
localhost:8080/assets

PUT
localhost:8080/asset

{
 "departmentId":"10",
"assetId" : 2002,
"departmentName" : "Infrastructure",
"departmentLocation" : "Pune",
"assetmodel" : "Mac Pro",
"assetVendor" : "Apple"
}

DELETE
localhost:8080/asset/2001

