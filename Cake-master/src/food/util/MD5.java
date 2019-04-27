package food.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5 {
    /**
     * 封装好的基于java实现的md5加密的方法
     * @param password
     * @return
     */
    public static String genertedPassword(String password){
        byte[]  bs=null;
        String p=null;
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            bs=md.digest();
            System.out.println(Arrays.toString(bs));
            p=new BigInteger(1,bs).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return p;
    }


    /*  对密码添加用户名对加盐操作方法
     @param nickname
     @param password
     @return*/

    public static String  addSoltToPassword(String nickname,String password){
        StringBuffer ss=new StringBuffer(password);
        for(int n=0;n<nickname.length();n++){
            nickname.charAt(n);
            if(n%2==0)
            {
                ss.append(nickname.charAt(n));
            }
            else {
                ss.insert(0, nickname.charAt(n));
            }

        }
        return ss.toString();
    }

    public static void main(String[] args) {
        System.out.println(genertedPassword("123"));
    }
}