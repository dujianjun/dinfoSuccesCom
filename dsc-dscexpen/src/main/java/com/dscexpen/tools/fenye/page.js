function toVaild(){
   var pagego = $("#go").val();
   var totalPage = $("#total").text();
    var reg = new RegExp("^([1-9][0-9]*)$");
    if(pagego !=""){
       
       if( reg.test(pagego)){
          if(parseInt(pagego)>parseInt(totalPage)){
             alert("你输入的页数超出范围,请重新输入");
             return false;
          }
       }else{
          alert("你输入的格式不正确,请输入数字");
          return false;
       }
    }else{
       alert("请输入跳转的页码");
       return false;
    }
   
   var href = $(".pagination > li > form").attr("action");
   var str = new Array();
   str = href.split("?");
   var str1 = new Array();
   str1 = str[1].split("&");
   var str2 = new Array();
   var url=str[0]+"?";
   for(i=0;i<str1.length;i++){
      str2 = str1[i].split("=");
      if(str2.length>1){
         url +=str2[0]+"="+encodeURI(encodeURI(str2[1]))+"&";
      }
   }
   
   window.location.href=url+"page="+pagego;
   return false;
}