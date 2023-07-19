//package com.codestates.section1.unit6.condition.stuffedanimal;
//
//// 2023.7.18(화) 저녁 help/advice by Eddie
//public class MoreIfStatements {
//    // Here's an approach with a single method using if-statements.
//    class IStuffedAnimal { ...
//    }
//
//    class Bear extends LessIfStatements.IStuffedAnimal { ...
//    }
//
//    class Rabbit extends LessIfStatements.IStuffedAnimal { ...
//    }
//
//    class Bird extends LessIfStatements.IStuffedAnimal { ...
//    }
//
//    LessIfStatements.IStuffedAnimal makeStuffedAnimal(Input input) {
//        LessIfStatements.IStuffedAnimal result;
//
//        // Body
//        // This is just an example of how one could use input to instantiate the different classes.
//        if (input.ears == "round") {
//            result = new Bear();
//        } else if (input.ears == "long") {
//            result = new Rabbit();
//        } else if (input.ears == "none") {
//            result = new Bird();
//        }
//
//        result.stuffBody();
//
//        // Limbs
//        Arms arms;
//        Legs legs;
//
//        if (input.ears == "round") {
//            arms = new BearArms();
//            legs = new BearLegs();
//        } else if (input.ears == "long") {
//            arms = new RabbitArms();
//            legs = new RabbitLegs();
//        } else if (input.ears == "none") {
//            arms = new BirdWings();
//            legs = new BirdLegs();
//        }
//
//        result.attachArms(arms);
//        result.stuffArms();
//        result.attachLegs(legs);
//        result.stuffLegs();
//
//        // Ears
//        Ears ears;
//
//        if (input.ears == "round") {
//            ears = new BearEars();
//        } else if (input.ears == "long") {
//            ears = new RabbitEars();
//        } else if (input.ears == "none") {
//            ears = null;
//        }
//
//        if (ears != null) {
//            result.attachEars(ears);
//            result.stuffEars();
//        }
//
//        return result;
//    }
//}