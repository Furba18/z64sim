/* Generated By:JavaCC: Do not edit this line. AssemblerConstants.java */
package org.z64sim.assembler;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface AssemblerConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int WHITESPACE = 1;
  /** RegularExpression Id. */
  int NEWLINE = 2;
  /** RegularExpression Id. */
  int COMMENT = 3;
  /** RegularExpression Id. */
  int LOCATION_COUNTER = 4;
  /** RegularExpression Id. */
  int ORG = 5;
  /** RegularExpression Id. */
  int DATA_SECTION = 6;
  /** RegularExpression Id. */
  int CODE_SECTION = 7;
  /** RegularExpression Id. */
  int BSS_SECTION = 8;
  /** RegularExpression Id. */
  int PROGRAM_END = 9;
  /** RegularExpression Id. */
  int EQU_ASSIGN = 10;
  /** RegularExpression Id. */
  int BYTE_ASSIGN = 11;
  /** RegularExpression Id. */
  int WORD_ASSIGN = 12;
  /** RegularExpression Id. */
  int LONG_ASSIGN = 13;
  /** RegularExpression Id. */
  int QUAD_ASSIGN = 14;
  /** RegularExpression Id. */
  int ASCII_ASSIGN = 15;
  /** RegularExpression Id. */
  int FILL_ASSIGN = 16;
  /** RegularExpression Id. */
  int COMM_ASSIGN = 17;
  /** RegularExpression Id. */
  int DRIVER = 18;
  /** RegularExpression Id. */
  int CONSTANT = 19;
  /** RegularExpression Id. */
  int INTEGER = 20;
  /** RegularExpression Id. */
  int DEC = 21;
  /** RegularExpression Id. */
  int HEX = 22;
  /** RegularExpression Id. */
  int BIN = 23;
  /** RegularExpression Id. */
  int FLONUM = 24;
  /** RegularExpression Id. */
  int ASSIGN = 25;
  /** RegularExpression Id. */
  int PLUS = 26;
  /** RegularExpression Id. */
  int MINUS = 27;
  /** RegularExpression Id. */
  int TIMES = 28;
  /** RegularExpression Id. */
  int DIVIDE = 29;
  /** RegularExpression Id. */
  int LBRACE = 30;
  /** RegularExpression Id. */
  int RBRACE = 31;
  /** RegularExpression Id. */
  int COMMA = 32;
  /** RegularExpression Id. */
  int REG_8 = 33;
  /** RegularExpression Id. */
  int REG_16 = 34;
  /** RegularExpression Id. */
  int REG_32 = 35;
  /** RegularExpression Id. */
  int REG_64 = 36;
  /** RegularExpression Id. */
  int INSN_0 = 37;
  /** RegularExpression Id. */
  int INSN_0_WQ = 38;
  /** RegularExpression Id. */
  int INSN_0_NOSUFF = 39;
  /** RegularExpression Id. */
  int INSN_1_S = 40;
  /** RegularExpression Id. */
  int INSN_LEA = 41;
  /** RegularExpression Id. */
  int INSN_1_E = 42;
  /** RegularExpression Id. */
  int INSN_SHIFT = 43;
  /** RegularExpression Id. */
  int INSN_1_M = 44;
  /** RegularExpression Id. */
  int INSN_JC = 45;
  /** RegularExpression Id. */
  int INSN_B_E = 46;
  /** RegularExpression Id. */
  int INSN_EXT = 47;
  /** RegularExpression Id. */
  int INSN_IN = 48;
  /** RegularExpression Id. */
  int INSN_OUT = 49;
  /** RegularExpression Id. */
  int INSN_IO_S = 50;
  /** RegularExpression Id. */
  int IRET = 51;
  /** RegularExpression Id. */
  int LABEL = 52;
  /** RegularExpression Id. */
  int LABEL_NAME = 53;
  /** RegularExpression Id. */
  int STRING_LITERAL = 54;
  /** RegularExpression Id. */
  int ERROR = 55;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<WHITESPACE>",
    "<NEWLINE>",
    "<COMMENT>",
    "\".\"",
    "\".org\"",
    "\".data\"",
    "\".text\"",
    "\".bss\"",
    "\".end\"",
    "\".equ\"",
    "\".byte\"",
    "\".word\"",
    "\".long\"",
    "\".quad\"",
    "\".ascii\"",
    "\".fill\"",
    "\".comm\"",
    "<DRIVER>",
    "\"$\"",
    "<INTEGER>",
    "<DEC>",
    "<HEX>",
    "<BIN>",
    "<FLONUM>",
    "\"=\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"(\"",
    "\")\"",
    "\",\"",
    "<REG_8>",
    "<REG_16>",
    "<REG_32>",
    "<REG_64>",
    "<INSN_0>",
    "<INSN_0_WQ>",
    "<INSN_0_NOSUFF>",
    "\"int\"",
    "<INSN_LEA>",
    "<INSN_1_E>",
    "<INSN_SHIFT>",
    "<INSN_1_M>",
    "<INSN_JC>",
    "<INSN_B_E>",
    "<INSN_EXT>",
    "<INSN_IN>",
    "<INSN_OUT>",
    "<INSN_IO_S>",
    "\"iret\"",
    "<LABEL>",
    "<LABEL_NAME>",
    "<STRING_LITERAL>",
    "<ERROR>",
  };

}
