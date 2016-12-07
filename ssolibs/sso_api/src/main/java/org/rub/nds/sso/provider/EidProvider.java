/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rub.nds.sso.provider;

/**
 *
 * @author Ole Lemke <ole.lemke@rub.de>
 */
public interface EidProvider {

    public void verify() throws Exception;

}
