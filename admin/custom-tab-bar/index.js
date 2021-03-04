Component({
    data: {
        selected: 0,
        color: "#7A7E83",
        backgroundColor: "#ffffff",
        selectedColor: "#3cc51f",
        list: [
            {
                "pagePath": "pages/index/index",
                "iconPath": "../image/book_gray.png",
                "selectedIconPath": "../image/book_green.png",
                "text": "首页"
            },
            {
                "pagePath": "pages/catalog/index",
                "iconPath": "../image/icon_component.png",
                "selectedIconPath": "../image/icon_component_HL.png",
                "text": "分类"
              },
              {
                "pagePath": "pages/shop/index",
                "iconPath": "../image/shop_gray.png",
                "selectedIconPath": "../image/shop_green.png",
                "text": "购物车"
              },
            {
                "pagePath": "pages/user/user",
                "iconPath": "../image/my_gray.png",
                "selectedIconPath": "../image/my_green.png",
                "text": "我的"
            }
        ]
    },
    attached() {
    },
    methods: {
        switchTab(event) {
            console.log("switchTab=>",event)
            const data = event.currentTarget.dataset
            const url = data.path
            wx.switchTab({
                url
            })
            this.setData({
                selected: data.index
            })
        }
    }
})
