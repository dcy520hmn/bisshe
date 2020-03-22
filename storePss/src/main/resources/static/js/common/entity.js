/*商品pojo*/
goods = {
    id: "",
    name: "",
    alert: "",
    specification: "",
    unit: "",
    origan: "",
    remark: "",
    createDate: "",
    updateDate: "",
    isDelete: "",
    modifier: "",
    selling: "",
    repositoryNumber: ""
},

    /*分页pojo*/
    pageInfo = {
        list: [],
        pageNum: 1,
        pageSize: 6,
        size: "",
        total: "",
        prePage: "",
        nextPage: ""
    },


    /*顾客*/
    customer = {
        id: "",
        name: "",
        phone: "",
        company: "",
        remark: "",
        creatDate: "",
        updateDate: "",
        isDelete: "",
        modifier: ""
    }

/*用户*/
user = {
    id: "",
    userName: "",
    password: "",
    describe: "",
    createDate: "",
    updateDate: "",
    deleteStatus: "",
    modifierId: "",
    phoneNumber: "",
    status: "",
    roles: []
}

/*角色*/
role = {
    id: "",
    roleName: "",
    describe: "",
    status: "",
    deleteStatus: "",
    createDate: "",
    updateDate: "",
    modifierId: "",
    roleNum: ""
}

/*权限*/
auth = {id: "", authName: "", authDesc: "", authPath: "", authParentId: ""}

/*供应商*/
provider = {
    id: "",
    attribute: "",
    areaId: "",
    areaName: "",
    name: "",
    shortName: "",
    messagePhone: "",
    messageName: "",
    address: "",
    bank: "",
    account: "",
    present: "",
    postcode: "",
    email: "",
    state: "",
}

//商品信息
good = {
    id: "",
    helpNum: "",
    gClass: "",
    type: "",
    size: "",
    name: "",
    unit: "",
    max: "",
    min: "",
    prePrice: "",
    cost: "",
    remark: "",
    state: "",
    className: ""
}
//部门信息
dept = {id: "", deptName: "", areaCode: "", deptAddress: "", state: ""}
//员工表单信息
empForm = {
    id: "",
    name: "",
    gender: "",
    birthday: "",
    birthdayStr:"",
    identity: "",
    phone: "",
    address: "",
    areaCode: "",
    hireDate: "",
    hireDateStr: "",
    deptId: "",
    salary: "",
    sate: "",
    userName: "",
    password: "",
    dept:""
}
//性别下拉选
selectGender = [{value: '男', text: '男'}, {value: '女', text: '女'}]

//区域
area = {provinces: [], cities: [], districts: []}
selectArea = {provinceId: "", cityId: "", districtId: ""}

//选择商品类别
goodClass = {bigClasses: [], midClasses: [], littleClasses: []}
selectGoodClass = {bigClassCode: "", midClassCode: "", littleClassCode: ""}


//手机验证码正则
phoneReg = /^[1][3,4,5,7,8][0-9]{9}$/

//邮箱正则
emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/

//整数正则
num = /^-?\d+$/

//价格正则
price = /^(([^0][0-9]+|0)\.([0-9]{1,2})$)|^([^0][0-9]+|0)$/

//非空正则
reg_null = /^\s*$/g

//身份证正则
reg_identity=/^[1-9][0-9]{5}([1][9][0-9]{2}|[2][0][0|1][0-9])([0][1-9]|[1][0|1|2])([0][1-9]|[1|2][0-9]|[3][0|1])[0-9]{3}([0-9]|[X])$/;

