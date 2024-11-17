package com.example.da_calculator.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "channel", strict = false)
public class Channel {
        @ElementList(entry = "item", inline = true)
    public List<Item> items;
}

