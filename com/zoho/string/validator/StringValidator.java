package com.utils;

import com.stringexception.StringException;

public class StringValidator{
	public static void checkNullOrEmpty(String inputString) throws StringException {
        if (inputString == null || inputString.isEmpty()) {
            throw new StringException("Input string cannot be null or empty");
        }
    }
}