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
    state: 1,
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
    state: 1,
    className: ""
}
//部门信息
dept = {id: "", deptName: "", areaCode: "", deptAreaName: "", deptAddress: "", state: 1}
//员工表单信息
empForm = {
    id: "",
    name: "",
    gender: "",
    birthday: "",
    birthdayStr: "",
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
    dept: "",
    roleId: "",
    roleList: ""
}

//仓库
repository = {
    id: "",
    name: "",
    code: "",
    remark: "",
    state: 1,
    deptId:""
}

//采购订单
purchaseOrder = {
    id: "",
    createDate: "",
    provider: provider,
    operationEmp: empForm,
    price: 0,
    remark: "",
    sate: "",
    type: "",
    purchaseOrderDetailList: []
}

//采购订单详情
purchaseOrderDetail = {
    id: "",
    tpoId: "",
    tpoName: "",
    repository: repository,
    good: good,
    gooNum: "",
    gooTax: "",
    gooTaxPrc: "",
    gooOtherPrice: "",
    gooTotalPrice: "",
    gooRemark: "",
},
//调拨订单
    allot = {
        id: "",
        inDeptId:"",
        inDept: dept,
        inRepId:"",
        inRep: repository,
        outDeptId:"",
        outDept: dept,
        outRepId:"",
        outRep: repository,
        empId: "",
        emp:empForm,
        state: "",
        remark: "",
        allotOrderDetail:[]
    },
//调拨订单详情
    allotOrderDetail = {
        id: "",
        rowId:"",
        aoId: "",
        gooId: "",
        good: good,
        gooNum: "",
        remark: ""
    },

//性别下拉选
    selectGender = [{value: '男', text: '男'}, {value: '女', text: '女'}]

//区域
area = {provinces: [], cities: [], districts: []}
selectArea = {provinceId: "", cityId: "", districtId: ""}

//选择商品类别
goodClass = {bigClasses: [], midClasses: [], littleClasses: []}
selectGoodClass = {bigClassCode: "", midClassCode: "", littleClassCode: ""}

//商品库存信息
goodStockInfo = {
    id: "",
    number: "",
    total: "",
    provider: provider,
    good: good,
    repository: repository
}

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
reg_identity = /^[1-9][0-9]{5}([1][9][0-9]{2}|[2][0][0|1][0-9])([0][1-9]|[1][0|1|2])([0][1-9]|[1|2][0-9]|[3][0|1])[0-9]{3}([0-9]|[X])$/;

//年
years = [
    {value: '2016', text: '2016'},
    {value: '2017', text: '2017'},
    {value: '2018', text: '2018'},
    {value: '2019', text: '2019'},
    {value: '2020', text: '2020'},
];

months = [
    {value: '1', text: '1'},
    {value: '2', text: '2'},
    {value: '3', text: '3'},
    {value: '4', text: '4'},
    {value: '5', text: '5'},
    {value: '6', text: '6'},
    {value: '7', text: '7'},
    {value: '8', text: '8'},
    {value: '9', text: '9'},
    {value: '10', text: '10'},
    {value: '11', text: '11'},
    {value: '12', text: '12'},
];

