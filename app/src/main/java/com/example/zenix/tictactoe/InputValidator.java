package com.example.zenix.tictactoe;

import android.widget.EditText;

/**
 * Helper class for validating all sorts of input
 */

public class InputValidator {
    private InputValidator() {
        // Shouldn't be initialized, since all methods are final.
    }

    public static boolean isEditTextEmpty(EditText editText) {
        return editText.getText().toString().isEmpty();
    }
}
