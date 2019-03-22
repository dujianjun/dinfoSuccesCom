package com.dscexpen.oa;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-06-08  15:14  星期五
 * version 1.0
 */
public class ShuXingTest {



    public class  A{

        private  boolean  isPaid;
        private  boolean  isPaying;

        private  String  name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isPaid() {
            return isPaid;
        }

        public void setPaid(boolean paid) {
            isPaid = paid;
        }

        public boolean isPaying() {
            return isPaying;
        }

        public void setPaying(boolean paying) {
            isPaying = paying;
        }

        @Override
        public String toString() {
            return "A{" +
                    "isPaid=" + isPaid +
                    ", isPaying=" + isPaying +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public void test(){
        A a = new A();
        a.setPaid(true);
        a.setPaying(false);
        System.out.println(a.toString());

    }


    public static void main(String[] args) throws Exception {

        ShuXingTest  ss = new ShuXingTest();
        ss.test();

    }


}
