/**
 * 取消贷款
 * @param url
 * @param data
 * @param success
 */
function  loanCancelBtn() {

    $.messager.confirm('确认', '是否确定取消贷款？', function (r) {
        if (r) {
            doServiceNoWait("../test/doServiceLoanCancel",{"1":1},function (data) {
                alert("状态值:" + data.success);

            })

        }
    });
}

/**
 * 二次放款
 * @param url
 * @param data
 * @param success
 */
function  twoLoanoanlBtn() {
    var appId=$('#s2f_appId').html();
    $.messager.confirm('确认', '是否确认二次放款？', function (r) {
        if (r) {
            doServiceNoWait("../task/remedyPaymentBankCard",{"appId":appId},function (data) {
            })
            $.messager.alert('info', "二次放款成功，请稍后刷新查看！", 'info');
        }
    });

}

