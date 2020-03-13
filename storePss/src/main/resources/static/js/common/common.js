//获得url中参数
function getUrlKey(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}

//获得区域
function getTheProviderArea(areaIds, selectArea) {
    var areaIds = areaIds.split('.');
    $.post("/area/findAreaByIds", {"ids": "" + areaIds + ""}, function (res) {
        var resJson = JSON.parse(res);
        if (resJson.code == 0) {
            var ret = resJson.data;
            selectArea.provinceId = ret[0].id;
            selectArea.cityId = ret[1].id;
            selectArea.districtId = ret[2].id;
        }
    });
}


/**
 * 通用加载区域
 * parentId, 区域父id
 * type,查询类型 ：省、市、区县
 * area,存储省、市、区县对象
 * currentArea：默认选中的区域
 */

function loadAreaCommon(parentId, type, area) {
    var _this = this;
    if((area.provinces.length <= 0 && type == 'province')||(area.cities.length <= 0 && type == 'city')||(area.districts.length <= 0 && type == 'district')){
        axios.get("/area/findAreaByParentId",
            {
                params: {parentId: parentId}
            }
        ).then(function (res) {
            if (res.data.code == 0) {
                var ret = res.data.data;
                for (let i = 0; i < ret.length; i++) {
                    var obj = new Object();
                    obj.value = ret[i].id;
                    switch (type) {
                        case "province":
                            obj.text = ret[i].province;
                            area.provinces.push(obj);
                            break;
                        case "city":
                            obj.text = ret[i].city;
                            area.cities.push(obj);
                            break;
                        case "district":
                            obj.text = ret[i].district;
                            area.districts.push(obj);
                            break;
                    }
                }
            }
        });
    }
}

/**
 * 通用加载商品类别
 * @param parentCode
 */
function loadGoodClass(parentCode,type,goodClass) {
    if((goodClass.bigClasses.length <= 0 && type == 0)||(goodClass.midClasses.length <= 0 && type == 1)||(goodClass.littleClasses.length <= 0 && type == 2)){
        axios.post("/goodClass/findGoodClass",
            {
                parentCode:parentCode
            }
        ).then(function (res) {
            if (res.data.code == 0) {
                var ret = res.data.data;
                for (let i = 0; i < ret.length; i++) {
                    var obj = new Object();
                    obj.value = ret[i].code;
                    obj.text = ret[i].name;
                    switch (type) {
                        case 0:
                            goodClass.bigClasses.push(obj);
                            break;
                        case 1:
                            goodClass.midClasses.push(obj);
                            break;
                        case 2:
                            goodClass.littleClasses.push(obj);
                            break;
                    }
                }
            }
        })
    }
}