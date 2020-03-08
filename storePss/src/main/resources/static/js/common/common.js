//获得url中参数
function getUrlKey(name){
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}

//获得区域
function getArea(areaIds,selectArea) {
    var areaIds = areaIds.split('.');
    $.post("/area/findAreaByIds", {"ids": ""+areaIds+""}, function (res) {
        var resJson = JSON.parse(res);
        if (resJson.code == 0) {
            var ret = resJson.data;
            selectArea.provinceId = ret[0].id;
            selectArea.provinceName = ret[0].province;
            selectArea.cityId = ret[1].id;
            selectArea.cityName = ret[1].city;
            selectArea.districtId = ret[2].id;
            selectArea.districtName = ret[2].district;
        }
    });
}

//通用加载区域
function loadAreaCommon(parentId, type,area) {
    var _this = this;
    axios.get("/area/findAreaByParentId",
        {
            params: {parentId: parentId}
        }
    ).then(function (res) {
        if (res.data.code == 0) {
            var ret = res.data.data;
            switch (type) {
                case "province":
                    for (let i = 0; i < ret.length; i++) {
                        var province = new Object();
                        province.text = ret[i].province;
                        province.value = ret[i].id;
                        area.provinces.push(province);
                    }
                    break;
                case "city":
                    for (let i = 0; i < ret.length; i++) {
                        var city = new Object();
                        city.text = ret[i].city;
                        city.value = ret[i].id;
                        area.cities.push(city);
                    }
                    break;
                case "district":
                    for (let i = 0; i < ret.length; i++) {
                        var district = new Object();
                        district.text = ret[i].district;
                        district.value = ret[i].id;
                        area.districts.push(district);
                    }
                    break;
            }
        }
    });
}