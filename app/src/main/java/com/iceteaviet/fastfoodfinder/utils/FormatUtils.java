package com.iceteaviet.fastfoodfinder.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.SpannableStringBuilder;

import java.text.DecimalFormat;

/**
 * Created by tom on 7/10/18.
 */
public final class FormatUtils {
    private static final DecimalFormat distanceFormat = new DecimalFormat("##.## Km");
    private static final DecimalFormat oneDecimalFormat = new DecimalFormat("#.#");
    private static final DecimalFormat twoDecimalFormat = new DecimalFormat("#.##");
    private static final DecimalFormat threeDecimalFormat = new DecimalFormat("#.###");
    private static final DecimalFormat fourDecimalFormat = new DecimalFormat("#.####");

    private FormatUtils() {

    }

    public static CharSequence trimWhitespace(CharSequence source) {
        if (source == null)
            return "";

        SpannableStringBuilder builder = new SpannableStringBuilder(source);
        char c;

        for (int i = 0; i < source.length(); i++) {
            c = source.charAt(i);
            if (Character.isWhitespace(c)) {
                try {
                    if (i < (source.length() - 1) && Character.isWhitespace(source.charAt(i + 1)))
                        //Ignore next char
                        //Because it is a whitespace again
                        builder.delete(i, i + 1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        if (Character.isWhitespace(builder.charAt(builder.length() - 1)))
            builder.delete(builder.length() - 1, builder.length());

        return builder.subSequence(0, builder.length());
    }

    public static CharSequence getTrimmedShortInstruction(CharSequence source) {

        if (source == null)
            return "";

        int i = 0;
        int newLen = 0;

        // loop back to the first non-whitespace character
        for (i = 0; i < source.length() - 1; i++) {
            if (Character.isWhitespace(source.charAt(i)) && Character.isWhitespace(source.charAt(i + 1))) {
                newLen = i;
                break;
            }
        }

        if (newLen <= 1)
            newLen = source.length();

        return source.subSequence(0, newLen);
    }

    public static Intent getCallIntent(String tel) {
        String normalizedTel = tel.replaceAll("\\s", "");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:08" + normalizedTel));
        return callIntent;
    }


    public static String formatDistance(double distance) {
        return distanceFormat.format(distance);
    }


    public static String formatDecimal(double decimal, int numbOfDecimalPlates) {
        switch (numbOfDecimalPlates) {
            case 1:
                return oneDecimalFormat.format(decimal);

            case 2:
                return twoDecimalFormat.format(decimal);

            case 3:
                return threeDecimalFormat.format(decimal);

            case 4:
                return fourDecimalFormat.format(decimal);

            default:
                return String.valueOf(decimal);
        }
    }
}