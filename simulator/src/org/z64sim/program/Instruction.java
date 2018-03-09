/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.z64sim.program;


import java.nio.ByteBuffer;
import javax.swing.JOptionPane;
import org.z64sim.memory.Memory;
import org.z64sim.program.instructions.InstructionClass0;
import org.z64sim.program.instructions.InstructionClass1;
import org.z64sim.program.instructions.InstructionClass2;
import org.z64sim.program.instructions.InstructionClass3;
import org.z64sim.program.instructions.InstructionClass4;
import org.z64sim.program.instructions.InstructionClass5;
import org.z64sim.program.instructions.InstructionClass6;
import org.z64sim.program.instructions.InstructionClass7;

/**
 *
 * @author Alessandro Pellegrini <pellegrini@dis.uniroma1.it>
 */
public abstract class Instruction {

    protected String mnemonic;
    protected byte clas;
    protected byte type;
    protected byte ss;
    protected byte ds;
    protected byte di;
    protected byte mem;
    protected byte bp;
    protected byte ip;
    protected byte scale;
    protected byte indexRegister;
    protected byte baseRegister;
    protected byte destRegister;
    protected byte[] shortDisplacement;
    protected byte[] immediate;
    protected byte opcode;
    protected byte mode;
    protected byte sib;
    protected byte rm;
    protected int size;
    protected byte[] encoding;
    

    public Instruction(String mnemonic, int clas) {
        this.mnemonic = mnemonic;
        this.clas = (byte)clas;   
    }
    
    public static byte getClas(byte[] encoding) {
        return (byte)((encoding[0] & 0b11110000) >> 4);
    }
    public static byte getType(byte[] encoding){
        return byteToBits(encoding[0],3,0);
    }
    public static byte getOpcode(byte[] encoding ){
        return (byte)(getClas(encoding)| getType(encoding));
    }
    public static byte getSs(byte[] encoding){
        return byteToBits(encoding[1], 7,6);
    }
    public static byte getDs(byte[] encoding) {
        return byteToBits(encoding[1], 5,4);
    }
    public static  byte getDi(byte[] encoding) {
        return byteToBits(encoding[1], 3,2);
    }
    public static  byte getMem(byte[] encoding){
        return byteToBits(encoding[1], 1,0);
    }
    public static byte getMode(byte[] encoding){
        return (byte)(getSs(encoding) | getDs(encoding) | getDi(encoding) | getMem(encoding));
    }
    public static byte getBp(byte[] encoding){
        return byteToBits(encoding[2],7,7);
    }
    public static byte getIp(byte[] encoding){
        return byteToBits(encoding[2],6,6);
    }
    public static byte getScale(byte[] encoding){
        return byteToBits(encoding[2],5,4);
    }
    public static byte getIndexRegister(byte[] encoding){
        return byteToBits(encoding[2],3,0);
    }
    public static byte getSib(byte[] encoding){
        return (byte)(getBp(encoding) | getIp(encoding) | getScale(encoding) | getIndexRegister(encoding));
    }
    public static byte getBase(byte[] encoding){
        return byteToBits(encoding[3],7,4);
    }
    public static byte getDest(byte[] encoding){
        return byteToBits(encoding[3],3,0);
    }
    public static byte getRM(byte[] encoding){
        return (byte)(getBase(encoding) | getDest(encoding));
    }
    public static byte[] getShortDisplacement(byte[] encoding){
        byte[] newshort= new byte[4];
        for (int i = 4; i <8 ; i++) {
            newshort[i] = encoding[i];
        }
        return newshort;
    }
    public static byte[] getImmediate(byte[] encoding){
        byte[] newImm= new byte[8];
        for (int i = 8; i <16 ; i++) {
            newImm[i] = encoding[i];
        }
        return newImm;
    }
    
    public static int lengthDisassemble(long address) {
       
        byte[] b = new byte[8];
        for(int i = 0; i < 8; i++) {
            b[i] = Memory.getProgram().program[(int)address + i];
        }
        byte opClass = byteToBits(b[0],7,4);
        
        if(opClass != 1 || opClass != 2) return 8;
        else{
            byte d = byteToBits(b[1],3,3);
            byte i = byteToBits(b[1],2,2);
            byte ss = byteToBits(b[1],7,6);
            
            if((d == 1 && i == 1) || (i == 1 && d == 0 && ss == 64)) return 16;
        }
        // Ti dice quanti byte è lunga l'istruzione puntata da address
        
        // Recuperi l'opcode
        
        // Se class != 1 e 2: return 8;
        
        // Altrimenti leggi DI e SS
        
        // Se D = 1 e I = 1: return 16;
        
        // Se I = 1, D = 0, SS = 64: return 16;
        return 8;
    }
    public void disassemble(int address){
        byte[] b;
        boolean isLong=false; //variabile per verificare la lunghezza istruzione
        if(lengthDisassemble(address) == 16){
            b = new byte[16];
            isLong= true;
            for(int i = 0; i < 16; i++) {
                b[i] = Memory.getProgram().program[address + i];
            }
        }else{
            b = new byte[8];
            for (int i = 0; i < 8; i++) {
                b[i] = Memory.getProgram().program[address+i];
            }   
        }
        
        this.clas = getClas(b);
        this.type = getType(b);
        
        this.ss = getSs(b);
        this.ds = getDs(b);
        this.di = getDi(b);
        this.mem = getMem(b);
        
        this.bp = getBp(b);
        this.ip = getIp(b);
        this.scale = getScale(b);
        this.indexRegister = getIndexRegister(b);
        
        this.baseRegister = getBase(b);
        this.destRegister = getDest(b);
        
        if(isLong){
            if(di == 3){
                this.shortDisplacement = getShortDisplacement(b);
                this.immediate = getImmediate(b);
                
            }else{
                this.immediate = getImmediate(b);
            }
        }
        else{ 
            this.shortDisplacement = getShortDisplacement(b);
        }
        
    }
    // toString() must be explicitly re-implemented
    public static String stringRepresentation(int address) {
        byte opcode = 0;
        opcode = (byte)(Memory.getProgram().program[address] & 0b11110000);
        
        switch(opcode){
            case 0:
                return InstructionClass0.stringRepresentation(address);
            case 1*16:
                return InstructionClass1.stringRepresentation(address);
            case 2*16:
                return InstructionClass2.stringRepresentation(address);
            case 3*16:
                return InstructionClass3.stringRepresentation(address);
            case 4*16:
                return InstructionClass4.stringRepresentation(address);
            case 5*16:
                return InstructionClass5.stringRepresentation(address);
            case 6*16:
                return InstructionClass6.stringRepresentation(address);
            case 7*16:
                return InstructionClass7.stringRepresentation(address);
            default :
                return JOptionPane.showInputDialog(opcode);
        }
    }
    
    public static boolean check(int address){
        long dxAddress=Memory.getProgram()._start;
        long sxAddress=address;
        
        while(sxAddress > dxAddress){
            //if(sxAddress == Program.STACK_SIZE) return false;
            dxAddress += lengthDisassemble(dxAddress);
        }
        if(sxAddress == dxAddress) return true;

        return false; 
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return this.size;
    }

    public byte[] getEncoding() {
        return encoding;
    }

    public void setEncoding(byte[] encoding) {
        this.encoding = encoding;
    }

    public abstract void run();
    
    public static byte[] longToBytes(long l) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte)(l & 0xFF);
            l >>= 8;
        }
        return result;
    }
    
    public static long bytesToLong(byte[] b) {
        ByteBuffer bb = ByteBuffer.allocate(b.length);
        bb.put(b);
        return bb.getLong();
    }
    
    public static byte byteToBits(byte b, int start, int end){
       byte mask = 0;
        if(start < end || start > 7 || end < 0 ) throw new RuntimeException("No valid start || end");
        
        for (int i = 7-start; i <= 7-end; i++) {
            mask += 1 << 7-i;
        }
        byte ret = (byte) (mask & b);
        for (int i = 0; i < end; i++) {
            ret /= 2;
        }
        if (ret < 0) {
            ret += Math.pow(2, start-end+1);
        }
        return ret;
    }
    
    

}
