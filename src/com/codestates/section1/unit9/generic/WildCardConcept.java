package com.codestates.section1.unit9.generic;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printBoldLine;
import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.7.5(수) 19h10
public class WildCardConcept {
    public static void main(String[] args) {
        PhoneFunction.call(new User<Phone>(new Phone()));
        PhoneFunction.call(new User<IPhone>(new IPhone()));
        PhoneFunction.call(new User<Galaxy>(new Galaxy()));
        PhoneFunction.call(new User<IPhone12Pro>(new IPhone12Pro()));
        PhoneFunction.call(new User<IphoneMini>(new IphoneMini()));
        PhoneFunction.call(new User<S22>(new S22()));
        PhoneFunction.call(new User<ZFlip3>(new ZFlip3()));

        printBoldLine();

//        PhoneFunction.faceId(new User<Phone>(new Phone()));
        PhoneFunction.faceId(new User<IPhone>(new IPhone()));
        PhoneFunction.faceId(new User<IPhone12Pro>(new IPhone12Pro()));
        PhoneFunction.faceId(new User<IphoneMini>(new IphoneMini()));
//        PhoneFunction.faceId(new User<Galaxy>(new Galaxy()));
//        PhoneFunction.faceId(new User<S22>(new S22()));
//        PhoneFunction.faceId(new User<ZFlip3>(new ZFlip3()));

        printBoldLine();

//        PhoneFunction.samsungPay(new User<Phone>(new Phone()));
//        PhoneFunction.samsungPay(new User<IPhone>(new IPhone()));
//        PhoneFunction.samsungPay(new User<IPhone12Pro>(new IPhone12Pro()));
//        PhoneFunction.samsungPay(new User<IphoneMini>(new IphoneMini()));
        PhoneFunction.samsungPay(new User<Galaxy>(new Galaxy()));
        PhoneFunction.samsungPay(new User<S22>(new S22()));
        PhoneFunction.samsungPay(new User<ZFlip3>(new ZFlip3()));

        printBoldLine();

        PhoneFunction.recordVoice(new User<Phone>(new Phone()));
//        PhoneFunction.recordVoice(new User<IPhone>(new IPhone()));
//        PhoneFunction.recordVoice(new User<IPhone12Pro>(new IPhone12Pro()));
//        PhoneFunction.recordVoice(new User<IphoneMini>(new IphoneMini()));
        PhoneFunction.recordVoice(new User<Galaxy>(new Galaxy()));
//        PhoneFunction.recordVoice(new User<S22>(new S22()));
//        PhoneFunction.recordVoice(new User<ZFlip3>(new ZFlip3()));
    }
}

class Phone {
}

class IPhone extends Phone {
}

class Galaxy extends Phone {
}

class IPhone12Pro extends IPhone {

}

class IphoneMini extends IPhone {
}

class S22 extends Galaxy {

}

class ZFlip3 extends Galaxy {

}

class User<T> {
    public T phone;

    public User(T phone) {
        this.phone = phone;
    }
}

class PhoneFunction {
    public static void call(User<? extends Phone> user) {
        printLine();
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("모든 Phone은 통화할 수 있음");
    }

    public static void faceId(User<? extends IPhone> user) {
        printLine();
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("IPhone만 Face ID를 사용할 수 있음");
    }

    public static void samsungPay(User<? extends Galaxy> user) {
        printLine();
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("Galaxy만 삼성 페이를 사용할 수 있음");
    }

    // 상속 계층도에서 Galaxy 및 Galaxy보다 위에 있는 상위 클래스만 타입으로 지정 가능
    public static void recordVoice(User<? super Galaxy> user) {
        printLine();
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("안드로이드 폰에서만 통화 녹음이 가능함");
    }
}




