package com.dscexpen.json;


import com.alibaba.fastjson.JSONObject;


public class utils {

    public static void main(String[] args) {

        JSONObject jsonObj =new JSONObject();

        jsonObj.put("channelSource", "23");
        jsonObj.put("loanSerial", "23");
        jsonObj.put("debtNo", "23");
        jsonObj.put("loanerId", "23");
        jsonObj.put("loanAmount", "23");
        jsonObj.put("borrowRate", "23");
        jsonObj.put("applyDate", "23");
        jsonObj.put("loanTerm", "23");
        jsonObj.put("projectDes", "23");


        jsonObj.put("payBackType", "23");
        jsonObj.put("borrowFeesAmount", "23");
        jsonObj.put("borrowInterestAmount", "23");
        jsonObj.put("linkManTel", "23");
        jsonObj.put("linkMan", "23");
        jsonObj.put("loanerBank", "23");
        jsonObj.put("loanerCard", "23");
        jsonObj.put("loanerTel", "23");
        jsonObj.put("loanerName", "23");

        jsonObj.put("loanType", "00");
        jsonObj.put("companyName", "23");
        jsonObj.put("companyDepartment", "23");
        jsonObj.put("loanerHome", "23");
        jsonObj.put("familyRelatedName", "23");
        jsonObj.put("familyRelatedTel", "23");
        jsonObj.put("workRelatedName", "23");
        jsonObj.put("workRelatedTel", "23");
        jsonObj.put("household", "23");

        jsonObj.put("sign", "33");

        jsonObj.put("loanerSex", "00");
        jsonObj.put("loanerAge", "23");
        jsonObj.put("companyClass", "23");
        jsonObj.put("payBackNum", "23");
        jsonObj.put("applicationPicUrl", "23");
        jsonObj.put("idCardFrontPicUrl", "23");
        jsonObj.put("idCardBackPicUrl", "23");
        jsonObj.put("specialPicUrl", "23");
        jsonObj.put("creditPicUrl", "23");

        jsonObj.put("creditPaiedBackPicUrl", "00");
        jsonObj.put("bankSeriesPicUrl", "23");
        jsonObj.put("shiDiPicUrl", "23");
        jsonObj.put("payType", "23");

        jsonObj.put("loanNameType", "23");



        //toJSONString对明文参数进行字母排序

        String plain = jsonObj.toJSONString();
        System.out.println(plain);
    }

}
