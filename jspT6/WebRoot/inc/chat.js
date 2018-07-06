
var lastMsg="";
var colors=["00","33","66","99","CC","FF"];
$(document).ready(function(){
	init();
});

$(document).click(function(){
		window.document.title="������������ʵ��ֱ���䣡"
});

$(document).keydown(function(e){
		e=e?e:event;
		if(e.keyCode==13){
			sendMessage($$("send"));
		}
});
//��ʼ������
function init(){
	for(var i=0;i<=84;i++){
		$("#editor_face_menu").append("<img src=\"face/" + i + ".gif\" alt=\"\" onclick=\"setFace(this);\" /> ");
	} 
	
	for(var i=0;i<colors.length;i++){
		for(var j=0;j<colors.length;j++){
			for(var k=0;k<colors.length;k++){
				co="#" + colors[i] + colors[j] + colors[k];
                $("#editor_color_menu").append("<input type=\"button\" style=\"border:0px;margin:1px;width:10px;height:10px;background-color:" + co + "\" onclick=\"setColor(this);\" />");
            }
        }
    }
}

//������Ϣ
function sendMessage(obj){
	var fcolor=$("input[@name=sfcolor]").val();
	var fface=$("input[@name=slist]").val();
	//�����û����͵���������
	var tomsg=$("input[@name=smess]").val();
	if(tomsg=="" && fface==""){showStip(obj,"������������ٶ�ѡһŶ��",10,-30);return false;}
    if(lastMsg==""){
    	
    	lastMsg=tomsg;
    }
    if(lastMsg.length>100){showStip(obj,"�������ݲ��ܶ���100�֣�",10,-30);return false;}
    window.location.href="ChatManagerServlet?flag=_send&msg="+lastMsg+"&color="+fcolor;
}      


//���öԻ�����
function setTo(user){
	$("input[@name=stowho]").val(user);
}

//�˵�
function showMenu(indexw,obj){
    var point=absolutePoint(obj);
    var ob=((indexw==0)?'#editor_color_menu':'#editor_face_menu');
    var cb=((indexw==0)?'#editor_face_menu':'#editor_color_menu');
    $(ob).css({'border':'1px #dddddd solid','background-color':'#ffffff'});
    if($(ob).is(':visible')){
        $(ob).fadeOut();
    }else{
        $(cb).fadeOut();
        $(ob).fadeIn();
        $(ob).css({"display":"block","left":point.x,"top":(point.y-parseInt($(ob).css('height'))-10)}); 
    }
}

//������ɫ
function setColor(obj){
    $('input[@name=sfcolor]').val($(obj).css('background-color'));
    $('#editor_color_menu').fadeOut();
    $("input[@name=smess]").focus();
}

//���ñ���
function setFace(obj){
    $('input[@name=slist]').val($(obj).attr('src'));
    $('#editor_face_menu').fadeOut();
    $("input[@name=smess]").focus();
    showStip("talkface","��ѡ�����:<img src='" + $(obj).attr('src') + "' style='vertical-align:top;' alt='����' />",0,-30);
    lastMsg=lastMsg+$("input[@name=smess]").val()+"<img src='"+$(obj).attr('src')+"'>";
}


//��ʾС��ʾ
function showStip(target,txt,x,y){
  var obj=typeof target=="string" ?$$(target):target
  var point=absolutePoint(obj);
  $("#tit").html(txt);
  $("#stip").click(function(){$(this).fadeOut()});
  $("#stip").css({"cursor":"pointer","top":point.y+y,"left":point.x+x,"background":"url(img/images/2_2.gif) repeat-x"}).fadeIn("fast");
}



function ask(str){
    return window.confirm(str)?true:false;
}

function absolutePoint(element) {
    var result = { x: element.offsetLeft, y: element.offsetTop };
    element = element.offsetParent;
    while (element) {
        result.x += element.offsetLeft;
        result.y += element.offsetTop;
        element = element.offsetParent;
    }
    return result;
}
//�û��˳�
function  logout(){
	 var reult=ask("�Ƿ�Ҫ�˳�ֱ����?");
	 if(reult){
		 window.location.href="UserInfoManagerServlet?flag=_logout";
	 }
}

function clearMsg(){
	
	 var reult=ask("�Ƿ�Ҫɾ�������û������¼?");
	 if(reult){
		 window.location.href="AdminManagerServlet?flag=_clear";
	 }
	
}