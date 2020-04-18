package bowling.domain.state;

import static bowling.Constants.*;

public class Spare extends Finished {
    private static final String TEXT = "/";

    private int lastPlayPoint;
    private int currentPlayPoint;

    public Spare(int felledPin, int newFelledPin) {
        this.lastPlayPoint = felledPin;
        this.currentPlayPoint = newFelledPin;
    }

    @Override
    public State play(int newFelledPin) {
        assertFirstFelledPin(newFelledPin);

        if (newFelledPin == MAX_FELLED_PIN_COUNT) {
            return new Strike();
        }
        if (newFelledPin == ZERO) {
            return new Gutter();
        }

        return new End(newFelledPin);
    }

    @Override
    public String getString() {
        return TEXT;
    }

    private void assertFirstFelledPin(int felledPin) {
        if (felledPin > MAX_FELLED_PIN_COUNT || felledPin < MIN_FELLED_PIN_COUNT) {
            throw new IllegalArgumentException(WRONG_FELLED_PIN);
        }
    }
}
