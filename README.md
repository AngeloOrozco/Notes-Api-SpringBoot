<h1>Note Api Rest</h1>

- Requirements :

- You need to implement a simple web application that allows you to take notes, tag, and filter them. The development is divided into two phases:

- Phase 1: Note creation.

- Phase 2: Tag application and filtering 

- For the project it was used: Java 17, Maven, Spring Boot 3.2.1


------------

<h1>Crear Categorias</h1>
<h4> POST http://localhost:8080/api/category/save </h4> 

```
//POST
//Ruta: http://localhost:8080/api/category/save

{
	"name":"example"
}

```


<h3>Mostrar todas las categorias</h3>
<h4>GET http://localhost:8080/api/category/findAll </h4> 



<h3>Mostrar categoria por id</h3>
<h4>GET http://localhost:8080/api/category/find/{id} </h4>



<h3>Actualizar categoria</h3>
<h4>PUT http://localhost:8080/api/category/update/{id} </h4>

```
//PUT
//Ruta: http://localhost:8080/api/category/update/{id}

{
	"name":"example-updated"
}

```

<h3>Eliminar categoria</h3>
<h4>DELETE http://localhost:8080/api/category/delete/{id} </h4>



<h1>Crear Notas</h1>
<h4> POST http://localhost:8080/api/note/save </h4> 

```
//POST
//Ruta: http://localhost:8080/api/note/save

{
	"name":"Note Tittle",
	"content":"example content",
	"category":{
		"id":1 //category id
	}
}

```

<h3>Archivar una Nota</h3>
<h4>POST http://localhost:8080/api/note/archiveNote/{id} </h4>

<h3>Desarchivar una Nota</h3>
<h4>POST http://localhost:8080/api/note/unarchiveNote/{id} </h4>

<h3>Mostrar las notas activas</h3>
<h4>GET http://localhost:8080/api/note/findAllActives </h4>

<h3>Mostrar las notas archivadas</h3>
<h4>GET http://localhost:8080/api/note/findArchivedNotes </h4>

<h3>Actualizar una nota</h3>
<h4>PUT http://localhost:8080/api/note/update/{id} </h4>

```
//PUT
//Ruta: http://localhost:8080/api/category/update/{id}

{
	"name":"updated note",
	"content":"example of note content",
	"category":{
		"id":1 //category id
	}
}

```

<h3>Eliminar una nota</h3>
<h4>DELETE http://localhost:8080/api/note/delete/{id} </h4>
