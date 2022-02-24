package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChoiceNumberTest {
    @Test
    @DisplayName("숫자 6개를 뽑았는가")
    void Generate_6_Number() {
        ChoiceNumber choiceNumber = new ChoiceNumber();
        assertThat(choiceNumber.getChoiceNumbers().stream().count()).isEqualTo(6);
    }

    @Test
    @DisplayName("모든 숫자가 1~45 사이에 위치하는가")
    void Is_Between_1_To_45() {
        ChoiceNumber choiceNumber = new ChoiceNumber();
        assertThat(choiceNumber.getChoiceNumbers().stream().allMatch(i -> i >= 1 && i <= 45)).isTrue();
    }

    @Test
    @DisplayName("입력받은 당첨번호가 숫자가 아니면 예외처리")
    void Is_Number_Format() {
        assertThatThrownBy(() -> {
            ChoiceNumber choiceNumber = new ChoiceNumber("1,2,3,a,b,c");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 당첨번호가 6개인지 검증")
    void Get_6_Input() {
        ChoiceNumber choiceNumber = new ChoiceNumber("1,2,3,4,5,6");
        assertThat(choiceNumber.getChoiceNumbers().stream().count()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력받은 당첨번호가 모두 범위내에 있는지")
    void All_Numbers_In_Range() {
        assertThatThrownBy(() -> {
            new ChoiceNumber("0,2,3,4,5,6");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 당첨번호가 중복되는 값이 있는지")
    void Duplicate_Number_Exist() {
        assertThatThrownBy(() -> {
            new ChoiceNumber("1,1,3,4,5,6");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}