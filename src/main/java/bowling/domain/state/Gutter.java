package bowling.domain.state;

import static bowling.Constants.MAX_FELLED_PIN_COUNT;
import static bowling.Constants.MIN_FELLED_PIN_COUNT;

public class Gutter implements State {

    @Override
    public State play(int newFelledPin) {

        if(newFelledPin == MAX_FELLED_PIN_COUNT) {
            return new Spare(MIN_FELLED_PIN_COUNT, newFelledPin);
        }

        return new Miss(MIN_FELLED_PIN_COUNT, newFelledPin);
    }
}
