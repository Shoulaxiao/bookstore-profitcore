import {Http} from './request'
let http=new Http();
//用户登录
function userLogin() {
   wx.checkSession({
       success:(res)=>{
           //登录状态
       },
       fail:(res)=>{
           onLogin()
       }
   })
}

function onLogin() {
    wx.login({
        success:(res)=>{
            if (res.code){
                // 发送 res.code 到后台换取 自定义session
                http.request({
                    url: 'api/wx/login',
                    data: {code: res.code},
                    success:(resp)=>{
                        console.log("res=>",resp)
                        if (resp.success){
                            //本地存储session
                            wx.setStorage({
                                key:'',
                                data:res.data
                            })
                            getUserInfo()
                        }
                    },
                    fail:function (res) {

                    }
                })

            }
        },
        fail:function (res) {

        }
    })
}


function getUserInfo() {
   wx.getUserInfo({
       success:(res)=>{
           var userInfo = res.userInfo
           saveUserInfoToServer(userInfo)
       },
       fail:(res)=>{
           userAccess()
       }
   })
}


function saveUserInfoToServer(userInfo) {
    wx.getStorage({
        key:'',
        success:(res)=>{
            http.request({
                url:'api/wx/login/saveUserInfo',
                data:{
                    nickName: userInfo.nickName,
                    avatarUrl: userInfo.avatarUrl,
                    gender: userInfo.gender,
                    province: userInfo.province,
                    city: userInfo.city,
                    country: userInfo.country
                },
                success:(res)=>{
                    if (res.success){

                    }
                }
            })
        }
    })
}
function userAccess(){

}