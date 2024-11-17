package com.example.da_calculator.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "content", strict = false)
public class Content {
    @Attribute(name = "url")
    public String url;

    @Attribute(name = "medium")
    public String medium;
}
