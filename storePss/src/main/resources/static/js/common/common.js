//获得url中参数
function getUrlKey(name){
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}

function getAreaId(type,str) {
    var aresIds = str.split(".");
    switch (type) {
        case "province":
            return aresIds[0];
            break;
        case "city":
            return aresIds[1];;
            break;
        case "district":
            return aresIds[2];
            break;
    }
}