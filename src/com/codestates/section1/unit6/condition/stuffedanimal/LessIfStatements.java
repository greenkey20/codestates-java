package com.codestates.section1.unit6.condition.stuffedanimal;

// 2023.7.18(화) 저녁 help/advice by Eddie
public class LessIfStatements {

    // Here's an approach with "handlers" for each animal type.
    class IStuffedAnimal {
        void stuffBody();

        void attachArms(Arms arms);

        void stuffArms();

        void attachLegs(Legs legs);

        void stuffLegs();

        void attachEars(Ears ears);

        void stuffEars();
    }

    interface IStuffedAnimalMaker {
        IStuffedAnimal makeBody();

        IStuffedAnimal makeAndStuffBody();

        IArms makeArms();

        ILegs makeLegs();

        IEars makeEars();

        void makeAndAttachArmsToAnimal(IStuffedAnimal stuffedAnimal);

        void makeAndAttachLegsToAnimal(IStuffedAnimal stuffedAnimal);

        void makeAndAttachEarsToAnimal(IStuffedAnimal stuffedAnimal);
    }

    class BearMaker implements IStuffedAnimalMaker {
        IStuffedAnimal makeBody() { ...return ...}

        IStuffedAnimal makeAndStuffBody() { ...return ...}

        IArms makeArms() { ...return ...}

        ILegs makeLegs() { ...return ...}

        IEars makeEars() { ...return ...}

        @Override
        public void makeAndAttachArmsToAnimal(IStuffedAnimal stuffedAnimal) {

        }

        @Override
        public void makeAndAttachLegsToAnimal(IStuffedAnimal stuffedAnimal) {

        }

        @Override
        public void makeAndAttachEarsToAnimal(IStuffedAnimal stuffedAnimal) {

        }
    }

    enum AnimalType {
        BEAR,
        RABBIT,
        BIRD
    }

    AnimalType determineType(Input input) {
        if (input.ears == "round") {
            return BEAR;
        } else if (input.ears == "long") {
            return RABBIT;
        } else /*if (input.ears == "none")*/ {
            return BIRD;
        }
    }

    IStuffedAnimalMaker getMaker(AnimalType type, Input input) {
        if (type == BEAR) {
            return new BearMaker(input);
        } else if (type == BEAR) {
            return new RabbitMaker(input);
        } else /*if (type == BIRD)*/ {
            return new BirdMaker(input);
        }
    }

    IStuffedAnimal makeStuffedAnimalWithIf(Input input) {
        AnimalType type = determineType(input);
        IStuffedAnimalMaker maker = getMaker(type, input);

        // Body
        IStuffedAnimal result = maker.makeBody();
        result.StuffBody();

        // Limbs
        IArms arms = maker.makeArms();
        result.attachArms(arms);
        result.stuffArms();

        ILegs legs = maker.makeLegs();
        result.attachLegs(legs);
        result.stuffLegs();

        // Ears
        IEars ears = maker.makeEars();
        if (ears != null) {
            result.attachEars(ears);
            result.stuffEars();
        }

        return result;
    }

    // In the above example there's still an if-statement in makeStuffedAnimal. You
// can change how the maker works to avoid that. Here I'm passing in a stuffed
// animal to the methods and let them do all the work:
    IStuffedAnimal makeStuffedAnimalWithoutIf(Input input) {
        AnimalType type = determineType(input);
        IStuffedAnimalMaker maker = getMaker(type, input);

        IStuffedAnimal result = maker.makeAndStuffBody();
        maker.makeAndAttachArmsToAnimal(result);
        maker.makeAndAttachLegsToAnimal(result);
        maker.makeAndAttachEarsToAnimal(result);

        return result;
    }
}