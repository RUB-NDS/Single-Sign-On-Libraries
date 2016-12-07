/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.provider;

/**
 *
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 */
public abstract class EidProvider {

    private final String name;

    private final String info;

    private final double version;

    private final String type;

    public EidProvider(String name, String info, double version, String type) {
        this.name = name;
        this.info = info;
        this.version = version;
        this.type = type;
    }

    public abstract boolean verify(Object type);

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public double getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }
}
