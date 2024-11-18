package com.example.da_calculator.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class Rss {
    @Element(name = "channel")
    public Channel channel;

    public Channel getChannel() {
        return channel;
    }
}
