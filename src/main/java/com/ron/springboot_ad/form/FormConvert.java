package com.ron.springboot_ad.form;

public interface FormConvert<S,T> {
    T convert(S s);
}
