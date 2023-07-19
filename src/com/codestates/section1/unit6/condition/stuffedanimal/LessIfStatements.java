package com.codestates.section1.unit6.condition.stuffedanimal;

// 2023.7.18(화) 저녁 help/advice by Eddie
public class LessIfStatements {

    //// Here's an approach with "handlers" for each animal type.

    class IStuffedAnimal {...}

    interface IStuffedAnimalMaker {
        MoreIfStatements.IStuffedAnimal MakeBody();
        IArms MakeArms();
        ILegs MakeLegs();
        IEars MakeEars();
    }

    class BearMaker extends IStuffedAnimalMaker {
        MoreIfStatements.IStuffedAnimal MakeBody() { ... return ... }
        IArms MakeArms() { ... return ... }
        ILegs MakeLegs() { ... return ... }
        IEars MakeEars() { ... return ... }
    }

    enum AnimalType {
        BEAR,
        RABBIT,
        BIRD
    }

    AnimalType DetermineType(Input input) {
        if (input.ears == "round") {
            return BEAR;
        } else if (input.ears == "long") {
            return RABBIT;
        } else if (input.ears == "none") {
            return BIRD;
        }
    }

    IStuffedAnimalMaker GetMaker(AnimalType type, Input input) {
        if (type == BEAR) {
            return new BearMaker(input);
        } else if (type == BEAR) {
            return new RabbitMaker(input);
        } else if (type == BIRD) {
            return new BirdMaker(input);
        }
    }

    MoreIfStatements.IStuffedAnimal MakeStuffedAnimal(Input input) {
        AnimalType type = DetermineType(input);
        IStuffedAnimalMaker maker = GetMaker(type, input);

        // Body
        MoreIfStatements.IStuffedAnimal result = maker.MakeBody();
        result.StuffBody();

        // Limbs
        IArms arms = maker.MakeArms();
        result.AttachArms(arms);
        result.StuffArms();

        ILegs legs = maker.MakeLegs();
        result.AttachLegs(legs);
        result.StuffLegs();

        // Ears
        IEars ears = maker.MakeEars();
        if (ears != null) {
            result.AttachEars(ears);
            result.StuffEars();
        }

        return result;
    }

// In the above example there's still an if-statement in MakeStuffedAnimal. You
// can change how the maker works to avoid that. Here I'm passing in a stuffed
// animal to the methods and let them do all the work:

    MoreIfStatements.IStuffedAnimal MakeStuffedAnimal(Input input) {
        AnimalType type = DetermineType(input);
        IStuffedAnimalMaker maker = GetMaker(type, input);

        MoreIfStatements.IStuffedAnimal result = maker.MakeAndStuffBody();
        maker.MakeAndAttachArmsToAnimal(result);
        maker.MakeAndAttachLegsToAnimal(result);
        maker.MakeAndAttachEarsToAnimal(result);

        return result;
    }
}
