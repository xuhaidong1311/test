
function $$(id) { return document.getElementById(id); }

/// ����Cookieֵ
function setCookie(name, value, days) {
    var expires = "";
    if (days) {
        var d = new Date();
        d.setTime(d.getTime() + days * 24 * 60 * 60 * 1000);
        expires = "; expires=" + d.toGMTString();
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}


/// ��ȡCookieֵ
function getCookie(name) {
    var re = new RegExp("(\;|^)[^;]*(" + name + ")\=([^;]*)(;|$)");
    var res = re.exec(document.cookie);
    return res != null ? res[3] : null;
}

/// ���ýű�
function callScript(url, loaded, error, charset) {
    var script = document.createElement("script");
    if (typeof charset == "string") script.charset = charset;
    script.onreadystatechange = function() {
        switch (this.readyState) {
            case "complete":
            case "loaded":
                if (typeof loaded == "function") loaded();
                if (script.parentNode) script.parentNode.removeChild(script);
                break;
        }
    }
    script.onload = function() {
        if (typeof loaded == "function") loaded();
        if (script.parentNode) script.parentNode.removeChild(script);
    }
    script.onerror = function() {
        if (typeof error == "function") error();
        if (script.parentNode) script.parentNode.removeChild(script);
    }

    script.type = "text/javascript";
    script.defer = "true";
    script.src = url;
    var parent = document.getElementsByTagName("HEAD")[0] || document.documentElement;
    parent.insertBefore(script, parent.firstChild);
}


/// ִ��http����
function requestHttp(url, type, loaded) {
    if (typeof loaded != "function") return;
    var xmlhttp = typeof XMLHttpRequest == "undefined" ?
	    new ActiveXObject("Microsoft.XMLHTTP") : new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            loaded(xmlhttp);
    }
    xmlhttp.open(typeof type == "string" ? type : "GET", url, true);
    xmlhttp.send(null);
}

/// ���Ԫ�صľ�������
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


/// ����¼�
function addEventHandler(target, type, func) {
    if (target.addEventListener)
        target.addEventListener(type, func, false);
    else if (target.attachEvent)
        target.attachEvent("on" + type, func);
    else target["on" + type] = func;
}

/// �Ƴ��¼�
function removeEventHandler(target, type, func) {
    if (target.removeEventListener)
        target.removeEventListener(type, func, false);
    else if (target.detachEvent)
        target.detachEvent("on" + type, func);
    else delete target["on" + type];
}