Component({
    data: {
        selected: 0,
        color: "#7A7E83",
        backgroundColor: "#ffffff",
        selectedColor: "#3cc51f",
        list: [
            {
                "pagePath": "pages/index/index",
                "iconPath": "../image/icon_component.png",
                "selectedIconPath": "../image/icon_component_HL.png",
                "text": "分类"
            },
            {
                "pagePath": "pages/user/user",
                "iconPath": "../image/icon_API.png",
                "selectedIconPath": "../image/icon_API_HL.png",
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
