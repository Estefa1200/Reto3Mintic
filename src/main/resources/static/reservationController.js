function mostrarReservation(){
    $.ajax({
        url:"http://129.213.65.46:8090/api/Reservation/all",
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
        myTabla+="<th>"+"START DATE"+"</th>";
        myTabla+="<th>"+"DEVOLUTION DATE"+"</th>";
        myTabla+="<th>"+"STATUS"+"</th>";
        myTabla+="<th>"+"LIB"+"</th>";
        myTabla+="<th>"+"CLIENT"+"</th>";
        myTabla+="<th>"+"SCORE"+"</th>";
        
    myTabla+="</tr>";
        
    for(let i=0;i<items.length;i++){
        myTabla+="<tr>";
        myTabla+="<td>"+items[i].startDate+"</td>";
        myTabla+="<td>"+items[i].devolutionDate+"</td>";
        myTabla+="<td>"+items[i].status+"</td>";
        myTabla+="<td>"+items[i].lib.name+"</td>";
        myTabla+="<td>"+items[i].client.name+"</td>";
        
        if(items[i].score){
        const myScoreIni="";
        const myScore = items[i].score.reduce(
        (Scoreprev, Scoreact) => Scoreact.score +"  "+Scoreprev,
         myScoreIni
        );
        //console.log(myLibro);
        myTabla+="<td>"+myScore+"</td>";
        }else{
           myTabla+="<td>"+"0"+"</td>";
        }
       
    }
     myTabla+="</tr>";
    
    $('#tabla').empty();
    $('#tabla').append(myTabla);
}
function guardarReservation(){
     const libname=$('#reservationLib').val();
     const clientname=$('#reservationClient').val();
    
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
                startDate:$('#startDate').val(),
                devolutionDate:$('#devolutionDate').val(),
                status:"created",
                lib:{id:idLib},
                client:{idClient:idClient}
                
                };
                let convertir=JSON.stringify(data);
                
                $.ajax({
                url:"http://129.213.65.46:8090/api/Reservation/save",
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