function mostrarLib(){
    $.ajax({
        url:"http://129.213.65.46:8090/api/Lib/all",
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
        myTabla+="<th>"+"TARGET"+"</th>";
        myTabla+="<th>"+"CAPACITY"+"</th>";
        myTabla+="<th>"+"DESCRIPTION"+"</th>";
        myTabla+="<th>"+"CATEGORY"+"</th>";
        myTabla+="<th>"+"MESSAGES"+"</th>";
        myTabla+="<th>"+"RESERVATIONS"+"</th>";
    myTabla+="</tr>";
        
    for(let i=0;i<items.length;i++){
        myTabla+="<tr>";
        myTabla+="<td>"+items[i].name+"</td>";
        myTabla+="<td>"+items[i].target+"</td>";
        myTabla+="<td>"+items[i].capacity+"</td>";
        myTabla+="<td>"+items[i].description+"</td>";
        myTabla+="<td>"+items[i].category.name+"</td>";
        
       
            
        const myMessageIni="";
        const myMessage = items[i].messages.reduce(
        (Messageprev, Messageact) => Messageact.messageText +"  "+Messageprev,
        myMessageIni
        );
        myTabla+="<td>"+myMessage+"</td>"; 
        
        if(items[i].reservations){
            myTabla+="<td>"+items[i].reservations.length+"</td>";
        }else{
            myTabla+="<td>"+"0"+"</td>";
        } 
        myTabla+="<td><button onclick='actualizarLib(\""+items[i].id+"\")'>Editar</button>";
        myTabla+="<td><button onclick='eliminarLib(\""+items[i].id+"\")'>Eliminar</button>";
    }
     myTabla+="</tr>";
    
    $('#tabla').empty();
    $('#tabla').append(myTabla);
}
function guardarLib(){
     const categoryname=$('#libCategory').val();
    
$.ajax({
        url:"http://129.213.65.46:8090/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
           let category = respuesta.find(element => element.name===categoryname);
           let idCategory= category.id;
           
            const data=
            {
            name:$('#libName').val(),
            target:$('#libTarget').val(),
            capacity:$('#libCapacity').val(),
            description:$('#libDescription').val(),
            category:{id:idCategory}
            };
            let convertir=JSON.stringify(data);
            $.ajax({
            url:"http://129.213.65.46:8090/api/Lib/save",
            type:"POST",
            data:convertir,
            contentType:"application/JSON",
            datatype:"JSON",


            success:function(respuesta){
            alert("Libro Guardado!!");
            
            } 
            });
        },
        error:function(respuesta, xhr){
            alert("Error de peticion");
        }
});
}

function actualizarLib(codigo){
 $.ajax({
    url:"http://129.213.65.46:8090/api/Lib/"+codigo,  
    type:"GET",
    datatype:"JSON",
    success:function(respuesta){
    let idEditar=respuesta.id;
    const categoryname=$('#libCategory').val();
    $.ajax({
        url:"http://129.213.65.46:8090/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
           let category = respuesta.find(element => element.name===categoryname);
           let idCategory= category.id;
           const data=
            {  
            id: idEditar,   
            name:$('#libName').val(),
            target:$('#libTarget').val(),
            capacity:$('#libCapacity').val(),
            description:$('#libDescription').val(),
            category:{id:idCategory}
            };
            let convertir=JSON.stringify(data);
            $.ajax({
            url:"http://129.213.65.46:8090/api/Lib/update",
            type:"PUT",
            data:convertir,
            contentType:"application/JSON",
            datatype:"JSON",

            success:function(respuesta){
            $('#libName').val("");
            $('#libTarget').val("");
            $('#libCapacity').val("");
            $('#libDescription').val("");
            $('#libCategory').val("");
            mostrarLib();
            }
            });
        }
    });       
    }
});
}

function eliminarLib(codigo){
    var opcion=confirm("Esta seguro de eliminar el libro?");
    if(opcion===true){
    $.ajax({
    url:"http://129.213.65.46:8090/api/Lib/"+codigo,
    type:"DELETE",
    datatype:"JSON",

    success:function(respuesta){
    alert("Libro Eliminado!!");
    mostrarLib();
    }
    });
    }
}