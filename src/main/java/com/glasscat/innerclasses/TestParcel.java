//package com.glasscat.innerclasses;
//
//import com.glasscat.innerclasses.Parcel4.PDestination;
//
//import com.glasscat.innerclasses.Destination;
//
//class Parcel4 {
//    private class PContents implements Contents {
//        private int i;
//        @Override
//        public int value() {
//            return i;
//        }
//    }
//
//    protected final class PDestination implements Destination {
//        private String label;
//
//        public PDestination(String WhereTo) {
//            label = WhereTo;
//        }
//
//        @Override
//        public String readLabel() {
//            return label;
//        }
//    }
//
//    public Destination destination(String s) {
//        return new PDestination(s);
//    }
//
//    public Contents contents() {
//        return new PContents();
//    }
//
//}
//
//
//public class TestParcel {
//    public static void main(String[] args) {
//        Parcel4 p4 = new Parcel4();
//        Contents c = p4.contents();
//        Destination pd = p4.destination("hihahah");
//        PDestination pdCreat = p4.new PDestination("hihahah");
//        //Parcel4.PContents
//        System.out.println(pd.readLabel());
//    }
//}
