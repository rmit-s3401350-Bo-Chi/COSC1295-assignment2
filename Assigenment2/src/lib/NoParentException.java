package lib;
/*
 * ***@author qiaoxi li
 */

public class NoParentException extends Exception {
    public NoParentException()
    {
    	super("A Child must have two parent!!!");
    }


}
