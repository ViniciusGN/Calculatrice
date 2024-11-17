package com.example.da_calculator.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)

public class Item {
    @Element(required = false)
    public String title;

    @Element(required = false)
    public String link;

    @Element(required = false)
    public String pubDate;

    @Element(required = false)
    public String creator;

    @Element(required = false)
    public Content content;


}
