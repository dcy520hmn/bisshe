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
auth = {
    id: "",
    authName: "",
    authDesc: "",
    authPath: "",
    authParentId: ""
}

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


//手机验证码正则
phoneReg = /^[1][3,4,5,7,8][0-9]{9}$/;

//邮箱正则
emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
