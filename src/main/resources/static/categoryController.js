function mostrarCategory(){
    $.ajax({
        url:"http://129.213.65.46:8090/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            //console.log(respuesta);
            mostrarTabla(respuesta);
        },
        error:function(respuesta, xhr){
            alert("Error de peticion");
        }
    });
}
function mostrarTabla(items){
    
    let myTabla="";
    
    myTabla+="<tr>";
        myTabla+="<th>"+"NAME"+"</th>";
        myTabla+="<th>"+"DESCRIPTION"+"</th>";
        myTabla+="<th>"+"LIBS"+"</th>";
    myTabla+="</tr>";
        
    for(let i=0;i<items.length;i++){
        myTabla+="<tr>";
        myTabla+="<td>"+items[i].name+"</td>";
        myTabla+="<td>"+items[i].description+"</td>";
        
            const myLibroIni="";
            const myLibro = items[i].libs.reduce(
            (Libroprev, Libroact) => Libroact.name +"  "+Libroprev,
             myLibroIni
            );
            //console.log(myLibro);
            myTabla+="<td>"+myLibro+"</td>";
        myTabla+="<td><button onclick='actualizarCategory(\""+items[i].id+"\")'>Editar</button>";
        myTabla+="<td><button onclick='eliminarCategory(\""+items[i].id+"\")'>Eliminar</button>";
    }
     myTabla+="</tr>";
    
    $('#tabla').empty();
    $('#tabla').append(myTabla);
}
function guardarCategory(){
    const data=
    {
    name:$('#categoryName').val(),
    description:$('#categoryDescription').val()
    };
    
    let convertir=JSON.stringify(data);
    
$.ajax({
url:"http://129.213.65.46:8090/api/Category/save",
type:"POST",
data:convertir,
contentType:"application/JSON",
datatype:"JSON",


success:function(respuesta){
$('#categoryName').val("");
$('#categoryDescription').val("");
alert("Categoria Guardada!!");
//mostrarCategory();
}
});
}
function actualizarCategory(codigo){
 $.ajax({
    url:"http://129.213.65.46:8090/api/Category/"+codigo,  
    type:"GET",
    datatype:"JSON",
    success:function(respuesta){
    let idEditar=respuesta.id;
    const data=
    {  
    id: idEditar,   
    name:$('#categoryName').val(),
    description:$('#categoryDescription').val()
    };
        let convertir=JSON.stringify(data);
        $.ajax({
        url:"http://129.213.65.46:8090/api/Category/update",
        type:"PUT",
        data:convertir,
        contentType:"application/JSON",
        datatype:"JSON",

        success:function(respuesta){
        $('#categoryName').val("");
        $('#categoryDescription').val("");
        mostrarCategory();
        }
        });
    }
});
}


function eliminarCategory(codigo){
    var opcion=confirm("Esta seguro de eliminar la categoria?");
    if(opcion===true){
    $.ajax({
    url:"http://129.213.65.46:8090/api/Category/"+codigo,
    type:"DELETE",
    datatype:"JSON",

    success:function(respuesta){
    alert("Libro Eliminado!!");
    mostrarCategory();
    }
    });
    }
}
