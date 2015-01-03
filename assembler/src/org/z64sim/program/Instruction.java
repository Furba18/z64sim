/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.z64sim.program;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.z64sim.program.subtasks.MicroOperation;

/**
 *
 * @author Alessandro Pellegrini <pellegrini@dis.uniroma1.it>
 */
public abstract class Instruction extends MemoryElement {
    
    private static final Logger logger = Logger.getLogger(Instruction.class.getName());
    private final ArrayList<MicroOperation> microOps;
    private final String mnemonic;
    
    public Instruction(int address, int size, String mnemonic, ArrayList<MicroOperation> ops) {
        super(address, size);
        this.microOps = ops;
        this.mnemonic = mnemonic;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract void run();
}
