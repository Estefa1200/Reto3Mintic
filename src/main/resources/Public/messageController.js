function mostrarMessage(){
    $.ajax({
        url:"http://129.213.65.46:8090/api/Message/all",
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
        myTabla+="<th>"+"MESSAGE TEXT"+"</th>";
        myTabla+="<th>"+"LIB"+"</th>";
        myTabla+="<th>"+"CLIENT"+"</th>";
       
    myTabla+="</tr>";
        
    for(let i=0;i<items.length;i++){
        myTabla+="<tr>";
        myTabla+="<td>"+items[i].messageText+"</td>";
        myTabla+="<td>"+items[i].lib.name+"</td>";
        myTabla+="<td>"+items[i].client.name+"</td>";
        
  
    }
     myTabla+="</tr>";
    
    $('#tabla').empty();
    $('#tabla').append(myTabla);
}
function guardarMessage(){
     const libname=$('#messageLib').val();
     const clientname=$('#messageClient').val();
    
$.ajax({
        url:"http://129.213.65.46:8090/api/Lib/all",
        type:"GET",
        datatype:"JSON",
        
        success:function(respuesta){
           let lib = respuesta.find(element => element.name===libname);
           let idLib= lib.id;
           
            
           
            $.ajax({
            url:"http://129.213.65.46:8090/api/Client/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                
                let client = respuesta.find(element => element.name===clientname);
                let idClient= client.idClient;
              
                const data=
                {
                messageText:$('#messageText').val(),
                lib:{id:idLib},
                client:{idClient:idClient}
                };
                let convertir=JSON.stringify(data);
             
                $.ajax({
                url:"http://129.213.65.46:8090/api/Message/save",
                type:"POST",
                data:convertir,
                contentType:"application/JSON",
                datatype:"JSON",


                success:function(respuesta){
                alert("Mensaje Guardado!!");

                },
                error:function(respuesta, xhr){
                  
                    alert("Error de peticion message");
                } 
                });
            },
            error:function(respuesta, xhr){
           
                alert("Error de peticion cli");
            }
            
            });
        },
            
        error:function(respuesta, xhr){
            alert("Error de peticion li");
        }
});
    

}