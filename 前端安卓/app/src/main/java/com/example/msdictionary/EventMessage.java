package com.example.msdictionary;

import org.greenrobot.eventbus.EventBus;

public class EventMessage {

    private boolean if_sign;

    public EventMessage(){
        if_sign = false;
    }

    public void setIf_sign(boolean if_sign) {
        this.if_sign = if_sign;
    }

    public boolean getif_sign(){
        return this.if_sign;
    }
}
