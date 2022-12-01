package com.exam.ehrlichpizzaexam.helpers;

import org.springframework.web.multipart.MultipartFile;

public class BaseCSVHelper {
    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
}
