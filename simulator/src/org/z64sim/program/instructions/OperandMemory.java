/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.z64sim.program.instructions;

import org.z64sim.simulator.Register;

public class OperandMemory extends Operand {

    private int base = -1;
    private int scale = -1;
    private int index = -1;
    private int displacement = -1;

    // In z64 assembly you can say both (%ax) or (%rax) for example, so we must
    // account fot the size of the base and index registers as well
    private int base_size = -1;
    private int index_size = -1;

    public OperandMemory(int base, int base_size, int index, int index_size, int scale, int displacement, int size) {
        super(size);

        this.base = base;
        this.base_size = base_size;
        this.index = index;
        this.index_size = index_size;
        this.scale = scale;
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return displacement;
    }

    public int getScale() {
        return scale;
    }

    public int getIndex() {
        return index;
    }

    public int getIndexSize() {
        return index_size;
    }

    public long getBase() {
        return base;
    }

    public int getBaseSize() {
        return base_size;
    }

    public String toString() {
        String representation = "";

        if(this.displacement != -1) {
            representation = representation.concat(String.format("#08x", this.displacement));
        }

        if(this.base != -1 || this.index != -1) {
            representation = representation.concat("(");
        }

        if(this.base != -1) {
            representation = representation.concat(Register.getRegisterName(this.base, this.base_size));
        }

        if(this.index != -1) {
            representation = representation.concat(", " + Register.getRegisterName(this.index, this.index_size));
            representation = representation.concat(", " + this.scale);
        }

        if(this.base != -1 || this.index != -1) {
            representation = representation.concat(")");
        }

        return representation;
    }

    public void relocate(long value) {
        this.displacement += value;
    }
}
