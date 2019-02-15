package com.kbein.algorithm.bracketCheck;

import java.util.Stack;

/**
 * com.kbein.algorithm.bracketCheck
 * Created by KBein on 2019/2/15 16:08
 */

/**
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *有效字符串需满足：
 *左括号必须用相同类型的右括号闭合。
 *左括号必须以正确的顺序闭合。
 *注意空字符串可被认为是有效字符串。
 */
public class CheckValid {

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currChar = chars[i];
            if (currChar == '('){
                characterStack.push(currChar);
            }else if (currChar == ')'){
                if (characterStack.empty()){
                    return false;
                }else {
                    Character currCharacterStack = characterStack.pop();
                    if (currCharacterStack != '('){
                        return false;
                    }
                }
            }else if (currChar == '['){
                characterStack.push(currChar);
            }else if (currChar == ']'){
                if (characterStack.empty()){
                    return false;
                }else {
                    Character currCharacterStack = characterStack.pop();
                    if (currCharacterStack != '['){
                        return false;
                    }
                }
            }else if (currChar == '{'){
                characterStack.push(currChar);
            }else if (currChar == '}'){
                if (characterStack.empty()){
                    return false;
                }else {
                    Character currCharacterStack = characterStack.pop();
                    if (currCharacterStack != '{'){
                        return false;
                    }
                }
            }
        }

        if(characterStack.empty()){
            return true;
        }
        return false;
    }


}
