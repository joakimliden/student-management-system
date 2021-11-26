# student-management-system

## Student

**POST Create**
http://localhost:8080/student-management-system/api/v1/students

  {
  
	"firstName": "Joakim",
  
	"lastName": "Lidén",
  
	"email": "mail@mail.com",
  
	"phoneNumber": "0703255454"
  }


**PUT Update**
http://localhost:8080/student-management-system/api/v1/students/{id}

{
  
	"firstName": "Nytt namn",
  
	"lastName": "Lidén",
  
	"email": "mail@mail.com",
  
	"phoneNumber": "0703255454"
  }


**GET all**
http://localhost:8080/student-management-system/api/v1/students

**GET by id**
http://localhost:8080/student-management-system/api/v1/students/{id}

**GET by last name**
http://localhost:8080/student-management-system/api/v1/students/lastname

**_lastName som QueryParam_**

**DELETE**
http://localhost:8080/student-management-system/api/v1/students/{id}



## Subject (only branch "labb2")

**GET all**
http://localhost:8080/student-management-system/api/v1/subjects

**GET by subject**
http://localhost:8080/student-management-system/api/v1/subjects/{subject}

Subjects added by SampleDataGenerator.java :
{
	"Matematik"
	"Gymnastik"
	"Biologi"
	"Engelska"
}
