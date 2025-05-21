# Documentación - Proyecto Spring Boot 

Este archivo describe las rutas disponibles en el proyecto y los formatos de los datos esperados para cada una.

## A. Endpoints Estudiante

### 1. Obtener todos los estudiantes
**Método:** GET  
**URL:** `/students`

**Descripción:** Recupera una lista de todos los estudiantes registrados en el sistema.

---

### 2. Obtener un estudiante por Id
**Método:** GET  
**URL:** `/students/{id}`

**Descripción:** Recupera un estudiante especifico por Id de todos los estudiantes registrados en el sistema.

---

### 3. Obtener todos los estudiantes ordenados por edad
**Método:** GET  
**URL:** `/students/orderAges`

**Descripción:** Recupera una lista de todos los estudiantes registrados en el sistema ordenas por edad.

---

### 4. Crear un nuevo usuario
**Método:** POST  
**URL:** `/students`

**Descripción:** Permite la creación de un nuevo estudiante en el sistema.

#### Payload JSON requerido:
```json
{ 
    "nameStudent": "Fabian", 
    "lastNameStudent": "Soto", 
    "dniStudent": "12345674", 
    "ageStudent": 21
}
````
---

### 5. Actualizar un usuario
**Método:** PUT  
**URL:** `/students/{id}`

**Descripción:** Permite la actualización de un estudiante en el sistema.

#### Payload JSON requerido:
```json
{ 
    "nameStudent": "Fabian", 
    "lastNameStudent": "Soto", 
    "dniStudent": "12345674", 
    "ageStudent": 21
}
````
---

### 6. Eliminar un estudiante
**Método:** DELETE  
**URL:** `/students/{id}`

**Descripción:** Elimina un estudiante de todos los estudiantes registrados en el sistema.

---

## B. Endpoints Cursos

### 1. Obtener todos los cursos
**Método:** GET  
**URL:** `/courses`

**Descripción:** Recupera una lista de todos los cursos registrados en el sistema.

---

### 2. Obtener un curso por Id
**Método:** GET  
**URL:** `/courses/{id}`

**Descripción:** Recupera un curso especifico por Id de todos los cursos registrados en el sistema.

---

### 3. Crear un nuevo curso
**Método:** POST  
**URL:** `/courses`

**Descripción:** Permite la creación de un nuevo curso en el sistema.

#### Payload JSON requerido:
```json
{
  "nameCourse": "Arte",
  "acronymCourse": "ART",
  "statusCourse": true
}
````
---

### 4. Actualizar un curso
**Método:** PUT  
**URL:** `/courses/{id}`

**Descripción:** Permite la actualización de un curso en el sistema.

#### Payload JSON requerido:
```json
{
  "nameCourse": "Arte",
  "acronymCourse": "ART",
  "statusCourse": true
}
````
---

### 5. Eliminar un curso
**Método:** DELETE  
**URL:** `/courses/{id}`

**Descripción:** Elimina un curso de todos los cursos registrados en el sistema.

---

## C. Endpoints Matricula

### 1. Obtener todos los estudiantes
**Método:** GET  
**URL:** `/enrollments`

**Descripción:** Recupera una lista de todos las matriculas registradas en el sistema.

---

### 2. Obtener una matricula por Id
**Método:** GET  
**URL:** `/enrollments/{id}`

**Descripción:** Recupera una matricula especifica por Id de todos las matriculas registradas en el sistema.

---

### 3. Obtener los estudiantes matriculados por curso
**Método:** GET  
**URL:** `/enrollments/enrollmentCourseAndStudent`

**Descripción:** Recupera una lista de todos los estudiantes registrados por curso en el sistema.

---

### 4. Crear una nueva matricula
**Método:** POST  
**URL:** `/enrollments`

**Descripción:** Permite la creación de una nueva matricula en el sistema.

#### Payload JSON requerido:
```json
{
  "enrollmentDate" : "2025-05-08T12:46:00",
  "statusEnrollment" : true,
  "student" : {"idStudent": 4},
  "details" : [
    {
      "classroomEnrollment" : "AULA-002",
      "course" : {"idCourse": 2}
    },
    {
      "classroomEnrollment" : "AULA-004",
      "course" : {"idCourse": 4}
    }
  ]
}
````
---

### 5. Actualizar una matricula
**Método:** PUT  
**URL:** `/enrollments/{id}`

**Descripción:** Permite la actualización de una matricula en el sistema.

#### Payload JSON requerido:
```json
{
  "enrollmentDate" : "2025-05-08T12:46:00",
  "statusEnrollment" : true,
  "student" : {"idStudent": 4},
  "details" : [
    {
      "classroomEnrollment" : "AULA-002",
      "course" : {"idCourse": 2}
    },
    {
      "classroomEnrollment" : "AULA-004",
      "course" : {"idCourse": 4}
    }
  ]
}
````
---

### 6. Eliminar una matricula
**Método:** DELETE  
**URL:** `/enrollments/{id}`

**Descripción:** Elimina una matricula de todas las matriculas registradas en el sistema.

---

