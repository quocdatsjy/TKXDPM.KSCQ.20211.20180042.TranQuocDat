package controller.PlaceOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatePhoneNumberTest {
    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "0123456789, true",
            "01234, false",
            "012345678a, false",
            "1234567890, false",
    })
    public void test(String phone, boolean expected) {
        boolean isValid = placeOrderController.validatePhoneNumber(phone);
        assertEquals(expected, isValid);
    }
}
