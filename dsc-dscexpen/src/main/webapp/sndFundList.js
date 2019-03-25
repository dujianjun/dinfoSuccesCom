
function  loanCancelBtn() {

    $.messager.confirm('确认', '是否确定取消？', function (r) {
        if (r) {
            doServiceNoWait("../test/doServiceLoanCancel",{"1":1},function (data) {
                alert("状态值:" + data.success);

            })

        }
    });
}


function  twoLoanoanlBtn() {
    var appId=$('#s2f_appId').html();
    $.messager.confirm('确认', '是否确认？', function (r) {
        if (r) {
            doServiceNoWait("../task/remedyPaymentBankCard",{"appId":appId},function (data) {
            })
            $.messager.alert('info', "二次成功，请稍后刷新查看！", 'info');
        }
    });

}

