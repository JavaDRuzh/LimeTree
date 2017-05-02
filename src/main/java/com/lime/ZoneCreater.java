package com.lime;

import com.lime.interfaces.Cross;
import com.lime.interfaces.Module;
import com.lime.interfaces.Port;
import com.lime.interfaces.Server;
import com.lime.interfaces.Zone;

/**
 * Created by vdruzhinin on 5/2/2017.
 */
public class ZoneCreater {

    private Zone zone;
    private Server server;
    private Cross cross;
    private Module module;
    private Port port;

    public ZoneCreater(Zone zone, Server server, Cross cross, Module module, Port port){
        super();
        this.zone = zone;
        this.server = server;
        this.cross = cross;
        this.module = module;
        this.port = port;
    }

    public  void action(){

    }

}
