package com.dscexpen.IRR年化收益率;


import java.util.ArrayList;
import java.util.List;


public class IrrUtils {



    public static double getIrr(List<Double> cashFlow){
        /**迭代次数*/
        int LOOPNUM=1000;
        /**最小差异*/
        double MINDIF=0.00000001;

        double flowOut=cashFlow.get(0);
        double minValue=0d;
        double maxValue=1d;
        double testValue=0d;
        while(LOOPNUM>0){
            testValue=(minValue+maxValue)/2;
            double npv=NPV(cashFlow,testValue);
            if(Math.abs(flowOut+npv)<MINDIF){
                break;
            }else if(Math.abs(flowOut)>npv){
                maxValue=testValue;
            }else{
                minValue=testValue;
            }
            LOOPNUM--;
        }
        return testValue;
    }

    public static double NPV(List<Double> flowInArr,double rate){
        double npv=0;
        for(int i=1;i<flowInArr.size();i++){
            npv+=flowInArr.get(i)/Math.pow(1+rate, i);
        }
        return npv;
    }
    public static void main(String[] args) {
        double flowOut=-1000d;
        List<Double> flowInArr=new ArrayList<>();

        flowInArr.add(61.6667d);
        flowInArr.add(61.6667d);
        flowInArr.add(61.6667d);
        //************   不管分多少期，这儿永远都是12  ************
        System.out.println(IrrUtils.getIrr(flowInArr)*12);
    }




}
