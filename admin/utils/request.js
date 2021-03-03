import {config} from "../config/index";

const tips = {
    1: '抱歉，出现了一个未知错误',
    1005: 'appkey无效，请前往www.***.pro申请',
    3000: '期刊不存在'
}

class Http {

    //网络请求函数
    request(param) {
        //默认请求方式为GET
        if (!param.method) {
            param.method = 'GET'
        }

        wx.request({
            url: config.aip_base_url + param.url,
            method: param.method,
            data: param.data,
            header: {
                'content-type': 'application/json',
                'appkey': config.appkey,
            },
            success: (res) => {
                let code = res.statusCode.toString()
                // 判断状态码是否以2开头,请求成功，执行回调函数
                if (code.startsWith('2')) {
                    param.success(res.data)
                } else {
                    let errorCode = res.data.errorCode
                    this._show_error(errorCode);
                }
            },
            fail: (err) => {
                this._show_error(1)
            }
        })
    }

    _show_error(error_code) {
        if (!error_code) {
            error_code = 1
        }
        wx.showToast({
            title: tips[error_code],
            icon: 'none',
            duration: 2000
        })
    }
}

export {
    Http
}