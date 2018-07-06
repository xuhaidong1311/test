$(document).ready(function(){
    session();
});

function session(){
    $("#serr").html("������...");
	var sendUrl="type=session&rnd=" + Math.random();
	var sessionValue="";
	$.ajax({
 	type	: "post",
	async	: false,
 	url	    : "adminAction.asp",
 	data	: sendUrl,
 	success	: function(msg){
 	            if(msg=="ok"){
			        $("#logins").fadeOut();
			        $("#logouts").fadeIn();		
			    }else{
			        $("#logouts").fadeOut();				    
			        $("#logins").fadeIn();

			    }
			    $("#serr").html("");
		},
	error 	: function(){$("#serr").html("����ʧ��");}
	}); 
}
//��¼
function adminLogin(){
	var username=$("#adminname").val();
	var userpwd=$("#adminpwd").val();
	if(username=="" || userpwd==""){alert("������������Ϣ��");return false;}
	var sendUrl="username=" + escape(username) + "&password=" + escape(userpwd) + "&type=login&rnd=" + Math.random();
	var sessionValue="";
	$.ajax({
 	type	: "post",
	async	: true,
 	url	    : "adminAction.asp",
 	data	: sendUrl,
 	success	: function(msg){
 	            if(msg=="ok"){
			        session();
			        $("#adminpwd").val("");		
			    }else{
                    alert("�û������������!");
                    $("#adminpwd").val("");
			    }
		},
	error 	: function(){$("#serr").html("����ʧ��");}
	}); 
}

//��ʾС��ʾ
function showStip(target,txt,x,y){
    var obj=typeof target=="string" ?$$(target):target
    var point=absolutePoint(obj);
    $("#tit").html(txt);
    $("#stip").click(function(){$(this).fadeOut()});
    $("#stip").css({"cursor":"pointer","top":point.y+y,"left":point.x+x,"background":"url(img/images/2_2.gif) repeat-x"}).fadeIn("fast");
}


function logout(){
	var sendUrl="type=logout&rnd=" + Math.random();
	$.ajax({
 	type	: "post",
	async	: true,
 	url	    : "adminAction.asp",
 	data	: sendUrl,
 	success	: function(msg){
 	            if(msg=="ok"){
			        alert("�Ѿ��ǳ�!");	
			        session();	
			    }
		},
	error 	: function(){$("#serr").html("����ʧ��");}
	}); 
}

function compact(){
	var sendUrl="rnd=" + Math.random();
	var sessionValue="";
	$.ajax({
 	type	: "post",
	async	: true,
 	url	    : "inc/dopact.asp",
 	data	: sendUrl,
 	success	: function(msg){
 	            if(msg!=""){
                    alert(msg);	
			    }else{
                    alert("ѹ��ʧ��,������û�����Ȩ��!");

			    }
		},
	error 	: function(){$("#serr").html("����ʧ��");}
	}); 
}