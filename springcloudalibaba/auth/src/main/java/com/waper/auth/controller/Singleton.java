package com.waper.auth.controller;

/**
 * @ClassName Singleton
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/3/6 16:24
 */
public class Singleton {
    public Singleton() {
    }
// 1.      private static Singleton singleton = new Singleton();
//
//

////
////    public static Singleton getInstance() {
////        return singleton;
////    }


//  2.  private static Singleton singleton = null;
//
//    public static Singleton getInstance() {
//         if (singleton == null) {
//             return new Singleton();
//         }
//        return singleton;
//    }


    //    private static volatile Singleton singleton = null;
    //
    //    public static Singleton getInstance() {
    //        if (singleton == null) {
    //            synchronized (Singleton.class) {
    //                if (singleton == null) {
    //                    return new Singleton();
    //                }
    //
    //            }
    //        }
    //        return singleton;
    //    }



}
