/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Petar
 */
public class NoFuelException extends Exception {

    public NoFuelException(String message, Throwable t) {
        super(message, t);
    }

}
