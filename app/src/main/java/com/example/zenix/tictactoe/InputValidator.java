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
        return getEditTextString(editText).isEmpty();
    }

    public static boolean isEditTextContentEqual(EditText editText1, EditText editText2) {
        if (editText1 == null || editText2 == null) {
            return false;
        }
        String string1 = getEditTextString(editText1);
        String string2 = getEditTextString(editText2);

        return string1.equals(string2);
    }

    public static String getEditTextString(EditText editText) {
        return editText.getText().toString();
    }
}
