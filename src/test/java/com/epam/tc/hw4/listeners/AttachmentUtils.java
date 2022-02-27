package com.epam.tc.hw4.listeners;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    @Attachment(type = "image/png", value = "Try to use name {attachmentName}")
    public static byte[] attachPngImage(String attachmentName, byte[] source) {
        return source;
    }
}
