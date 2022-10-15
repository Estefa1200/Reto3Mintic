function mostrarClient(){
    $.ajax({
        url:"http://129.213.65.46:8090/api/Client/all",
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
        myTabla+="<th>"+"EMAIL"+"</th>";
        myTabla+="<th>"+"NAME"+"</th>";
        myTabla+="<th>"+"AGE"+"</th>";
        myTabla+="<th>"+"MESSAGES"+"</th>";
        myTabla+="<th>"+"RESERVATIONS"+"</th>";
    myTabla+="</tr>";
        
    for(let i=0;i<items.length;i++){
        myTabla+="<tr>";
        myTabla+="<td>"+items[i].email+"</td>";
        myTabla+="<td>"+items[i].name+"</td>";
        myTabla+="<td>"+items[i].age+"</td>";    
             
        const myMessageIni="";
        const myMessage = items[i].messages.reduce(
        (Messageprev, Messageact) => Messageact.messageText +"  "+Messageprev,
        myMessageIni
        );
        myTabla+="<td>"+myMessage+"</td>"; 
        
        //debugger;
        if(items[i].reservations){
            myTabla+="<td>"+items[i].reservations.length+"</td>";
        }else{
            myTabla+="<td>"+"0"+"</td>";
        }
        
        
    }
     myTabla+="</tr>";
    
    $('#tabla').empty();
    $('#tabla').append(myTabla);
}
function guardarClient(){
   const data=
    {
    email:$('#clientEmail').val(),
    password:$('#clientPassword').val(),
    name:$('#clientName').val(),
    age:$('#clientAge').val()
    };
    
    let convertir=JSON.stringify(data);
    
$.ajax({
url:"http://129.213.65.46:8090/api/Client/save",
type:"POST",
data:convertir,
contentType:"application/JSON",
datatype:"JSON",


success:function(respuesta){
alert("Cliente Guardado!!");
//mostrarCategory();
}
});
}