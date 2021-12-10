package controller.PlaceOrder;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateNameTest {
    private PlaceOrderController placeOrderController;
    @BeforeEach
    void setUp() {
        placeOrderController = new PlaceOrderController();
    }
    @ParameterizedTest
    @CsvSource({
            "Dat, true",
            "Tran Quoc Dat, true",
            ",false",
            "Tran 2uoc Dat, false",
            "Dat@ dep trai, false",
            "Dat178, false",
            "D@, false",
            "Dang1 .-/l;, false"
    })
    void validateName(String name, boolean expected){
        //when
        boolean isValid = placeOrderController.validateName(name);
        //then
        assertEquals(expected, isValid);
    }
}
