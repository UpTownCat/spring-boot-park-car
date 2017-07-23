/**
 * Created by Administrator on 2017/7/7.
 */

var common = {
    /**
     * 提示弹出框
     * @param content
     */
    remind: function (content) {
        $.confirm({
            backgroundDismiss: true,
            title: "提示",
            "content": content,
            buttons: {
                "关闭": function(){},
            }
        })
    },
    /**
     * 验证浮点型
     * @param v
     * @returns {boolean}
     */
    validDouble: function (v) {
        //先进行整数验证
        if(common.validInteger(v))
            return true;
        var reg = /^(-?\d+)(\.\d+)?$/
        return reg.test(v)
    },
    /**
     * 验证整数
     * @param v
     * @returns {boolean}
     */
    validInteger: function (v) {
        var reg = /^-?\d+$/;
        return reg.test(v);
    },
    /**
     * 检查表单中是否有未填的输入
     * @param form
     * @returns {boolean}
     */
    validInput: function (form) {
        var $form = $(form)
        var labels = $form.find("label")
        var inputs = $form.find("input")
        for(var i = 0; i < inputs.length; i++) {
            var v = inputs[i].value.trim()
            // alert(v);
            if(v.length == 0) {
                var text = labels[i].innerHTML
                common.remind(text.substr(0, text.indexOf("：")) + "不能为空！")
                return false
            }
        }
        return true
    },
    /**
     * 预览图片
     * @param input 文件控件的标签
     * @param image 图像显示的标签
     */
    previewPhoto: function(input, image) {
        $(input).change(function () {
            var file = this.files[0]
            var type = file.type
            if(type != "image/jpg")
                if(type != "image/png")
                    if(type != "image/gif") {
                        common.remind("图片的格式只支持jpg, png, gif格式！")
                        return false
                    }
            var reader = new FileReader()
            reader.onload = function (e) {
                var data = e.target.result
                $(image).attr("src", data)
            }
            reader.readAsDataURL(file)
            return true
        })
    }
}