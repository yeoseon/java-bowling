package bowling;

import bowling.domain.state.Gutter;
import bowling.domain.state.Playing;
import bowling.domain.state.Ready;
import bowling.domain.state.Strike;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {
    @Test
    @DisplayName("Ready에서 play를 수행했을 때의 상태")
    void playFromReady() {
        assertThat(new Ready().play(0)).isInstanceOf(Gutter.class);
        assertThat(new Ready().play(1)).isInstanceOf(Playing.class);
        assertThat(new Ready().play(10)).isInstanceOf(Strike.class);
    }
}
