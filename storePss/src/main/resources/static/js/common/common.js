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
            selectArea.districtId = ret[2]==null?"":ret[2].id;
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
            //清除数据
            area.cities.splice(0,area.cities.length);
            area.districts.splice(0,area.districts.length);
            _this.selectArea.cityId = "";
            _this.selectArea.districtId = "";
            findArea(parentId,type,area.provinces);
            break;
        case 'city':
            //清除数据
            area.cities.splice(0,area.cities.length);
            area.districts.splice(0,area.districts.length);
            _this.selectArea.districtId = "";
            findArea(parentId,type,area.cities);
            break;
        case 'district':
            area.districts.splice(0,area.districts.length);
            findArea(parentId,type,area.districts);
            break;
        case 'z':
            //清除数据
            area.cities.splice(0,area.cities.length);
            area.districts.splice(0,area.districts.length);
            _this.selectArea.cityId = "";
            _this.selectArea.districtId = "";
            findArea(parentId,type,area.cities);
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
                    case 'z':
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

//表单检测
function checkForm(obj,reg) {
    return reg.test(obj);
}

//弹出窗口
function Modalshow(url, title,arg) {
    layer.open({
        type: 2,
        area: [($(window).width() * 0.9) + 'px', ($(window).height() - 50) + 'px'],
        anim: 4,
        fix: false, //不固定
        maxmin: true,
        shadeClose: false,
        shade: 0.4,
        title: title,
        content: url,
        skin: 'layer-myskin',
        success: function(layero, index){
            var iframe = window['layui-layer-iframe'+index];
            //调用子页面的全局函数
            iframe.child(arg);
        }
    });
}

Array.prototype.remove = function remove(val) {
    var index = -1;
    for (var i = 0; i < this.length; i++) {
        if (this[i].id == val) {
            index = i;
        }
    }
    if (index > -1) {
        this.splice(index, 1);
    }
}


Array.prototype.remove2 = function remove(val) {
    var index = -1;
    for (var i = 0; i < this.length; i++) {
        if (this[i].helpNum == val) {
            index = i;
        }
    }
    if (index > -1) {
        this.splice(index, 1);
    }
}

//获得当前登陆人
function getEmp() {
    var emp = new Object();
    var _this = this;
    $.ajaxSettings.async = false;
    $.post("/user/getLogInUser").then(function (res) {
        var ret1 = JSON.parse(res)
        if (ret1.code == 0) {
            //查春员工
            $.post("/emp/queryByNoPage",{
                empId:JSON.parse(ret1.data.empId)
            }).then(function (res) {
                var ret2 = JSON.parse(res)
                if (ret2.code == 0) {
                    emp = ret2.data[0];
                }
            });
            //查询员工所在部门
            $.post("/dept/findDept1",{
                pageNum:1,
                pageSize:10,
                deptId:emp.deptId
            }).then(function (res) {
                var ret = JSON.parse(res);
                emp.dept = ret.data.list[0];
            })
        }
    });
    $.ajaxSettings.async = true;
    return emp;
}

