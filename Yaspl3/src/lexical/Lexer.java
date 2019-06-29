/* The following code was generated by JFlex 1.4.3 on 13/02/19 9.58 */

package lexical;
import java_cup.runtime.Symbol;
import java.lang.Integer;
import parser.*;
import java.util.HashMap;
import java.io.*;
import astNodes.Identifier;
import exception.MultipleDeclaretionException;
 





/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 13/02/19 9.58 from the specification file
 * <tt>D:/Desktop/Workspace/workspaceJAVA/AntonioCorsuto- eser4-5/Circuit.lex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\12\2\1\2\0\1\4\16\12\4\0\1\1\1\0\1\13\1\0"+
    "\1\11\2\0\1\14\1\41\1\42\1\3\1\50\1\40\1\46\1\7"+
    "\1\2\1\6\11\5\1\0\1\37\1\45\1\51\1\47\2\0\4\11"+
    "\1\10\25\11\1\0\1\15\2\0\1\11\1\0\1\25\1\22\1\35"+
    "\1\26\1\24\1\21\1\34\1\23\1\30\2\11\1\32\1\11\1\16"+
    "\1\31\2\11\1\17\1\27\1\20\1\33\1\11\1\36\3\11\1\43"+
    "\1\0\1\44\1\0\41\12\2\0\4\11\4\0\1\11\2\0\1\12"+
    "\7\0\1\11\4\0\1\11\5\0\27\11\1\0\37\11\1\0\u01ca\11"+
    "\4\0\14\11\16\0\5\11\7\0\1\11\1\0\1\11\21\0\160\12"+
    "\5\11\1\0\2\11\2\0\4\11\10\0\1\11\1\0\3\11\1\0"+
    "\1\11\1\0\24\11\1\0\123\11\1\0\213\11\1\0\5\12\2\0"+
    "\236\11\11\0\46\11\2\0\1\11\7\0\47\11\7\0\1\11\1\0"+
    "\55\12\1\0\1\12\1\0\2\12\1\0\2\12\1\0\1\12\10\0"+
    "\33\11\5\0\3\11\15\0\5\12\6\0\1\11\4\0\13\12\5\0"+
    "\53\11\37\12\4\0\2\11\1\12\143\11\1\0\1\11\10\12\1\0"+
    "\6\12\2\11\2\12\1\0\4\12\2\11\12\12\3\11\2\0\1\11"+
    "\17\0\1\12\1\11\1\12\36\11\33\12\2\0\131\11\13\12\1\11"+
    "\16\0\12\12\41\11\11\12\2\11\4\0\1\11\5\0\26\11\4\12"+
    "\1\11\11\12\1\11\3\12\1\11\5\12\22\0\31\11\3\12\104\0"+
    "\1\11\1\0\13\11\67\0\33\12\1\0\4\12\66\11\3\12\1\11"+
    "\22\12\1\11\7\12\12\11\2\12\2\0\12\12\1\0\7\11\1\0"+
    "\7\11\1\0\3\12\1\0\10\11\2\0\2\11\2\0\26\11\1\0"+
    "\7\11\1\0\1\11\3\0\4\11\2\0\1\12\1\11\7\12\2\0"+
    "\2\12\2\0\3\12\1\11\10\0\1\12\4\0\2\11\1\0\3\11"+
    "\2\12\2\0\12\12\4\11\7\0\1\11\5\0\3\12\1\0\6\11"+
    "\4\0\2\11\2\0\26\11\1\0\7\11\1\0\2\11\1\0\2\11"+
    "\1\0\2\11\2\0\1\12\1\0\5\12\4\0\2\12\2\0\3\12"+
    "\3\0\1\12\7\0\4\11\1\0\1\11\7\0\14\12\3\11\1\12"+
    "\13\0\3\12\1\0\11\11\1\0\3\11\1\0\26\11\1\0\7\11"+
    "\1\0\2\11\1\0\5\11\2\0\1\12\1\11\10\12\1\0\3\12"+
    "\1\0\3\12\2\0\1\11\17\0\2\11\2\12\2\0\12\12\1\0"+
    "\1\11\17\0\3\12\1\0\10\11\2\0\2\11\2\0\26\11\1\0"+
    "\7\11\1\0\2\11\1\0\5\11\2\0\1\12\1\11\7\12\2\0"+
    "\2\12\2\0\3\12\10\0\2\12\4\0\2\11\1\0\3\11\2\12"+
    "\2\0\12\12\1\0\1\11\20\0\1\12\1\11\1\0\6\11\3\0"+
    "\3\11\1\0\4\11\3\0\2\11\1\0\1\11\1\0\2\11\3\0"+
    "\2\11\3\0\3\11\3\0\14\11\4\0\5\12\3\0\3\12\1\0"+
    "\4\12\2\0\1\11\6\0\1\12\16\0\12\12\11\0\1\11\7\0"+
    "\3\12\1\0\10\11\1\0\3\11\1\0\27\11\1\0\12\11\1\0"+
    "\5\11\3\0\1\11\7\12\1\0\3\12\1\0\4\12\7\0\2\12"+
    "\1\0\2\11\6\0\2\11\2\12\2\0\12\12\22\0\2\12\1\0"+
    "\10\11\1\0\3\11\1\0\27\11\1\0\12\11\1\0\5\11\2\0"+
    "\1\12\1\11\7\12\1\0\3\12\1\0\4\12\7\0\2\12\7\0"+
    "\1\11\1\0\2\11\2\12\2\0\12\12\1\0\2\11\17\0\2\12"+
    "\1\0\10\11\1\0\3\11\1\0\51\11\2\0\1\11\7\12\1\0"+
    "\3\12\1\0\4\12\1\11\10\0\1\12\10\0\2\11\2\12\2\0"+
    "\12\12\12\0\6\11\2\0\2\12\1\0\22\11\3\0\30\11\1\0"+
    "\11\11\1\0\1\11\2\0\7\11\3\0\1\12\4\0\6\12\1\0"+
    "\1\12\1\0\10\12\22\0\2\12\15\0\60\11\1\12\2\11\7\12"+
    "\4\0\10\11\10\12\1\0\12\12\47\0\2\11\1\0\1\11\2\0"+
    "\2\11\1\0\1\11\2\0\1\11\6\0\4\11\1\0\7\11\1\0"+
    "\3\11\1\0\1\11\1\0\1\11\2\0\2\11\1\0\4\11\1\12"+
    "\2\11\6\12\1\0\2\12\1\11\2\0\5\11\1\0\1\11\1\0"+
    "\6\12\2\0\12\12\2\0\4\11\40\0\1\11\27\0\2\12\6\0"+
    "\12\12\13\0\1\12\1\0\1\12\1\0\1\12\4\0\2\12\10\11"+
    "\1\0\44\11\4\0\24\12\1\0\2\12\5\11\13\12\1\0\44\12"+
    "\11\0\1\12\71\0\53\11\24\12\1\11\12\12\6\0\6\11\4\12"+
    "\4\11\3\12\1\11\3\12\2\11\7\12\3\11\4\12\15\11\14\12"+
    "\1\11\17\12\2\0\46\11\1\0\1\11\5\0\1\11\2\0\53\11"+
    "\1\0\u014d\11\1\0\4\11\2\0\7\11\1\0\1\11\1\0\4\11"+
    "\2\0\51\11\1\0\4\11\2\0\41\11\1\0\4\11\2\0\7\11"+
    "\1\0\1\11\1\0\4\11\2\0\17\11\1\0\71\11\1\0\4\11"+
    "\2\0\103\11\2\0\3\12\40\0\20\11\20\0\125\11\14\0\u026c\11"+
    "\2\0\21\11\1\0\32\11\5\0\113\11\3\0\3\11\17\0\15\11"+
    "\1\0\4\11\3\12\13\0\22\11\3\12\13\0\22\11\2\12\14\0"+
    "\15\11\1\0\3\11\1\0\2\12\14\0\64\11\40\12\3\0\1\11"+
    "\3\0\2\11\1\12\2\0\12\12\41\0\3\12\2\0\12\12\6\0"+
    "\130\11\10\0\51\11\1\12\1\11\5\0\106\11\12\0\35\11\3\0"+
    "\14\12\4\0\14\12\12\0\12\12\36\11\2\0\5\11\13\0\54\11"+
    "\4\0\21\12\7\11\2\12\6\0\12\12\46\0\27\11\5\12\4\0"+
    "\65\11\12\12\1\0\35\12\2\0\13\12\6\0\12\12\15\0\1\11"+
    "\130\0\5\12\57\11\21\12\7\11\4\0\12\12\21\0\11\12\14\0"+
    "\3\12\36\11\15\12\2\11\12\12\54\11\16\12\14\0\44\11\24\12"+
    "\10\0\12\12\3\0\3\11\12\12\44\11\122\0\3\12\1\0\25\12"+
    "\4\11\1\12\4\11\3\12\2\11\11\0\300\11\47\12\25\0\4\12"+
    "\u0116\11\2\0\6\11\2\0\46\11\2\0\6\11\2\0\10\11\1\0"+
    "\1\11\1\0\1\11\1\0\1\11\1\0\37\11\2\0\65\11\1\0"+
    "\7\11\1\0\1\11\3\0\3\11\1\0\7\11\3\0\4\11\2\0"+
    "\6\11\4\0\15\11\5\0\3\11\1\0\7\11\16\0\5\12\32\0"+
    "\5\12\20\0\2\11\23\0\1\11\13\0\5\12\5\0\6\12\1\0"+
    "\1\11\15\0\1\11\20\0\15\11\3\0\33\11\25\0\15\12\4\0"+
    "\1\12\3\0\14\12\21\0\1\11\4\0\1\11\2\0\12\11\1\0"+
    "\1\11\3\0\5\11\6\0\1\11\1\0\1\11\1\0\1\11\1\0"+
    "\4\11\1\0\13\11\2\0\4\11\5\0\5\11\4\0\1\11\21\0"+
    "\51\11\u0a77\0\57\11\1\0\57\11\1\0\205\11\6\0\4\11\3\12"+
    "\2\11\14\0\46\11\1\0\1\11\5\0\1\11\2\0\70\11\7\0"+
    "\1\11\17\0\1\12\27\11\11\0\7\11\1\0\7\11\1\0\7\11"+
    "\1\0\7\11\1\0\7\11\1\0\7\11\1\0\7\11\1\0\7\11"+
    "\1\0\40\12\57\0\1\11\u01d5\0\3\11\31\0\11\11\6\12\1\0"+
    "\5\11\2\0\5\11\4\0\126\11\2\0\2\12\2\0\3\11\1\0"+
    "\132\11\1\0\4\11\5\0\51\11\3\0\136\11\21\0\33\11\65\0"+
    "\20\11\u0200\0\u19b6\11\112\0\u51cd\11\63\0\u048d\11\103\0\56\11\2\0"+
    "\u010d\11\3\0\20\11\12\12\2\11\24\0\57\11\1\12\4\0\12\12"+
    "\1\0\31\11\7\0\1\12\120\11\2\12\45\0\11\11\2\0\147\11"+
    "\2\0\4\11\1\0\4\11\14\0\13\11\115\0\12\11\1\12\3\11"+
    "\1\12\4\11\1\12\27\11\5\12\20\0\1\11\7\0\64\11\14\0"+
    "\2\12\62\11\21\12\13\0\12\12\6\0\22\12\6\11\3\0\1\11"+
    "\4\0\12\12\34\11\10\12\2\0\27\11\15\12\14\0\35\11\3\0"+
    "\4\12\57\11\16\12\16\0\1\11\12\12\46\0\51\11\16\12\11\0"+
    "\3\11\1\12\10\11\2\12\2\0\12\12\6\0\27\11\3\0\1\11"+
    "\1\12\4\0\60\11\1\12\1\11\3\12\2\11\2\12\5\11\2\12"+
    "\1\11\1\12\1\11\30\0\3\11\2\0\13\11\5\12\2\0\3\11"+
    "\2\12\12\0\6\11\2\0\6\11\2\0\6\11\11\0\7\11\1\0"+
    "\7\11\221\0\43\11\10\12\1\0\2\12\2\0\12\12\6\0\u2ba4\11"+
    "\14\0\27\11\4\0\61\11\u2104\0\u016e\11\2\0\152\11\46\0\7\11"+
    "\14\0\5\11\5\0\1\11\1\12\12\11\1\0\15\11\1\0\5\11"+
    "\1\0\1\11\1\0\2\11\1\0\2\11\1\0\154\11\41\0\u016b\11"+
    "\22\0\100\11\2\0\66\11\50\0\15\11\3\0\20\12\20\0\7\12"+
    "\14\0\2\11\30\0\3\11\31\0\1\11\6\0\5\11\1\0\207\11"+
    "\2\0\1\12\4\0\1\11\13\0\12\12\7\0\32\11\4\0\1\11"+
    "\1\0\32\11\13\0\131\11\3\0\6\11\2\0\6\11\2\0\6\11"+
    "\2\0\3\11\3\0\2\11\3\0\2\11\22\0\3\12\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\2\5\1\6\2\1"+
    "\15\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\5\0\1\22\2\0\11\6"+
    "\1\23\1\6\1\24\1\25\1\26\3\6\1\27\1\30"+
    "\1\31\1\32\1\33\2\0\3\34\1\35\1\36\6\6"+
    "\1\37\1\40\3\6\1\41\1\6\1\42\2\6\3\0"+
    "\1\43\1\44\1\6\1\45\1\46\1\47\4\6\1\50"+
    "\1\6\1\34\1\51\2\6\1\52\1\53\1\54\1\0"+
    "\1\55\1\56";

  private static int [] zzUnpackAction() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\52\0\52\0\124\0\52\0\176\0\250\0\322"+
    "\0\374\0\u0126\0\u0150\0\u017a\0\u01a4\0\u01ce\0\u01f8\0\u0222"+
    "\0\u024c\0\u0276\0\u02a0\0\u02ca\0\u02f4\0\u031e\0\u0348\0\52"+
    "\0\52\0\52\0\52\0\52\0\52\0\u0372\0\u039c\0\u03c6"+
    "\0\52\0\u03f0\0\u041a\0\u0444\0\u046e\0\u0498\0\374\0\52"+
    "\0\u04c2\0\u04ec\0\u0516\0\u0540\0\u056a\0\u0594\0\u05be\0\u05e8"+
    "\0\u0612\0\u063c\0\u0666\0\u0690\0\u06ba\0\u06e4\0\322\0\322"+
    "\0\u070e\0\u0738\0\u0762\0\52\0\52\0\52\0\52\0\52"+
    "\0\u078c\0\u07b6\0\u07e0\0\u080a\0\u0834\0\52\0\322\0\u085e"+
    "\0\u0888\0\u08b2\0\u08dc\0\u0906\0\u0930\0\322\0\322\0\u095a"+
    "\0\u0984\0\u09ae\0\322\0\u09d8\0\322\0\u0a02\0\u0a2c\0\u0a56"+
    "\0\u0a80\0\u0aaa\0\322\0\322\0\u0ad4\0\322\0\322\0\322"+
    "\0\u0afe\0\u0b28\0\u0b52\0\u0b7c\0\322\0\u0ba6\0\u0bd0\0\322"+
    "\0\u0bfa\0\u0c24\0\322\0\322\0\322\0\u0bd0\0\322\0\322";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\3\1\6\1\7\1\2"+
    "\2\10\1\2\1\11\1\12\1\2\1\13\1\10\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\3\10\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\54\0"+
    "\1\43\1\44\53\0\2\6\1\45\1\46\50\0\1\45"+
    "\1\46\46\0\2\10\1\0\3\10\3\0\21\10\13\0"+
    "\13\47\1\50\36\47\14\51\1\0\1\52\34\51\5\0"+
    "\2\10\1\0\3\10\3\0\13\10\1\53\5\10\20\0"+
    "\2\10\1\0\3\10\3\0\1\10\1\54\3\10\1\55"+
    "\13\10\20\0\2\10\1\0\3\10\3\0\7\10\1\56"+
    "\11\10\20\0\2\10\1\0\3\10\3\0\13\10\1\57"+
    "\5\10\20\0\2\10\1\0\3\10\3\0\6\10\1\60"+
    "\12\10\20\0\2\10\1\0\3\10\3\0\14\10\1\61"+
    "\4\10\20\0\2\10\1\0\3\10\3\0\1\62\20\10"+
    "\20\0\2\10\1\0\3\10\3\0\6\10\1\63\4\10"+
    "\1\64\5\10\20\0\2\10\1\0\3\10\3\0\2\10"+
    "\1\65\16\10\20\0\2\10\1\0\3\10\3\0\1\66"+
    "\2\10\1\67\15\10\20\0\2\10\1\0\3\10\3\0"+
    "\1\10\1\70\13\10\1\71\3\10\20\0\2\10\1\0"+
    "\3\10\3\0\5\10\1\72\13\10\20\0\2\10\1\0"+
    "\3\10\3\0\5\10\1\73\13\10\61\0\1\74\2\0"+
    "\1\75\47\0\1\76\53\0\1\77\51\0\1\100\4\43"+
    "\1\3\45\43\3\101\1\102\46\101\5\0\2\103\50\0"+
    "\1\104\1\105\57\0\1\106\51\0\1\106\1\0\5\51"+
    "\34\0\2\10\1\0\3\10\3\0\2\10\1\107\16\10"+
    "\20\0\2\10\1\0\3\10\3\0\15\10\1\110\3\10"+
    "\20\0\2\10\1\0\3\10\3\0\6\10\1\111\12\10"+
    "\20\0\2\10\1\0\3\10\3\0\14\10\1\112\4\10"+
    "\20\0\2\10\1\0\3\10\3\0\13\10\1\113\5\10"+
    "\20\0\2\10\1\0\3\10\3\0\7\10\1\114\11\10"+
    "\20\0\2\10\1\0\3\10\3\0\11\10\1\115\7\10"+
    "\20\0\2\10\1\0\3\10\3\0\10\10\1\116\10\10"+
    "\20\0\2\10\1\0\3\10\3\0\3\10\1\117\15\10"+
    "\20\0\2\10\1\0\3\10\3\0\15\10\1\120\3\10"+
    "\20\0\2\10\1\0\3\10\3\0\1\10\1\121\5\10"+
    "\1\122\11\10\20\0\2\10\1\0\3\10\3\0\2\10"+
    "\1\123\10\10\1\124\5\10\20\0\2\10\1\0\3\10"+
    "\3\0\2\10\1\125\16\10\20\0\2\10\1\0\3\10"+
    "\3\0\7\10\1\126\11\10\20\0\2\10\1\0\3\10"+
    "\3\0\12\10\1\127\6\10\13\0\3\101\1\130\46\101"+
    "\2\0\1\3\1\102\53\0\1\103\1\131\1\0\1\46"+
    "\46\0\2\104\1\132\51\0\1\132\47\0\2\10\1\0"+
    "\3\10\3\0\6\10\1\133\12\10\20\0\2\10\1\0"+
    "\3\10\3\0\1\134\20\10\20\0\2\10\1\0\3\10"+
    "\3\0\11\10\1\135\7\10\20\0\2\10\1\0\3\10"+
    "\3\0\14\10\1\136\4\10\20\0\2\10\1\0\3\10"+
    "\3\0\10\10\1\137\10\10\20\0\2\10\1\0\3\10"+
    "\3\0\6\10\1\140\12\10\20\0\2\10\1\0\3\10"+
    "\3\0\4\10\1\141\14\10\20\0\2\10\1\0\3\10"+
    "\3\0\12\10\1\142\6\10\20\0\2\10\1\0\3\10"+
    "\3\0\1\10\1\143\17\10\20\0\2\10\1\0\3\10"+
    "\3\0\15\10\1\144\3\10\20\0\2\10\1\0\3\10"+
    "\3\0\1\10\1\145\17\10\20\0\2\10\1\0\3\10"+
    "\3\0\14\10\1\146\4\10\13\0\2\101\1\3\1\130"+
    "\46\101\5\0\1\103\1\131\50\0\2\147\50\0\2\10"+
    "\1\0\3\10\3\0\6\10\1\150\12\10\20\0\2\10"+
    "\1\0\3\10\3\0\14\10\1\151\4\10\20\0\2\10"+
    "\1\0\3\10\3\0\1\152\20\10\20\0\2\10\1\0"+
    "\3\10\3\0\2\10\1\153\16\10\20\0\2\10\1\0"+
    "\3\10\3\0\2\10\1\154\16\10\20\0\2\10\1\0"+
    "\3\10\3\0\6\10\1\155\12\10\20\0\1\147\1\156"+
    "\50\0\2\10\1\0\3\10\3\0\6\10\1\157\12\10"+
    "\20\0\2\10\1\0\3\10\3\0\16\10\1\160\2\10"+
    "\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3150];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\1\11\22\1\6\11\3\1\1\11"+
    "\1\1\5\0\1\11\2\0\21\1\5\11\2\0\3\1"+
    "\1\11\21\1\3\0\23\1\1\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
private SymbolTable symbolTable;

  /**
   * Creates a new scanner with symbol table inizialization.
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   * @param   inizialize  is @true if the symbolTable must be inizialized, @false otherwise
   */
  public Lexer(java.io.Reader in,  boolean inizialize) {
    this.zzReader = in;
    if(inizialize)
    symbolTable = new SymbolTable("Lexexr");
  }

  /**
   * Creates a new scanner with symbol table inizialization.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   * @param   inizialize  is @true if the symbolTable must be inizialized, @false otherwise
   */
  public Lexer(java.io.InputStream in, boolean inizialize) {
    this(new java.io.InputStreamReader(in));
    if(inizialize)
    symbolTable = new SymbolTable("Lexexr");
  }


	public void cleanSymbolTable() throws IOException{
	
		symbolTable = new SymbolTable("Lexexr");
		
	} 
	
	public SymbolTable getSymbolTable(){

		return symbolTable;
	}
	
	
	


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2238) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { /* ignore */
          }
        case 47: break;
        case 8: 
          { return new Symbol(CircuitSym.COMMA, yyline, yycolumn ,yytext());
          }
        case 48: break;
        case 29: 
          { return new Symbol(CircuitSym.CHAR_CONST, yyline, yycolumn ,yytext());
          }
        case 49: break;
        case 26: 
          { return new Symbol(CircuitSym.GE, yyline, yycolumn ,yytext());
          }
        case 50: break;
        case 18: 
          { return new Symbol(CircuitSym.STRING_CONST, yyline, yycolumn ,yytext());
          }
        case 51: break;
        case 38: 
          { return new Symbol  (CircuitSym.HEAD, yyline, yycolumn );
          }
        case 52: break;
        case 36: 
          { return new Symbol(CircuitSym.THEN, yyline, yycolumn ,yytext());
          }
        case 53: break;
        case 3: 
          { return new Symbol(CircuitSym.DIV, yyline, yycolumn ,yytext());
          }
        case 54: break;
        case 41: 
          { return new Symbol(CircuitSym.FALSE, yyline, yycolumn ,yytext());
          }
        case 55: break;
        case 45: 
          { return new Symbol(CircuitSym.DOUBLE, yyline, yycolumn ,yytext());
          }
        case 56: break;
        case 13: 
          { return new Symbol(CircuitSym.LT, yyline, yycolumn ,yytext());
          }
        case 57: break;
        case 5: 
          { return new Symbol(CircuitSym.INT_CONST, yyline, yycolumn ,yytext());
          }
        case 58: break;
        case 33: 
          { return new Symbol(CircuitSym.INT, yyline, yycolumn ,yytext());
          }
        case 59: break;
        case 9: 
          { return new Symbol(CircuitSym.LPAR, yyline, yycolumn ,yytext());
          }
        case 60: break;
        case 42: 
          { return new Symbol(CircuitSym.START, yyline, yycolumn ,yytext());
          }
        case 61: break;
        case 22: 
          { return new Symbol(CircuitSym.OR, yyline, yycolumn ,yytext());
          }
        case 62: break;
        case 15: 
          { return new Symbol(CircuitSym.GT, yyline, yycolumn ,yytext());
          }
        case 63: break;
        case 20: 
          { return new Symbol(CircuitSym.IN, yyline, yycolumn ,yytext());
          }
        case 64: break;
        case 14: 
          { return new Symbol(CircuitSym.MINUS, yyline, yycolumn ,yytext());
          }
        case 65: break;
        case 35: 
          { return new Symbol(CircuitSym.TRUE, yyline, yycolumn ,yytext());
          }
        case 66: break;
        case 30: 
          { return new Symbol(CircuitSym.NOT, yyline, yycolumn ,yytext());
          }
        case 67: break;
        case 17: 
          { return new Symbol(CircuitSym.ASSIGN, yyline, yycolumn ,yytext());
          }
        case 68: break;
        case 43: 
          { return new Symbol(CircuitSym.INOUT, yyline, yycolumn ,yytext());
          }
        case 69: break;
        case 44: 
          { return new Symbol(CircuitSym.WHILE, yyline, yycolumn ,yytext());
          }
        case 70: break;
        case 27: 
          { return new Symbol(CircuitSym.EQ, yyline, yycolumn ,yytext());
          }
        case 71: break;
        case 28: 
          { return new Symbol(CircuitSym.DOUBLE_CONST, yyline, yycolumn ,yytext());
          }
        case 72: break;
        case 19: 
          { return new Symbol(CircuitSym.DO, yyline, yycolumn ,yytext());
          }
        case 73: break;
        case 10: 
          { return new Symbol(CircuitSym.RPAR, yyline, yycolumn ,yytext());
          }
        case 74: break;
        case 1: 
          { System.out.println("ERRORE....."+yytext() +" "+yyline+" "+yycolumn );  return new Symbol(CircuitSym.error);
          }
        case 75: break;
        case 11: 
          { return new Symbol(CircuitSym.LGPAR, yyline, yycolumn ,yytext());
          }
        case 76: break;
        case 32: 
          { return new Symbol(CircuitSym.DEF, yyline, yycolumn ,yytext());
          }
        case 77: break;
        case 40: 
          { return new Symbol(CircuitSym.CHAR, yyline, yycolumn ,yytext());
          }
        case 78: break;
        case 25: 
          { return new Symbol(CircuitSym.WRITE, yyline, yycolumn ,yytext());
          }
        case 79: break;
        case 23: 
          { return new Symbol(CircuitSym.READ, yyline, yycolumn ,yytext());
          }
        case 80: break;
        case 21: 
          { return new Symbol(CircuitSym.IF, yyline, yycolumn ,yytext());
          }
        case 81: break;
        case 4: 
          { return new Symbol(CircuitSym.TIMES, yyline, yycolumn ,yytext());
          }
        case 82: break;
        case 39: 
          { return new Symbol(CircuitSym.ELSE, yyline, yycolumn ,yytext());
          }
        case 83: break;
        case 37: 
          { return new Symbol(CircuitSym.BOOL, yyline, yycolumn ,yytext());
          }
        case 84: break;
        case 6: 
          { /*try {System.out.print("Lexer...");symbolTable.installID(new Identifier(yytext()));} catch (MultipleDeclaretionException e) {
					} */return new Symbol(CircuitSym.ID, yyline, yycolumn ,yytext());
          }
        case 85: break;
        case 31: 
          { return new Symbol(CircuitSym.AND, yyline, yycolumn ,yytext());
          }
        case 86: break;
        case 7: 
          { return new Symbol(CircuitSym.SEMI, yyline, yycolumn ,yytext());
          }
        case 87: break;
        case 16: 
          { return new Symbol(CircuitSym.PLUS, yyline, yycolumn ,yytext());
          }
        case 88: break;
        case 24: 
          { return new Symbol(CircuitSym.LE, yyline, yycolumn ,yytext());
          }
        case 89: break;
        case 46: 
          { return new Symbol(CircuitSym.STRING, yyline, yycolumn ,yytext());
          }
        case 90: break;
        case 34: 
          { return new Symbol(CircuitSym.OUT, yyline, yycolumn ,yytext());
          }
        case 91: break;
        case 12: 
          { return new Symbol(CircuitSym.RGPAR, yyline, yycolumn ,yytext());
          }
        case 92: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                return new Symbol(CircuitSym.EOF);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
