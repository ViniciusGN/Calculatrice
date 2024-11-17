package com.example.da_calculator.model;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

import java.nio.channels.Channel;

@Root(name= "rss", strict = false)
public class Rss {
    @Element
    private Channel channel;
}
