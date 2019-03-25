package com.dscexpen.Test;


public class xx {

    public static void main(String[] args) throws Exception {

        String str = "广东省";
        String[] strings = str.split("-");
        System.out.println(strings[0] );

      /*  List<String>  aa = new ArrayList<>();
        aa.add("11");
        aa.add("11");
        List<String>  bb = new ArrayList<>(2);
       // bb.addAll(aa);
        Collections.copy(aa,bb);
        System.out.println(bb.toString());
*/

      /*  System.out.println(String.class.getClassLoader());
        System.out.println(DNSNameService.class.getClassLoader());
        System.out.println(xx.class.getClassLoader());*/

     /*   String str = "3期";
        System.out.println(str.substring(0,str.length()-1));*/

      /*  JSONArray jsonArray = JSONArray.fromObject("[19]");
        System.out.println(jsonArray.get(0));*/

       /* Integer [] a ={1,2,3,4};

        System.out.println(a[4]);*/
       // System.out.println(Arrays.toString(a));
       /* for(int i =0;i<=a.length ;i++){
            System.out.println(a[i]);
        }
*/
      /*  int ordinal = ProtocolSignResultEnum.已签约.ordinal();
        System.out.println(ordinal);
*/
      /*  Map<String,String>  hashMap = new HashMap<>();
        System.out.println(hashMap.get("2edsf"));*/


     /*   String str = "abc";
        str.toUpperCase();
        System.out.println(str.toUpperCase());*/

/*
        boolean  str = (false||true);
        System.out.println(str);*/



       /* SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        Calendar endDate = new GregorianCalendar();
        Calendar begindate = new GregorianCalendar();
        begindate.add(Calendar.DAY_OF_MONTH, -2);

        System.out.println(format.format(begindate.getTime()));
        System.out.println(format.format(endDate.getTime()));
        System.out.println(begindate.getTime().compareTo(endDate.getTime()));*/



   /*     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(sdf2.format(new Date()));*/


       /* Date date = ChineseWorkDay.chaekDate(sdf2.parse("2018-05-07"));

        String s1 = sdf2.format(new Date());
        String s2 = sdf2.format(date);
        System.out.println(s2);


        if(sdf2.parse(s1).before(sdf2.parse(s2))){
            System.out.println(11111111);
        }else{
            System.out.println(333333333);
        }*/




/*

        String str = "333";
      if(!StringUtils.isEmpty(str)){
          System.out.println(1111111111);
      }else{
          System.out.println(22222);
      }
*/




/*
 SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        //还款时间
        String tradeTime = "2018-04-02";
        String format = timeFormat.format(new Date());
        System.out.println(format);
*/






        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date bt=sdf.parse("2018-04-10");
        String sDate = sdf.format(new Date());
        Date now = null;
        now = sdf.parse(sDate);
        System.out.println(now);
        if(bt.before(now)){
            System.out.println(now);
        }else{
            System.out.println("22222222222222");
        }
*/


      /*  DecimalFormat decimalFormat = new DecimalFormat("0.00");
        BigDecimal detailAmount = null;
        detailAmount = new BigDecimal(0.00);
       // detailAmount = detailAmount.add(new BigDecimal(387.89));

        detailAmount =  new BigDecimal(decimalFormat.format(387.89));


        System.out.println(detailAmount);
*/

/*
        BigDecimal multiply = new BigDecimal("100").multiply(new BigDecimal("0.02"));
        System.out.println();
*/

      /*  String amountSum = "121";
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(new BigDecimal(decimalFormat.format(Double.parseDouble(amountSum))));*/

    }

}
