package com.example.zenix.tictactoe;

import android.widget.EditText;

/**
 * Helper class for validating all sorts of input
 */

public class InputValidator {
    private InputValidator() {
        // Shouldn't be initialized, since all methods are static.
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


    /**
     * Checks to see if any of objects input are null, if they are, return false.
     *
     * @param objects objects to check for null
     * @return are any of parameters null?
     */
    public static boolean isNotNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return false;
            }
        }
        return true;
    }
}
