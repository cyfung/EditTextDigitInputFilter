package com.aucy.edittextdigitinputfilter;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalDigitsInputFilter implements InputFilter {

      private final Pattern mPattern = Pattern.compile("((10)|([0-9]?(\\.[0-9]?)?))");
      @Override
      public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart,
                                 int dend) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dest, 0, dstart);
        stringBuilder.append(source, start, end);
        stringBuilder.append(dest, dend, dest.length());
        Matcher matcher = mPattern.matcher(stringBuilder);
        if (!matcher.matches()) {
          return dest.subSequence(dstart, dend);
        }
        return null;
      }
  }