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
    switch (type) {
        case 'province':
            area.provinces.splice(0,area.provinces.length);
            findArea(parentId,type,area.provinces);
            break;
        case 'city':
            area.cities.splice(0,area.cities.length);
            findArea(parentId,type,area.cities);
            break;
        case 'district':
            area.districts.splice(0,area.districts.length);
            findArea(parentId,type,area.districts);
            break;
    }
}


function findArea(parentId, type, arr) {
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
                    case 'province':
                        obj.text = ret[i].province;
                        break;
                    case 'city':
                        obj.text = ret[i].city;
                        break;
                    case 'district':
                        obj.text = ret[i].district;
                        break;
                }
                arr.push(obj);
            }
        }
    });
}


/**
 * 通用加载商品类别
 * @param parentCode
 */
function loadGoodClass(parentCode, type, goodClass) {
    switch (type) {
        case 0:
            goodClass.bigClasses.splice(0, goodClass.bigClasses.length);
            findGoodClass(parentCode, goodClass.bigClasses);
            break;
        case 1:
            goodClass.midClasses.splice(0, goodClass.midClasses.length);
            findGoodClass(parentCode, goodClass.midClasses);
            break;
        case 2:
            goodClass.littleClasses.splice(0, goodClass.littleClasses.length);
            findGoodClass(parentCode, goodClass.littleClasses);
            break;
    }
}

function findGoodClass(parentCode, arr) {
    axios.post("/goodClass/findGoodClass",
        {
            parentCode: parentCode
        }
    ).then(function (res) {
        if (res.data.code == 0) {
            var ret = res.data.data;
            for (let i = 0; i < ret.length; i++) {
                var obj = new Object();
                obj.value = ret[i].code;
                obj.text = ret[i].name;
                arr.push(obj);
            }
        }
    })
}