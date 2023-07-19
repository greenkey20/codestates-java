package com.codestates.section1.unit6.condition.stuffedanimal;

// 2023.7.18(화) 저녁 help/advice by Eddie
public class MoreIfStatements {

    // Here's an approach with a single method using if-statements.

    class IStuffedAnimal {...}
    class Bear extends IStuffedAnimal { ... }
    class Rabbit extends IStuffedAnimal { ... }
    class Bird extends IStuffedAnimal { ... }

    IStuffedAnimal MakeStuffedAnimal(Input input) {
        IStuffedAnimal result;

        // Body
        // This is just an example of how one could use input to instantiate the different classes.

        if (input.ears == "round") {
            result = new Bear();
        } else if (input.ears == "long") {
            result = new Rabbit();
        } else if (input.ears == "none") {
            result = new Bird();
        }

        result.StuffBody();

        // Limbs

        Arms arms;
        Legs legs;

        if (input.ears == "round") {
            arms = new BearArms();
            legs = new BearLegs();
        } else if (input.ears == "long") {
            arms = new RabbitArms();
            legs = new RabbitLegs();
        } else if (input.ears == "none") {
            arms = new BirdWings();
            legs = new BirdLegs();
        }

        result.AttachArms(arms);
        result.StuffArms();
        result.AttachLegs(legs);
        result.StuffLegs();

        // Ears

        Ears ears;

        if (input.ears == "round") {
            ears = new BearEars();
        } else if (input.ears == "long") {
            ears = new RabbitEars();
        } else if (input.ears == "none") {
            ears = null;
        }

        if (ears != null) {
            result.AttachEars(ears);
            result.StuffEars();
        }

        return result;
    }
}
