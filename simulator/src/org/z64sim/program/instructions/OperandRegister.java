/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.z64sim.program.instructions;

import org.z64sim.simulator.Register;

public class OperandRegister extends Operand {

    private final int register;

    public OperandRegister(int register, int size) {
        super(size);
        this.register = register;
    }

    public int getRegister() {
        return register;
    }

    @Override
    public String toString() {
        return Register.getRegisterName(this.register, this.size);
    }
}
