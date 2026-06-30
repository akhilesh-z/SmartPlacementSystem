package com.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    static {

        cloudinary = new Cloudinary(ObjectUtils.asMap(

                "cloud_name", System.getenv("CLOUDINARY_CLOUD_NAME"),
                "api_key", System.getenv("CLOUDINARY_API_KEY"),
                "api_secret", System.getenv("CLOUDINARY_API_SECRET")

        ));

    }

    public static Cloudinary getInstance() {

        return cloudinary;

    }

}